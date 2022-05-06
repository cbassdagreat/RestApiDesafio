package cbass.restapidesafio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cbass.restapidesafio.R
import cbass.restapidesafio.adapter.UsersAdapter
import cbass.restapidesafio.databinding.FragmentMainBinding
import cbass.restapidesafio.viewmodel.UserVM

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val viewModel by activityViewModels<UserVM>()
    private val adapter = UsersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        val manager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvUsers.adapter = adapter
            rvUsers.layoutManager = manager
        }
        viewModel.users.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
        return binding.root
    }


}