package com.selfcompany.faizf.seemovie.domain.interactor

import com.selfcompany.faizf.seemovie.data.entity.movie.VideoMovieEntity
import com.selfcompany.faizf.seemovie.domain.repository.VideoMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class VideoMovie  @Inject constructor() : UseCase<VideoMovieEntity, String>() {

    @Inject
    lateinit var videoMovieRepository: VideoMovieRepository

    override fun buildUseCaseObservable(params: String): Observable<VideoMovieEntity> {
        return videoMovieRepository.getListVideo(params)
    }
}