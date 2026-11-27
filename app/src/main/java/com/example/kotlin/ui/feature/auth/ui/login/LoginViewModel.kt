package com.example.kotlin.ui.feature.auth.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.ui.feature.auth.domain.entity.login.LoginRequest
import com.example.kotlin.ui.feature.auth.domain.use_case.LoginUseCase
import com.example.kotlin.ui.feature.commerce.domain.utility.Resource
import com.example.kotlin.ui.feature.network.utility.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class LoginStates(
    val email:String="",
    val password:String="",
    val loginState:Resource<Unit> = Resource.Initial
)

sealed interface LoginIntent{
    data class EmailChanged(val email:String):LoginIntent
    data class PasswordChanged(val password:String):LoginIntent
    data object OnLoginIntent:LoginIntent
    data object OnCreateAccountIntent:LoginIntent
}

sealed interface LoginEffects{
    data class ShowToast(val message:String) :LoginEffects
    data object OnNavigateRegister : LoginEffects
    data object OnNavigateToHome : LoginEffects
}

@HiltViewModel
class LoginViewModel @Inject constructor(

    val loginUseCase: LoginUseCase
) : ViewModel() {


    private val _effects = Channel<LoginEffects>(Channel.BUFFERED)
    val effects: Flow<LoginEffects> = _effects.receiveAsFlow()

    fun onIntent(intent: LoginIntent){
        when(intent){
            is LoginIntent.EmailChanged -> changeEmail(intent.email)
            LoginIntent.OnCreateAccountIntent -> onSignUp()
            LoginIntent.OnLoginIntent -> login()
            is LoginIntent.PasswordChanged -> changePassword(intent.password)
        }
    }


    private  val _state : MutableStateFlow<LoginStates> = MutableStateFlow(LoginStates())
    val state : StateFlow<LoginStates> = _state.asStateFlow()

private fun changeEmail(email:String){
    _state.value=_state.value.copy(email=email)
}
    private fun changePassword(password: String){
    _state.value=_state.value.copy(password = password)
}


    private fun  onSignUp(){

viewModelScope.launch {
    _effects.send(LoginEffects.OnNavigateRegister)
}
    }



   private fun login(){
        
        viewModelScope.launch {
            _state.update {
                it->
                it.copy(loginState = Resource.Loading)
            }
            when(val result = loginUseCase.invoke(LoginRequest(
                password = _state.value.password,
                email = _state.value.email
            ))){
                is ApiResult.ErrorApiResult ->
                    _state.update {
                        it.copy(loginState = Resource.Error(errorMessage = result.error.errorMessage))
                    }
                is ApiResult.SuccessApiResult<Unit> ->
                {
                    _state.update {
                        it.copy(
                            loginState = Resource.Success(
                                data = Unit
                            )
                        )
                    }

                    _effects.send(LoginEffects.ShowToast(
                        message = "Login Successfully"
                    ))
                    _effects.send(LoginEffects.OnNavigateToHome)

                }

            }
        }

    }


}