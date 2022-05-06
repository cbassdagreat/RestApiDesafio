package cbass.restapidesafio.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbass.restapidesafio.client.ClientRetrofit
import cbass.restapidesafio.model.Users
import cbass.restapidesafio.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserVM(application: Application):AndroidViewModel(application){
    val users = MutableLiveData<Users>()
    val user = MutableLiveData<UsersItem>()

    fun getData(){
        val service = ClientRetrofit.getInstance(ClientRetrofit.base_url)
        service.getUsers().enqueue(object : Callback<Users>{
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                response.body().let{
                    users.postValue(it)
                    Log.d("API",response.body().toString())
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("CALL", t.message.toString())
            }

        })

    }

}