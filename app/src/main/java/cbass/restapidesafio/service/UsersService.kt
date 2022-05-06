package cbass.restapidesafio.service

import cbass.restapidesafio.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface UsersService {

    @GET("users")
    fun getUsers(): Call<Users>
}