package com.example.navigationfragment.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationfragment.viewmodel.Page2ViewModel
import com.example.navigationfragment.R
import com.example.navigationfragment.databinding.Page2FragmentBinding

class Page2Fragment : Fragment() {

    companion object {
        fun newInstance() =
            Page2Fragment()
    }

    private lateinit var viewModel: Page2ViewModel
    private lateinit var binding:Page2FragmentBinding
    private lateinit var userName:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.page2_fragment,container,false)
        userName = arguments?.getString("UserName")!!
        binding.btnSubmit.setOnClickListener(submitListener)
        return binding.root
    }

    private val submitListener = View.OnClickListener {
        if (!TextUtils.isEmpty(binding.txtEmail.text.toString())){
            val bundle = bundleOf("UserEmail" to binding.txtEmail.text.toString(),"UserName" to userName)
            it.findNavController().navigate(R.id.action_page2Fragment_to_blankFragment,bundle)
        }else{
            Toast.makeText(context,"Please insert your email",Toast.LENGTH_SHORT).show()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(Page2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}