package com.jkuhail.androidexam.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jkuhail.androidexam.*
import com.jkuhail.androidexam.adapters.MainAdapter
import com.jkuhail.androidexam.databinding.FragmentFeedBinding
import com.jkuhail.androidexam.models.Item

class FeedFragment : Fragment(), MainAdapter.EventListener {
    private lateinit var binding: FragmentFeedBinding


    private var items: ArrayList<Item> = ArrayList()
    private lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        init()
        addItems()


        return binding.root
    }


    private fun addItems() {
        items.add(
            Item(
                R.drawable.image,
                "כמה אתם מבינים בסרטים?",
                "גלו כמה אתם בעלי הבנה בתחום"
            )
        )
        items.add(
            Item(
                R.drawable.image,
                "כמה אתם מבינים בסרטים?",
                "גלו כמה אתם בעלי הבנה בתחום"
            )
        )
        items.add(
            Item(
                R.drawable.image,
                "כמה אתם מבינים בסרטים?",
                "גלו כמה אתם בעלי הבנה בתחום"
            )
        )
    }

    override fun onSlide() {
        if (binding.viewPager.currentItem >= items.size - 2 && items.size > 2) {
            items.addAll(items)
            binding.viewPager.adapter!!.notifyDataSetChanged()
        }
    }

    private fun init() {
        adapter =
            MainAdapter(requireContext(), items, this)
        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 1
    }


}