package com.jkuhail.androidexam.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jkuhail.androidexam.R
import com.jkuhail.androidexam.databinding.FragmentPreziBinding


class PreziFragment : Fragment() {
    private lateinit var binding: FragmentPreziBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPreziBinding.inflate(inflater, container, false)

        return binding.root
    }

}