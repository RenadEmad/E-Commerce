package com.example.kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.kotlin.ui.core.Navigation.AppRoutes
import com.example.kotlin.ui.feature.commerce.ui.screens.main.MainTabScreen
import com.example.kotlin.ui.feature.commerce.ui.tabs.product.ProductTab
import com.example.kotlin.ui.feature.home.HomeScreen
import com.example.kotlin.ui.feature.login.LoginScreen
import com.example.kotlin.ui.feature.network.api.NetworkModule
import com.example.kotlin.ui.feature.register.RegisterScreen
import com.example.kotlin.ui.theme.KotlinTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTheme {
//                AppRoutes()
             AppRoutes()
            }
        }

//        var module : NetworkModule = NetworkModule()
//        val okHttpClient=module.provideOkHttpClient()
//        val retrofit = module.provideRetrofit(okHttpClient)
//        val apiServices= module.provideApiServices(retrofit=retrofit)
//
//        lifecycleScope.launch {
//            apiServices.getAllCategories()
//        }
    }
}