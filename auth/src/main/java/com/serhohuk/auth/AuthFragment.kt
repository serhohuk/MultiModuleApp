package com.serhohuk.auth

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.serhohuk.core.*


class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etEmail = view.findViewById(R.id.et_login)
        etPassword = view.findViewById(R.id.et_password)
        btnLogin = view.findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (LoginUtils.validateLogin(email) && LoginUtils.validatePassword(password)){
                loginPrefManager.email = email
                //loginPrefManager.loginTime = System.currentTimeMillis().toString()
                //router.navigateToMain(parentFragmentManager)
                setFragmentResult("ResListener",
                    bundleOf("timeInMillis" to
                        System.currentTimeMillis().toString()))
                parentFragmentManager.popBackStack()
            } else if (!LoginUtils.validateLogin(email)){
                toast("Not valid email")
            } else if (!LoginUtils.validatePassword(password)){
                toast("Not valid password")
            }
        }

    }


}