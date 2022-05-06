package cbass.restapidesafio.client

import cbass.restapidesafio.service.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        val base_url = "https://jsonplaceholder.typicode.com/"

        fun getInstance(baseUrl:String): UsersService
        {
            val retrofit = Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(UsersService::class.java)
        }
    }
}