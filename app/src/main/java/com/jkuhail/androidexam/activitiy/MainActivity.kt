package com.jkuhail.androidexam.activitiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jkuhail.androidexam.R

import com.jkuhail.androidexam.databinding.ActivityMainBinding
import com.jkuhail.androidexam.fragment.DoingGoodFragment
import com.jkuhail.androidexam.fragment.FeedFragment
import com.jkuhail.androidexam.fragment.PreziFragment
import com.jkuhail.androidexam.fragment.ProfileFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
        starter()
    }


    private fun setUpNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun starter(){
        replaceFragment(FeedFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit()
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.feed -> selectedFragment = FeedFragment()
            R.id.prezi -> selectedFragment = PreziFragment()
            R.id.doing_good -> selectedFragment = DoingGoodFragment()
            R.id.profile -> selectedFragment = ProfileFragment()
        }
        replaceFragment(selectedFragment)
        underlineSelectedItem (binding.constraintLayout, item.itemId)
        return true
    }


}