//package com.example.kotlin.ui.feature.auth.ui.register
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.kotlin.ui.feature.auth.domain.entity.login.register.RegisterRequest
//import com.example.kotlin.ui.feature.auth.domain.use_case.RegisterUseCase
//import com.example.kotlin.ui.feature.auth.ui.login.LoginEffects
//import com.example.kotlin.ui.feature.commerce.domain.utility.Resource
//import com.example.kotlin.ui.feature.network.utility.ApiResult
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.channels.Channel
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.receiveAsFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//
//data class RegisterStates(
//    val name:String="",
//    val email:String="",
//    val phone:String="",
//    val password:String="",
//    val rePassword:String="",
//    val registerStates:Resource<Unit> = Resource.Initial
//)
//
//
//sealed interface RegisterIntent{
//     data class  EmailChanged( val email:String) : RegisterIntent
//         data class  NameChanged( val name:String) : RegisterIntent
//        data class  PhoneChanged( val phone:String) : RegisterIntent
//        data class  PasswordChanged( val password:String) : RegisterIntent
//        data class  RePasswordChanged( val rePassword:String) : RegisterIntent
//    data object OnSignUpClicked : RegisterIntent
//
//}
//
//
//
//sealed interface RegisterEffects{
//data class ShowToast(val message : String) : RegisterEffects
//    data object OnNavigateToHome: RegisterEffects
//}
//
//
//
//@HiltViewModel
//class RegisterViewModel @Inject constructor (
//    val registerUseCase: RegisterUseCase
//) : ViewModel() {
//
//private  val _states : MutableStateFlow<RegisterStates> = MutableStateFlow(RegisterStates())
//
//val states = _states.asStateFlow()
//    private val _effects : Channel<RegisterEffects> = Channel(Channel.BUFFERED)
//    val effects:Flow<RegisterEffects> = _effects.receiveAsFlow()
//
//
//    fun OnIntent(intent: RegisterIntent)
//    {
//        when(intent){
//            is RegisterIntent.EmailChanged -> TODO()
//            is RegisterIntent.NameChanged -> TODO()
//            RegisterIntent.OnSignUpClicked -> TODO()
//            is RegisterIntent.PasswordChanged -> TODO()
//            is RegisterIntent.PhoneChanged -> TODO()
//            is RegisterIntent.RePasswordChanged -> TODO()
//        }
//
//    }
//private fun changeEmail(email:String){
//_states.update { it.copy(email=email) }
//}
//
//    private fun changeName(name:String){
//        _states.update { it.copy(name=name) }
//    }
//    private fun changePhone(phone:String){
//        _states.update { it.copy(phone=phone) }
//    }
//    private fun changePassword(password:String){
//        _states.update { it.copy(password=password) }
//    }
//    private fun changeRePassword(rePassword:String){
//        _states.update { it.copy(rePassword=rePassword) }
//    }
//
//    private  fun  register(){
//        viewModelScope.launch {
//            _states.update {
//                it.copy(
//                    registerStates = Resource.Loading
//                )
//                when(val result=registerUseCase.invoke(
//                    registerRequest = RegisterRequest(
//                        name = _states.value.name,
//                        email = _states.value.email,
//                        phone = _states.value.phone,
//                        password = _states.value.password,
//                        rePassword = _states.value.rePassword
//                    )
//                )){
//                    is ApiResult.ErrorApiResult -> {
//                        _states.update {
//                            it.copy(
//                                registerStates = Resource.Error(errorMessage = result.error.errorMessage)
//                            )
//                        }
//                    }
//                    is ApiResult.SuccessApiResult -> TODO()
//                }
//            }
//        }
//    }
//
//}


package com.example.kotlin.ui.feature.auth.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.ui.feature.auth.domain.entity.login.register.RegisterRequest
import com.example.kotlin.ui.feature.auth.domain.use_case.RegisterUseCase
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

data class RegisterStates(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val rePassword: String = "",
    val registerStates: Resource<Unit> = Resource.Initial
)

sealed interface RegisterIntent {
    data class EmailChanged(val email: String) : RegisterIntent
    data class NameChanged(val name: String) : RegisterIntent
    data class PhoneChanged(val phone: String) : RegisterIntent
    data class PasswordChanged(val password: String) : RegisterIntent
    data class RePasswordChanged(val rePassword: String) : RegisterIntent
    data object OnSignUpClicked : RegisterIntent
}

sealed interface RegisterEffects {
    data class ShowToast(val message: String) : RegisterEffects
    data object OnNavigateToHome : RegisterEffects
}

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _states = MutableStateFlow(RegisterStates())
    val states: StateFlow<RegisterStates> = _states.asStateFlow()

    private val _effects = Channel<RegisterEffects>(Channel.BUFFERED)
    val effects: Flow<RegisterEffects> = _effects.receiveAsFlow()

    fun onIntent(intent: RegisterIntent) {
        when (intent) {
            is RegisterIntent.EmailChanged -> _states.update { it.copy(email = intent.email) }
            is RegisterIntent.NameChanged -> _states.update { it.copy(name = intent.name) }
            is RegisterIntent.PhoneChanged -> _states.update { it.copy(phone = intent.phone) }
            is RegisterIntent.PasswordChanged -> _states.update { it.copy(password = intent.password) }
            is RegisterIntent.RePasswordChanged -> _states.update { it.copy(rePassword = intent.rePassword) }
            RegisterIntent.OnSignUpClicked -> register()
        }
    }

    private fun register() {
        val current = _states.value
        viewModelScope.launch {
            _states.update { it.copy(registerStates = Resource.Loading) }

            val result = registerUseCase.invoke(
                registerRequest = RegisterRequest(
                    name = current.name,
                    email = current.email,
                    phone = current.phone,
                    password = current.password,
                    rePassword = current.rePassword
                )
            )

            when (result) {
                is ApiResult.ErrorApiResult -> {
                    val message = result.error.errorMessage
                    _states.update { it.copy(registerStates = Resource.Error(errorMessage = message)) }
                    _effects.send(RegisterEffects.ShowToast(message))
                }
                is ApiResult.SuccessApiResult -> {
                    _states.update { it.copy(registerStates = Resource.Success(data = Unit)) }
                    _effects.send(RegisterEffects.OnNavigateToHome)
                }
            }
        }
    }
}