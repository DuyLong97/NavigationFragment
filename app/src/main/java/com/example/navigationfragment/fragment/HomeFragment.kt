package com.example.navigationfragment.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationfragment.R
import com.example.navigationfragment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.btnNext.setOnClickListener(nextListener)
        return binding.root
    }

    private var nextListener = View.OnClickListener {
        if (!TextUtils.isEmpty(binding.txtName.text.toString())) {
            val bundle = bundleOf("UserName" to binding.txtName.text.toString())
            it.findNavController().navigate(R.id.action_homeFragment_to_page2Fragment,bundle)
            binding.txtName.setText("")
        }else{
            Toast.makeText(context,"Please insert your name",Toast.LENGTH_SHORT).show()
        }
    }
}