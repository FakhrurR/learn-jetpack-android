package com.fakhrurr.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.repository.MovieRepository;
import com.fakhrurr.moviecatalogue.vo.Resource;

import static com.fakhrurr.moviecatalogue.utils.Constants.MOVIE_TYPE;
import static com.fakhrurr.moviecatalogue.utils.Constants.TV_SHOW_TYPE;

public class DetailTVShowModel extends ViewModel {
    private MovieRepository movieRepository;
    private final MutableLiveData<Integer> id = new MutableLiveData<>();
    private LiveData<Resource<MovieEntity>> result;
    private int type;

    public LiveData<Resource<MovieEntity>> detail = Transformations.switchMap(id, data -> {
        switch (type) {
            case MOVIE_TYPE:
                result = movieRepository.getDetailMovieResponse(getId());
                break;
            case TV_SHOW_TYPE:
                result = movieRepository.getDetailTVShowResponse(getId());
        }
        return result;
    });

    public DetailTVShowModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public int getId() {
        return id.getValue() != null ? id.getValue(): 1;
    }

    public void setId(int id) {
        this.id.setValue(id);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFavorite() {
        if (detail.getValue() != null) {
            MovieEntity entity = detail.getValue().data;
            assert entity != null;
            movieRepository.setFavoriteStatus(entity);
        }
    }
}
