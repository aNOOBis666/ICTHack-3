package com.length.icthack3.ui.main.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.length.icthack3.R
import com.length.icthack3.ui.main.viewModels.EnterViewModel
import com.length.icthack3.ui.main.viewModels.RegistrationViewModel

class EnterFragment: Fragment() {
    companion object {
        fun newInstance() = EnterFragment()
    }

    private val viewModel: EnterViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.enter_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun navigateToRegistrationFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(R.id.action_enterFragment2_to_registrationFragment2)
    }

    private fun navigateToMainFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(R.id.action_enterFragment2_to_mainFragment)
    }
}