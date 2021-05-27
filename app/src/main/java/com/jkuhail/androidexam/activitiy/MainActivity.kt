package com.jkuhail.androidexam.activitiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.transition.TransitionManager
import com.jkuhail.androidexam.R

import com.jkuhail.androidexam.databinding.ActivityMainBinding
import com.jkuhail.androidexam.fragment.DoingGoodFragment
import com.jkuhail.androidexam.fragment.FeedFragment
import com.jkuhail.androidexam.fragment.PreziFragment
import com.jkuhail.androidexam.fragment.ProfileFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()

    }


    private fun setUpNavigation() {
        navController = findNavController(R.id.nav_host_fragment_bottom)
        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            navController
        )
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            underlineSelectedItem(binding.constraintLayout, item.itemId)
            true
        }
    }

    private fun underlineSelectedItem(view: View, itemId: Int) {
        val constraintLayout: ConstraintLayout = view as ConstraintLayout
        TransitionManager.beginDelayedTransition(constraintLayout)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.setHorizontalBias(
            R.id.underline,
            getItemPosition(itemId) * 0.33f
        )
        constraintSet.applyTo(constraintLayout)
    }

    private fun getItemPosition(itemId: Int): Int {
        return when (itemId) {
            R.id.feed -> 0
            R.id.prezi -> 1
            R.id.doing_good -> 2
            R.id.profile -> 3
            else -> 0
        }
    }


}