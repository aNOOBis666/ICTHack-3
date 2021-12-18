package com.length.icthack3.ui.main.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.length.icthack3.R
import com.length.icthack3.ui.main.viewModels.MainViewModel
import com.length.icthack3.ui.main.viewModels.RegistrationViewModel


class RegistrationFragment: Fragment() {
    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.registration_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun navigateToEntryFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(R.id.action_registrationFragment2_to_enterFragment2)
    }

    private fun navigateToMainFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(R.id.action_registrationFragment2_to_mainFragment)
    }
}