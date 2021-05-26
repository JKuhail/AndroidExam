package com.jkuhail.androidexam.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.jkuhail.androidexam.R

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
        binding.feedTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
        binding.feedImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.colorAccent))
        binding.lineFeed.visibility = View.VISIBLE
        replaceFragment(FeedFragment())
    }

    private fun resetBottomSheet() {
        binding.feedTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.feedImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.lineFeed.visibility = View.INVISIBLE
        binding.myPreziTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.myPreziImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.lineMyPrezi.visibility = View.INVISIBLE
        binding.goodTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.goodImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.lineGood.visibility = View.INVISIBLE
        binding.profileTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.profileImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.grey_color))
        binding.lineProfile.visibility = View.INVISIBLE
    }

    private fun replaceFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!).commit()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.layoutFeed ->{
                resetBottomSheet()
                binding.feedTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.feedImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.lineFeed.visibility = View.VISIBLE
                replaceFragment(FeedFragment())
            }
            R.id.layoutMyPrezi ->{
                resetBottomSheet()
                binding.myPreziTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.myPreziImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.lineMyPrezi.visibility = View.VISIBLE
                replaceFragment(PreziFragment())
            }
            R.id.layoutGood ->{
                resetBottomSheet()
                binding.goodTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.goodImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.lineGood.visibility = View.VISIBLE
                replaceFragment(DoingGoodFragment())
            }
            R.id.layoutProfile ->{
                resetBottomSheet()
                binding.profileTv.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.profileImg.setColorFilter(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                binding.lineProfile.visibility = View.VISIBLE
                replaceFragment(ProfileFragment())
            }
        }
    }
}