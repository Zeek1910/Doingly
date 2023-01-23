package com.zeek1910.doingly.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeek1910.doingly.domain.use_cases.SignInUseCase
import com.zeek1910.doingly.domain.use_cases.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase
) : ViewModel() {


    fun testSignIn() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = signInUseCase("zeek1910@gmail.com", "tracer1910")
                Timber.d(user.toString())
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun testSignUp() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                signUpUseCase("zeek1910@gmail.com", "tracer1910")
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}