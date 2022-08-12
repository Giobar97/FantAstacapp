package com.giobar.fantastacapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.giobar.fantastacapp.R
import com.giobar.fantastacapp.databinding.FragmentLoginBinding
import com.giobar.fantastacapp.utils.StringUtils.Companion.md5Hash

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)

        setLoginButton()
        attachObservers()

        return binding.root
    }

    private fun setLoginButton(){
        binding.loginButton.setOnClickListener {
            mainViewModel.getUsers()
        }
    }

    private fun attachObservers(){
        mainViewModel.users.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                resetError()
                it.forEach { user ->
                    if(user.username == binding.usernameInput.text.toString()){
                        if(user.password == binding.passwordInput.text.toString().md5Hash()){
                            resetError()
                            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToAstaFragment())
                        }
                        else{
                            setError("La password inserita è errata")
                        }
                        return@forEach
                    }
                    else{
                        setError("L'username inserito non esiste")
                    }
                }
                mainViewModel.resetUsersList()
            }
        }
    }

    private fun resetError(){
        binding.errorTv.text = ""
    }

    private fun setError(errorMessage: String){
        binding.errorTv.apply {
            if(this.text.isEmpty()){
                this.text = errorMessage
            }
        }
    }
}