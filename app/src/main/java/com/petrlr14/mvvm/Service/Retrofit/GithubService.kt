package com.petrlr14.mvvm.Service.Retrofit

import com.petrlr14.mvvm.database.entities.GitHubRepo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users/{usuario}/repos")
    fun getRepos(@Path("usuario") usuario:String) : Deferred<Response<List<GitHubRepo>>>

}