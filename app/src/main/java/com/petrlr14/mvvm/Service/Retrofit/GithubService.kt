package com.petrlr14.mvvm.Service.Retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.petrlr14.mvvm.database.entities.GitHubRepo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users/{usuario}/repos")
    fun getRepos(@Path("usuario") usuario:String) : Deferred<Response<List<GitHubRepo>>>

    companion object {
        fun getGithubServices() : GithubService{
            return  Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(GithubService::class.java)
        }
    }
}