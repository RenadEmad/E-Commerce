
package com.example.kotlin.ui.feature.auth.ui.login

import CustomElevatedButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R
import com.example.kotlin.ui.component.CustomTextField
import AppValidators
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kotlin.ui.feature.commerce.domain.utility.Resource
import com.example.kotlin.ui.feature.commerce.ui.common.MainLoadingSection

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onCAccountClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val colorScheme = MaterialTheme.colorScheme
//
//    var email by remember { mutableStateOf("renad@gmail.com") }
//    var password by remember { mutableStateOf("Renad@123") }
val state by viewModel.state.collectAsStateWithLifecycle()
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
val context = LocalContext.current

//    LaunchedEffect(Unit) {
//        viewModel.effects.collect{
//            effects->
//            when(effects){
//                LoginEffects.OnNavigateRegister -> {
//                    onLoginClick
//                }
//                LoginEffects.OnNavigateToHome -> onCAccountClick()
//                is LoginEffects.ShowToast -> {
//                    Toast.makeText(context,effects.message,Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }
    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                LoginEffects.OnNavigateRegister -> onCAccountClick()
                LoginEffects.OnNavigateToHome -> onLoginClick()
                is LoginEffects.ShowToast ->
                    Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
            }
        }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorScheme.primary)
            .systemBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )

    {
        TopLogoSection()

        Text(
            text = "Welcome Back To Route",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = colorScheme.secondary,
                fontSize = 24.sp
            )
        )

        Text(
            text = "Please sign in with your mail",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontWeight = FontWeight.Thin,
                color = colorScheme.secondary,
                fontSize = 16.sp
            )
        )

        FieldLabel("Email")
        CustomTextField(
            modifier = modifier.fillMaxWidth(),
            value = state.email,
            hintText = "Enter your email",
            keyboardType = KeyboardType.Email,
            errorMessage = emailError,
            onChange = { newVal->
                viewModel.onIntent(intent = LoginIntent.EmailChanged(email =newVal ))
//                email = newVal
                emailError = null
            }

        )

        FieldLabel("Password")
        CustomTextField(
            modifier = modifier.fillMaxWidth(),

            value = state.password,
            hintText = "Enter password",
            keyboardType = KeyboardType.Password,
            isPassword = true,
            errorMessage = passwordError,
            onChange = {newVal->

            viewModel.onIntent( LoginIntent.PasswordChanged(password = newVal))
//                password = it
                passwordError = null
            }
        )

        Text(
            text = "Forgot password",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                color = colorScheme.secondary,
                fontSize = 18.sp
            )
        )


if(state.loginState is Resource.Loading){
    MainLoadingSection()
}
        else{
    CustomElevatedButton(
        modifier = modifier.fillMaxWidth(),

        text = "Login",
        onClick = {
            emailError = AppValidators.validateEmail(state.email)
            passwordError = AppValidators.validatePassword(state.password)

            if (emailError == null && passwordError == null) {
                // TODO: call login API
//                    onLoginClick(email)
                viewModel.onIntent(LoginIntent.OnLoginIntent)
            }
        }
    )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don’t have an account?",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = colorScheme.secondary,
                    fontSize = 16.sp
                )
            )
            TextButton(onClick = { viewModel.onIntent(LoginIntent.OnCreateAccountIntent) }) {
                Text(
                    text = "Create Account",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.secondary,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

@Composable
private fun FieldLabel(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 18.sp
        )
    )
}

@Composable
fun TopLogoSection(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.route),
        contentDescription = "route",
        modifier = modifier
            .padding(top = 30.dp)
            .size(width = 200.dp, height = 100.dp)
    )
}