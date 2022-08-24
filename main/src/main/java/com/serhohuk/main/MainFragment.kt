package com.serhohuk.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.serhohuk.core.BaseFragment
import com.serhohuk.core.LoginUtils
import com.serhohuk.main.databinding.FragmentMainBinding


/**
 * Created by serhh on 23.08.2022
 */

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginState("")

        binding.btnLogin.setOnClickListener {
            router.navigateToAuth(parentFragmentManager)
        }

        binding.btnToProfile.setOnClickListener {
            //router.navigateToProfile(parentFragmentManager)
        }

        setFragmentResultListener("ResListener"){ requestKey, bundle ->  
            val time = bundle.getString("timeInMillis")
            loginState(time!!)
        }
    }

    fun loginState(time : String){
        if (time.isNotEmpty()){
            binding.btnLogin.isEnabled = false
            binding.btnLogin.isClickable = false
            binding.btnToProfile.isEnabled = true
            binding.btnToProfile.isClickable = true
            val loginTime = LoginUtils.timeInMillisToTimeString(time)
            binding.tvLoggedIn.text = getString(com.serhohuk.core.R.string.logged_in,loginTime)
            binding.tvLoggedIn.visibility = View.VISIBLE
        } else {
            binding.tvLoggedIn.visibility = View.GONE
            binding.btnToProfile.isEnabled = false
            binding.btnToProfile.isClickable = false
            binding.btnLogin.isEnabled = true
            binding.btnLogin.isClickable = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}