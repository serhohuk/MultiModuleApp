package com.serhohuk.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Created by serhh on 23.08.2022
 */

abstract class BaseFragment(@LayoutRes val layoutRes: Int) : Fragment(layoutRes) {

    protected val router : Router by lazy {
        requireActivity().application as Router
    }
    protected val loginPrefManager: LoginPrefManager by lazy {
        LoginPrefManager(requireActivity())
    }

}