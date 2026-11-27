package com.example.kotlin.ui.core.Navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kotlin.ui.feature.commerce.ui.screens.main.MainTabScreen
import com.example.kotlin.ui.feature.home.HomeScreen
import com.example.kotlin.ui.feature.auth.ui.login.LoginScreen
import com.example.kotlin.ui.feature.auth.ui.register.RegisterScreen
import com.example.kotlin.ui.feature.splash.SplashScreen


@Composable
fun AppRoutes(modifier: Modifier = Modifier,
            startDest:Any,
              onSplashFinished : ()->Unit
              ) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDest,
//        startDestination = HomeRoute(name = "rrr"),
        modifier = modifier
    ) {
//        composable<LoginRoute> {
//            LoginScreen(
//                onLoginClick = { name ->
//                    navController.navigate(MainTabRoute) {
////                    navController.navigate(HomeRoute(name)) {
//                        popUpTo<LoginRoute> { inclusive = true }
//                    }
//                },
//                onCAccountClick = { navController.navigate(RegisterRoute) }
//            )
//        }
        composable<LoginRoute> {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(MainTabRoute) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                },
                onCAccountClick = { navController.navigate(RegisterRoute) }
            )
        }

        composable<RegisterRoute> {
            RegisterScreen(
                onSignUpClick = {  ->
                    navController.navigate(MainTabRoute) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                },
                onLoginClick = { navController.popBackStack() }
            )
        }

        composable<MainTabRoute> {
           MainTabScreen()
        }

        composable<SplashRoute>{
            SplashScreen(
                onSplashClick={
                    onSplashFinished()
                    navController.navigate(LoginRoute){
                        popUpTo<SplashRoute>{
                            inclusive=true
                        }
                    }
                }
            )

        }


    }
}