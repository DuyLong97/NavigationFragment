package com.example.navigationfragment.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationfragment.viewmodel.BlankViewModel
import com.example.navigationfragment.R
import com.example.navigationfragment.databinding.BlankFragmentBinding

@Suppress("DEPRECATION")
class BlankFragment : Fragment() {
    companion object {
        fun newInstance() =
            BlankFragment()
    }
    private lateinit var viewModel: BlankViewModel
    private lateinit var binding: BlankFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.blank_fragment,container, false)
        val userName = arguments?.getString("UserName")
        val userEmail = arguments?.getString("UserEmail")
        binding.tvName.text = userName.toString()
        binding.tvEmail.text = userEmail.toString()
        binding.btnTerms.setOnClickListener(termsListener)
        return binding.root
    }

    private val termsListener = View.OnClickListener {
        it.findNavController().navigate(R.id.action_blankFragment_to_termsFragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)
    }

}