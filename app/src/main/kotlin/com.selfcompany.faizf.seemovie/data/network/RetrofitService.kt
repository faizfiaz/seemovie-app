package com.selfcompany.faizf.seemovie.data.network

import android.content.Context
import com.selfcompany.faizf.newbase.repository.session.SessionToken
import com.selfcompany.faizf.seemovie.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by faizf on 07/03/2018.
 */
class RetrofitService {
    companion object {
        private val BASE_URL: String = BuildConfig.URL_BASE
        private var retrofit: Retrofit? = null

        fun getClient(context: Context): Retrofit? {
            val token = SessionToken(context)
            val interceptor = Interceptor { chain ->
                val request = chain.request().newBuilder()
                        .addHeader("X-AUTH-TOKEN", token.token)
                        .build()
                chain.proceed(request)
            }
            val httpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
            val client = httpClient.build()

            val rxRetro = RxJava2CallAdapterFactory.create()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(rxRetro)
                        .client(client)
                        .build()
            }
            return retrofit
        }

    }
}