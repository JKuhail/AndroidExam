package com.jkuhail.androidexam.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.bumptech.glide.Glide
import com.jkuhail.androidexam.*
import com.jkuhail.androidexam.databinding.FragmentFeedBinding

class FeedFragment : Fragment(), CardAdapter.EventListener {
    private lateinit var binding: FragmentFeedBinding


    private var items: ArrayList<Item> = ArrayList()
    private lateinit var adapter: CardAdapter


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

/*    private fun adapterSetup(){
        adapter = object : BaseAdapter<Item>(context, items){
            override fun setViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
                val view: View =
                    LayoutInflater.from(context).inflate(
                        R.layout.item_main_card,
                        parent,
                        false
                    )
                view.rotationY = 180F
                return ItemHolder(context, view)
            }

            override fun onBindData(holder: RecyclerView.ViewHolder, value: Item, position: Int) {
                val viewHolder: ItemHolder = holder as ItemHolder
                Glide.with(requireContext()).load(value.thumb).into(viewHolder.thumb!!)
                viewHolder.title!!.text = value.title
                viewHolder.content!!.text = value.content
            }
        }

        binding.viewPager.adapter = adapter
    }*/

    private fun addItems() {
        items.add(
            Item(
                R.drawable.suicide_squad_poster_deadshot_1,
                "כמה אתם מבינים בסרטים?",
                "גלו כמה אתם בעלי הבנה בתחום"
            )
        )
        items.add(
            Item(
                R.drawable.suicide_squad_poster_deadshot_1,
                "כמה אתם מבינים בסרטים?",
                "גלו כמה אתם בעלי הבנה בתחום"
            )
        )
        items.add(
            Item(
                R.drawable.suicide_squad_poster_deadshot_1,
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
        adapter = CardAdapter(context, items, this)
        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 1
    }

/*    private fun init() {
        var currentPage = 0
        binding.viewPager.rotationY = 180F; //enable RTL swiping
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.clipToPadding = false
        binding.viewPager.clipChildren = false
        nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        binding.viewPager.setPageTransformer(pageTransformer)
        // The ItemDecoration gives the current (centered) item horizontal margin so that
        // it doesn't occupy the whole screen width. Without it the items overlap
        horizontalMarginItemDecoration = HorizontalMarginItemDecoration(
            requireContext(),
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.viewPager.addItemDecoration(horizontalMarginItemDecoration!!)
        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }
            override fun onPageScrollStateChanged(
                state: Int
            ) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    val pageCount: Int = items.size
                    if (currentPage == 0) {
                        binding.viewPager.setCurrentItem(pageCount - 2, false)
                    } else if (currentPage == pageCount - 1) {
                        binding.viewPager.setCurrentItem(1, false)
                    }
                }
            }
        })

    }*/


}