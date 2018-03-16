package com.selfcompany.faizf.seemovie.data.network

/**
 * Created by faizf on 07/03/2018.
 */
class URL {
    companion object {
        var apiKey : String = "43954c2d8a99381ff77508aeaa6d3a1a"

        var nowPlaying : String = "https://api.themoviedb.org/3/movie/now_playing?api_key=$apiKey&language=en-US&page=1"
        var popular : String = "https://api.themoviedb.org/3/movie/popular?api_key=$apiKey&language=en-US&page=1"
        var topRated : String = "https://api.themoviedb.org/3/movie/top_rated?api_key=$apiKey&language=en-US&page=1"
        var upcoming : String = "https://api.themoviedb.org/3/movie/upcoming?api_key=$apiKey&language=en-US&page=1"

        fun detailMovie(id : String): String{
            return "https://api.themoviedb.org/3/movie/$id?api_key=$apiKey&language=en-US"
        }

        fun video(id : String): String{
            return "https://api.themoviedb.org/3/movie/$id/videos?api_key=$apiKey&language=en-US"
        }

        fun recommendation(id : String): String{
            return "https://api.themoviedb.org/3/movie/$id/recommendations?api_key=$apiKey&language=en-US&page=1"
        }


    }
}