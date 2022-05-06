package cbass.restapidesafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cbass.restapidesafio.databinding.ActivityMainBinding
import cbass.restapidesafio.viewmodel.UserVM

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val viewModel by viewModels<UserVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getData()
    }
}