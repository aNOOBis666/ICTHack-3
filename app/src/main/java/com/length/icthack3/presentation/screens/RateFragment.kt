package com.length.icthack3.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.length.icthack3.R
import com.length.icthack3.presentation.adapters.RateAdapter
import com.length.icthack3.presentation.viewModels.RateViewModel

class RateFragment: Fragment() {
    companion object {
        fun newInstance() = RateFragment()
    }

    private val viewModel: RateViewModel by viewModels()
    private var recyclerView: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.rate_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    val navController = Navigation.findNavController(requireActivity(), R.id.container)
                    navController.navigate(R.id.action_rateFragment_to_gameFragment2)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this@RateFragment, callback)
        this.recyclerView = view.findViewById(R.id.rateRecycler)
        viewModel.getUserList()
        viewModel.usersData?.observe(this, Observer {recyclerCreation()})
    }

    private fun recyclerCreation(){
        val users = viewModel.usersData?.value
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView?.adapter = RateAdapter(users!!)
    }
}