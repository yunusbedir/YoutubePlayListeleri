package com.example.yunus.youtubeplaylisteleri

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //GET https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCRPMOM6Tb5uBBp2DCzQ4EJQ&maxResults=20&key={YOUR_API_KEY}
    @GET("playlists?part=snippet")
    fun tumListeleriGetir(@Query("channelId") channelId:String
                          ,@Query("key") apiKey : String
                          ,@Query("maxResults") limit:Int) : Call<PlaylistData>
}