package com.example.navigationfragment.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationfragment.viewmodel.Page1ViewModel
import com.example.navigationfragment.R
import com.example.navigationfragment.databinding.Page1FragmentBinding

@Suppress("DEPRECATION")
class Page1Fragment : Fragment() {

    companion object {
        fun newInstance() =
            Page1Fragment()
    }
    private lateinit var viewModel: Page1ViewModel
    private lateinit var binding:Page1FragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.page1_fragment,container,false)
        binding.btnSignUp.setOnClickListener(signUpListener)
        binding.btnTerms.setOnClickListener(termsListener)
        return binding.root
    }

    private val signUpListener = View.OnClickListener {
        it.findNavController().navigate(R.id.action_page1Fragment_to_homeFragment)
    }

    private val termsListener = View.OnClickListener {
        it.findNavController().navigate(R.id.action_page1Fragment_to_termsFragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(Page1ViewModel::class.java)
    }

}