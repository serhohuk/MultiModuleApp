package com.serhohuk.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.serhohuk.core.BaseFragment


class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    private lateinit var btnLogout : Button
    private lateinit var tvEmail : TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogout = view.findViewById(R.id.btn_logout)
        tvEmail = view.findViewById(R.id.tv_profile_email)

        tvEmail.text = loginPrefManager.email

        btnLogout.setOnClickListener {
            router.navigateToAuth(parentFragmentManager)
        }
    }

}