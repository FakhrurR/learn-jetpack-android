package com.fakhrurr.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fakhrurr.moviecatalogue.data.local.LocalDataSource;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieDetailEntity;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.detail.DetailMovieResponse;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.repository.source.ApiResponse;
import com.fakhrurr.moviecatalogue.data.repository.source.MovieSourceData;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.AppExecutors;
import com.fakhrurr.moviecatalogue.utils.NetworkBoundResource;
import com.fakhrurr.moviecatalogue.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements MovieSourceData {
    private volatile static MovieRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    public MovieRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static MovieRepository getINSTANCE(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MovieRepository.class) {
                INSTANCE = new MovieRepository(remoteDataSource, localDataSource, appExecutors);
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<DetailMovieResponse>> getDetailMovieResponse(int id) {
        MutableLiveData<DetailMovieResponse> data = new MutableLiveData<>();
        return new NetworkBoundResource<MovieDetailEntity, DetailMovieResponse>(appExecutors) {
            @Override
            protected LiveData<MovieDetailEntity> loadFromDB() {
                return localDataSource.getMovieById(id);
            }

            @Override
            protected Boolean shouldFetch(MovieDetailEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<DetailMovieResponse>> createCall() {
                return remoteDataSource.getDetailMovie(id);
            }

            @Override
            protected void saveCallResult(DetailMovieResponse data) {
                DetailMovieResponse detailMovieResponse = new DetailMovieResponse();
                detailMovieResponse.setTitle(data.getTitle());
                detailMovieResponse.setReleaseDate(data.getReleaseDate());
                detailMovieResponse.setOverview(data.getOverview());
                detailMovieResponse.setId(data.getId());
                detailMovieResponse.setVoteAverage(data.getVoteAverage());
                detailMovieResponse.setPosterPath(data.getPosterPath());
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<DetailMovieResponse>> getListNowPlaying() {
        return new NetworkBoundResource<List<MovieEntity>, List<ResultsItemMovie>>(appExecutors) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localDataSource.getMovies();
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<List<ResultsItemMovie>>> createCall() {
                return remoteDataSource.getNowPlaying();
            }

            @Override
            protected void saveCallResult(List<ResultsItemMovie> data) {
                List<MovieEntity> movieEntityList = new ArrayList<>();
                for(ResultsItemMovie item: data) {
                    movieEntityList.add(new MovieEntity(item.getId(),
                            item.getTitle(),
                            item.getOverview(),
                            item.getPosterPath(),
                            item.getBackdropPath(),
                            item.getReleaseDate(),
                            item.getVoteAverage()));
                }

            }
        }.asLiveData();
    }
}
