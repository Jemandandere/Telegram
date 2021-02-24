package com.jemandandere.telegram.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.jemandandere.telegram.R
import com.jemandandere.telegram.databinding.FragmentEnterCodeBinding

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    private var fragmentEnterCodeBinding: FragmentEnterCodeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEnterCodeBinding.bind(view)
        fragmentEnterCodeBinding = binding
        binding.registerInputCode.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length!! >=6) {
                        verificationCode()
                    }
                }
            }
        )
    }

    private fun verificationCode() {
        Toast.makeText(activity, "Ok", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        fragmentEnterCodeBinding = null
        super.onDestroyView()
    }
}