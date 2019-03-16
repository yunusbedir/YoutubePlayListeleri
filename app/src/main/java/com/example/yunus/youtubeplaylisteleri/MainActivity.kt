package com.example.yunus.youtubeplaylisteleri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import android.support.*

class MainActivity : AppCompatActivity() {
    val API_KEY = "AIzaSyC7Q5PlnV-yd1c-KpJgGhy9k1_UAID0qhU"
    val CHENNEL_ID = "UCrVR30q-Seo82gBhmAe_1uQ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //retrofit ile interface arasındaki bağlantıyı kuruyoruz
        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.tumListeleriGetir(CHENNEL_ID,API_KEY)

        apiCall?.enqueue(object:Callback<PlaylistData>{
            override fun onFailure(call: Call<PlaylistData>, t: Throwable) {
                //hata da çalışacak kısım
                Log.e("BASARILI" ,"1 - " + t?.printStackTrace() + " " + t?.toString())
                Log.e("BASARILI" , "1 - " + call?.request()?.url()?.toString())
            }
            override fun onResponse(call: Call<PlaylistData>, response: Response<PlaylistData>) {
                //veriler response listesine atılıyor ve bizde oradan çekiyoruz
                Log.e("BASARILI" , "" + call?.request()?.url()?.toString())
                Log.e("BASARILI" , "" + response?.body()?.items?.get(0)?.snippet?.title.toString())
                for(i in 0..(response?.body()?.items?.size!!)){
                    Log.e("BASARILI" , "" + i + " - " + response?.body()?.items?.get(i)?.snippet?.title.toString())
                }

            }

        })
    }
}
