package com.giobar.fantastacapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giobar.fantastacapp.R
import com.giobar.fantastacapp.databinding.FragmentAstaBinding

class AstaFragment : Fragment() {

    private lateinit var binding: FragmentAstaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAstaBinding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_asta, container, false)
    }
}