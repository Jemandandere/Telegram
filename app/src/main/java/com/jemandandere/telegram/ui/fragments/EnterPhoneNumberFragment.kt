package com.jemandandere.telegram.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.jemandandere.telegram.App
import com.jemandandere.telegram.R
import com.jemandandere.telegram.databinding.FragmentEnterPhoneNumberBinding

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    private var fragmentEnterPhoneNumberBinding: FragmentEnterPhoneNumberBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEnterPhoneNumberBinding.bind(view)
        fragmentEnterPhoneNumberBinding = binding
        binding.registerBtnNext.setOnClickListener {
            sendCode(binding)
        }

    }

    private fun sendCode(binding: FragmentEnterPhoneNumberBinding) {
        if (binding.registerInputPhoneNumber.text.toString().isEmpty()) {
            Toast.makeText(activity, "Введите номер телефона", Toast.LENGTH_SHORT).show()
        } else {
            App.instance.navController.navigate(R.id.action_enterPhoneNumberFragment_to_enterCodeFragment)
        }
    }

    override fun onDestroyView() {
        fragmentEnterPhoneNumberBinding = null
        super.onDestroyView()
    }
}