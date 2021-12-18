package com.length.icthack3.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.length.icthack3.R
import com.length.icthack3.presentation.viewModels.ProfileViewModel

class ProfileFragment: Fragment() {
    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    val navController = Navigation.findNavController(requireActivity(), R.id.container)
                    navController.navigate(R.id.action_profileFragment_to_gameFragment2)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this@ProfileFragment, callback)

    }

}