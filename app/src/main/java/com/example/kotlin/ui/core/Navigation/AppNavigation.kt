package com.example.kotlin.ui.core.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kotlin.ui.feature.commerce.ui.screens.main.MainTabScreen
import com.example.kotlin.ui.feature.home.HomeScreen
import com.example.kotlin.ui.feature.login.LoginScreen
import com.example.kotlin.ui.feature.register.RegisterScreen


@Composable
fun AppRoutes(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginRoute,
//        startDestination = HomeRoute(name = "rrr"),
        modifier = modifier
    ) {
        composable<LoginRoute> {
            LoginScreen(
                onLoginClick = { name ->
                    navController.navigate(MainTabRoute) {
//                    navController.navigate(HomeRoute(name)) {
                        popUpTo<LoginRoute> { inclusive = true }
                    }
                },
                onCAccountClick = { navController.navigate(RegisterRoute) }
            )
        }

        composable<RegisterRoute> {
            RegisterScreen(
                onSignUpClick = { name ->
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
    }
}