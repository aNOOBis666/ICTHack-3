package com.length.icthack3.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.length.icthack3.R
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.length.icthack3.presentation.viewModels.GameViewModel


class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    Replace with navigation by bottomNavBar
    private fun navigateToRegistrationFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
//        navController.navigate(R.id.action_enterFragment2_to_registrationFragment2)
    }

    private fun navigateToMainFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
//        navController.navigate(R.id.action_enterFragment2_to_mainFragment)
    }

}