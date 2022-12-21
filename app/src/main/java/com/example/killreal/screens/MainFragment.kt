package com.example.killreal.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.killreal.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment: Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.mainBottomNAvigationView)
        val navController = (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        //val navHost = childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment
        //NavigationUI.setupWithNavController(R.id.mainBottomNAvigationView, navHost.navController)
    }
}