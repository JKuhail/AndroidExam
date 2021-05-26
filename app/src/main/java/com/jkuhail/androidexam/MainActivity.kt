package com.jkuhail.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.jkuhail.androidexam.databinding.ActivityMainBinding
import com.jkuhail.androidexam.fragments.DoingGoodFragment
import com.jkuhail.androidexam.fragments.FeedFragment
import com.jkuhail.androidexam.fragments.PreziFragment
import com.jkuhail.androidexam.fragments.ProfileFragment

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        starter()

        binding.layoutFeed.setOnClickListener(this)
        binding.layoutMyPrezi.setOnClickListener(this)
        binding.layoutGood.setOnClickListener(this)
        binding.layoutProfile.setOnClickListener(this)

    }

    private fun starter(){
        binding.feedTv.setTextColor(resources.getColor(R.color.colorAccent))
        binding.feedImg.setColorFilter(resources.getColor(R.color.colorAccent))
        binding.lineFeed.visibility = View.VISIBLE
        switchFragment(FeedFragment())
    }

    private fun resetBottomSheet() {
        binding.feedTv.setTextColor(resources.getColor(R.color.grayb4))
        binding.feedImg.setColorFilter(resources.getColor(R.color.grayb4))
        binding.lineFeed.visibility = View.INVISIBLE
        binding.myPreziTv.setTextColor(resources.getColor(R.color.grayb4))
        binding.myPreziImg.setColorFilter(resources.getColor(R.color.grayb4))
        binding.lineMyPrezi.visibility = View.INVISIBLE
        binding.goodTv.setTextColor(resources.getColor(R.color.grayb4))
        binding.goodImg.setColorFilter(resources.getColor(R.color.grayb4))
        binding.lineGood.visibility = View.INVISIBLE
        binding.profileTv.setTextColor(resources.getColor(R.color.grayb4))
        binding.profileImg.setColorFilter(resources.getColor(R.color.grayb4))
        binding.lineProfile.visibility = View.INVISIBLE
    }

    private fun switchFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!).commit()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.layoutFeed ->{
                resetBottomSheet()
                binding.feedTv.setTextColor(resources.getColor(R.color.colorAccent))
                binding.feedImg.setColorFilter(resources.getColor(R.color.colorAccent))
                binding.lineFeed.visibility = View.VISIBLE
                switchFragment(FeedFragment())
            }
            R.id.layoutMyPrezi ->{
                resetBottomSheet()
                binding.myPreziTv.setTextColor(resources.getColor(R.color.colorAccent))
                binding.myPreziImg.setColorFilter(resources.getColor(R.color.colorAccent))
                binding.lineMyPrezi.visibility = View.VISIBLE
                switchFragment(PreziFragment())
            }
            R.id.layoutGood ->{
                resetBottomSheet()
                binding.goodTv.setTextColor(resources.getColor(R.color.colorAccent))
                binding.goodImg.setColorFilter(resources.getColor(R.color.colorAccent))
                binding.lineGood.visibility = View.VISIBLE
                switchFragment(DoingGoodFragment())
            }
            R.id.layoutProfile->{
                resetBottomSheet()
                binding.profileTv.setTextColor(resources.getColor(R.color.colorAccent))
                binding.profileImg.setColorFilter(resources.getColor(R.color.colorAccent))
                binding.lineProfile.visibility = View.VISIBLE
                switchFragment(ProfileFragment())
            }
        }
    }
}