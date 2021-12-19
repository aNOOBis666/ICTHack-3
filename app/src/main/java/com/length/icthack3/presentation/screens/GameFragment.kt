package com.length.icthack3.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.length.icthack3.R
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
        val profile = view.findViewById<FloatingActionButton>(R.id.buttonProfile)
        val rate = view.findViewById<FloatingActionButton>(R.id.buttonRate)
        val shop = view.findViewById<FloatingActionButton>(R.id.buttonShop)

        viewModel.getAnimals()

        profile.setOnClickListener{
            navigateToProfileFragment()
        }

        rate.setOnClickListener{
            navigateToRateFragment()
        }

        shop.setOnClickListener {
            navigateToShopFragment()
        }
    }

//    Replace with navigation by bottomNavBar
    private fun navigateToProfileFragment(){


    }

    private fun navigateToRateFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(R.id.action_gameFragment_to_rateFragment)
    }

    private fun navigateToShopFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(R.id.action_gameFragment_to_shopFragment)
    }

}