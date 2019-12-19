package com.example.youtubeparcer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeparcer.api.RetrofitClient
import com.example.youtubeparcer.api.YouTubeApi
import com.example.youtubeparcer.model.PlaylistModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    companion object{
        val channel = "UC_IfiZu3VkesO3L58L9WPhA"
        val apiKey = "AIzaSyCWK-EoCHecYMMFAvl-DI5iegR9s1WW20Y"
        val part = "snippet,contentDetails"
        val maxResult = "50"

        private lateinit var apiServise: YouTubeApi

        fun fetchYouTubePlayListModel(): LiveData<PlaylistModel>{
        apiServise = RetrofitClient.create()
            val data = MutableLiveData<PlaylistModel>()
            apiServise.getPlayList(part, apiKey, channel, maxResult).enqueue(object : Callback<PlaylistModel> {

                override fun onFailure(call: Call<PlaylistModel>, t: Throwable) {

                    data.value = null
                }

                override fun onResponse(
                    call: Call<PlaylistModel>,
                    response: Response<PlaylistModel>
                ) {
                    data.value = response.body()
                }

            })
            return data
        }
    }
}