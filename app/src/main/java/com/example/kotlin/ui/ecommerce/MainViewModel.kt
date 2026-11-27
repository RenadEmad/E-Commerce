package com.example.kotlin.ui.ecommerce

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.ui.core.Navigation.LoginRoute
import com.example.kotlin.ui.core.Navigation.MainTabRoute
import com.example.kotlin.ui.core.Navigation.SplashRoute
import com.example.kotlin.ui.feature.auth.domain.use_case.GitTokenUseCase
import com.example.kotlin.ui.feature.commerce.data.data_sources.local.AuthLocalDataSource
import com.example.kotlin.ui.feature.splash.SplashScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getTokenUseCase: GitTokenUseCase,
    val authLocalDataSource: AuthLocalDataSource
) : ViewModel(
) {
    private val _startDestination : MutableStateFlow<Any?> =
        MutableStateFlow(null)
    val startDestnation = _startDestination.asStateFlow()
    init {
        checkAppStartFlow()
    }


fun checkAppStartFlow(){

viewModelScope.launch {
    try {
val isFirstTime=authLocalDataSource.isFirstTime.first()
        val token=getTokenUseCase.invoke().first()

        _startDestination.value=when{
            isFirstTime->{
                // splash
                SplashRoute

            }
            !token.isNullOrBlank()->{
                MainTabRoute
            }
            else->{
                LoginRoute
            }

        }

    }
    catch (e:Exception){
_startDestination.value=LoginRoute
    }
}


}


fun onSplashFinish() : Unit{
  viewModelScope.launch {
      authLocalDataSource.setFirstTimeCompleted()
  }
}


}