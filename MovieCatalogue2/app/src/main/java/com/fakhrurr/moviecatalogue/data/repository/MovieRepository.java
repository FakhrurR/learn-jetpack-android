package com.fakhrurr.moviecatalogue.data.repository;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.fakhrurr.moviecatalogue.data.local.LocalDataSource;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.data.model.tvshow.detail.DetailTVResponse;
import com.fakhrurr.moviecatalogue.data.repository.source.ApiResponse;
import com.fakhrurr.moviecatalogue.data.repository.source.MovieSourceData;
import com.fakhrurr.moviecatalogue.data.repository.source.RemoteDataSource;
import com.fakhrurr.moviecatalogue.utils.AppExecutors;
import com.fakhrurr.moviecatalogue.utils.NetworkBoundResource;
import com.fakhrurr.moviecatalogue.vo.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;
import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;

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
                if(INSTANCE == null) {
                    INSTANCE = new MovieRepository(remoteDataSource, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<MovieEntity>> getDetailMovieResponse(int id) {
        return new NetworkBoundResource<MovieEntity, ResultsItemMovie>(appExecutors) {

            @Override
            protected LiveData<MovieEntity> loadFromDB() {
                return localDataSource.getMovieById(id);
            }

            @Override
            protected Boolean shouldFetch(MovieEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<ResultsItemMovie>> createCall() {
                return remoteDataSource.getDetailMovie(id);
            }

            @Override
            protected void saveCallResult(ResultsItemMovie data) {}
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getListNowPlaying() {
        return new NetworkBoundResource<List<MovieEntity>, List<ResultsItemMovie>>(appExecutors) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localDataSource.getMovies();
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null || data.size() == 0);
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
                            item.getVoteAverage(),
                            MOVIE_TYPE));
                }
                localDataSource.insertMovies(movieEntityList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MovieEntity>> getDetailTVShowResponse(int id) {
        return new NetworkBoundResource<MovieEntity, DetailTVResponse>(appExecutors) {

            @Override
            protected LiveData<MovieEntity> loadFromDB() {
                return localDataSource.getTVShowById(id);
            }

            @Override
            protected Boolean shouldFetch(MovieEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<DetailTVResponse>> createCall() {
                return remoteDataSource.getDetailTVShow(id);
            }

            @Override
            protected void saveCallResult(DetailTVResponse data) {}
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getListAiringToday() {
        return new NetworkBoundResource<List<MovieEntity>, List<ResultsItemTVAiringToday>>(appExecutors) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localDataSource.getTVShow();
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null || data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<ResultsItemTVAiringToday>>> createCall() {
                return remoteDataSource.getTVAiringToday();
            }

            @Override
            protected void saveCallResult(List<ResultsItemTVAiringToday> data) {
                List<MovieEntity> movieEntityList = new ArrayList<>();
                for(ResultsItemTVAiringToday item: data) {
                    movieEntityList.add(new MovieEntity(item.getId(),
                            item.getName(),
                            item.getOverview(),
                            item.getPosterPath(),
                            item.getBackdropPath(),
                            item.getFirstAirDate(),
                            item.getVoteAverage(),
                            TV_SHOW_TYPE));
                }
                localDataSource.insertMovies(movieEntityList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getFavoriteMovies() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItemMovie>>(appExecutors) {

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localDataSource.getFavoriteMovies(), 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<ResultsItemMovie>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<ResultsItemMovie> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getFavoriteTvShows() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItemMovie>>(appExecutors) {

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localDataSource.getFavoriteTvShows(), 10).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<ResultsItemMovie>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<ResultsItemMovie> data) {

            }
        }.asLiveData();
    }

    @Override
    public void setFavoriteStatus(MovieEntity movieEntity) {
        boolean status = !movieEntity.isStatus();
        movieEntity.setStatus(status);
        Runnable runnable = () -> localDataSource.updateFavoriteStatus(movieEntity);
        appExecutors.diskIO().execute(runnable);
    }
}
