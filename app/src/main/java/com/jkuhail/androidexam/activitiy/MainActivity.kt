package com.jkuhail.androidexam.activitiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.jkuhail.androidexam.R

import com.jkuhail.androidexam.databinding.ActivityMainBinding
import com.jkuhail.androidexam.fragment.DoingGoodFragment
import com.jkuhail.androidexam.fragment.FeedFragment
import com.jkuhail.androidexam.fragment.PreziFragment
import com.jkuhail.androidexam.fragment.ProfileFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectFeed()

        binding.layoutFeed.setOnClickListener(this)
        binding.layoutMyPrezi.setOnClickListener(this)
        binding.layoutGood.setOnClickListener(this)
        binding.layoutProfile.setOnClickListener(this)

    }


    private fun refreshNavigationBar() {
        binding.feedTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.feedImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.grey_color
            )
        )
        binding.line1.visibility = View.INVISIBLE
        binding.myPreziTv.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.grey_color
            )
        )
        binding.myPreziImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.grey_color
            )
        )
        binding.line2.visibility = View.INVISIBLE
        binding.goodTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.goodImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.grey_color
            )
        )
        binding.line3.visibility = View.INVISIBLE
        binding.profileTv.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.grey_color
            )
        )
        binding.profileImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.grey_color
            )
        )
        binding.line4.visibility = View.INVISIBLE
    }

    private fun replaceFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!).commit()
    }

    private fun selectFeed() {
        refreshNavigationBar()
        binding.feedTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
        binding.feedImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        binding.line1.visibility = View.VISIBLE
        replaceFragment(FeedFragment())
    }

    private fun selectPrezi() {
        refreshNavigationBar()
        binding.myPreziTv.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        binding.myPreziImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        binding.line2.visibility = View.VISIBLE
        replaceFragment(PreziFragment())
    }

    private fun selectGoodToKnow() {
        refreshNavigationBar()
        binding.goodTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
        binding.goodImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        binding.line3.visibility = View.VISIBLE
        replaceFragment(DoingGoodFragment())
    }

    private fun selectProfile() {
        refreshNavigationBar()
        binding.profileTv.setTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        binding.profileImg.setColorFilter(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        binding.line4.visibility = View.VISIBLE
        replaceFragment(ProfileFragment())
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.layoutFeed -> {
                selectFeed()
            }
            R.id.layoutMyPrezi -> {
                selectPrezi()
            }
            R.id.layoutGood -> {
                selectGoodToKnow()
            }
            R.id.layoutProfile -> {
                selectProfile()
            }
        }
    }
}