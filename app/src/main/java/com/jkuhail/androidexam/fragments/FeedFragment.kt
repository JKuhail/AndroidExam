package com.jkuhail.androidexam.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.jkuhail.androidexam.*
import com.jkuhail.androidexam.databinding.FragmentFeedBinding


class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private var nextItemVisiblePx = 0f
    private  var currentItemHorizontalMarginPx: Float = 0f
    private  var pageTranslationX: Float = 0F
    private var pageTransformer: ViewPager2.PageTransformer? = null
    private var horizontalMarginItemDecoration: HorizontalMarginItemDecoration? = null

    private var items: ArrayList<Item> = ArrayList()
    private lateinit var adapter: BaseAdapter<Item>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        init()
        addItems()
        adapterSetup()

        return binding.root
    }

    private fun adapterSetup(){
        adapter = object : BaseAdapter<Item>(context, items){
            override fun setViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
                val view: View =
                    LayoutInflater.from(context).inflate(
                        R.layout.item_main_card,
                        parent,
                        false
                    )
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
    }

    private fun addItems(){
        items.add(Item(R.drawable.suicide_squad_poster_deadshot_1,
            "כמה אתם מבינים בסרטים?",
            "גלו כמה אתם בעלי הבנה בתחום"))
        items.add(Item(R.drawable.suicide_squad_poster_deadshot_1,
            "כמה אתם מבינים בסרטים?",
            "גלו כמה אתם בעלי הבנה בתחום"))
        items.add(Item(R.drawable.suicide_squad_poster_deadshot_1,
            "כמה אתם מבינים בסרטים?",
            "גלו כמה אתם בעלי הבנה בתחום"))
    }

    private fun init() {

        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.clipToPadding = false
        binding.viewPager.clipChildren = false
        nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - 0.25f * kotlin.math.abs(position)
            //fading effect:
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }

        binding.viewPager.setPageTransformer(pageTransformer)
        // The ItemDecoration gives the current (centered) item horizontal margin so that
        // it doesn't occupy the whole screen width. Without it the items overlap
        horizontalMarginItemDecoration = HorizontalMarginItemDecoration(
            requireContext(),
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.viewPager.addItemDecoration(horizontalMarginItemDecoration!!)
    }


}