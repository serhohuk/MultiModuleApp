package com.serhohuk.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.serhohuk.core.BaseFragment
import com.serhohuk.core.LoginUtils
import com.serhohuk.core.viewBinding
import com.serhohuk.main.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Created by serhh on 23.08.2022
 */

class MainFragment : BaseFragment(R.layout.fragment_main) {

//    private var _binding : FragmentMainBinding? = null
//    private val binding get() = _binding!!
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //loginState()
        viewModel.eventObserve()

        binding.btnLogin.setOnClickListener {
            router.navigateToAuth(parentFragmentManager)
        }

        binding.btnToProfile.setOnClickListener {
            //router.navigateToProfile(parentFragmentManager)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.timeLogin.collectLatest {
                loginState(it)
            }
        }

    }

    private fun loginState(str : String){
        if (str.isNotEmpty()){
            binding.btnLogin.isEnabled = false
            binding.btnLogin.isClickable = false
            binding.btnToProfile.isEnabled = true
            binding.btnToProfile.isClickable = true
            val loginTime = LoginUtils.timeInMillisToTimeString(str)
            binding.tvLoggedIn.text = getString(com.serhohuk.core.R.string.logged_in,loginTime)
        } else {
            binding.tvLoggedIn.visibility = View.GONE
            binding.btnToProfile.isEnabled = false
            binding.btnToProfile.isClickable = false
            binding.btnLogin.isEnabled = true
            binding.btnLogin.isClickable = true
        }
    }
}