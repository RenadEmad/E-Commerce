package com.example.kotlin.ui.feature.register

import CustomElevatedButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.ui.component.CustomTextField
import com.example.kotlin.ui.feature.login.TopLogoSection
import AppValidators

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onSignUpClick: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    var fullName by remember { mutableStateOf("Renad") }
    var mobileNumber by remember { mutableStateOf("0123467890") }
    var email by remember { mutableStateOf("renad@gmail.com") }
    var password by remember { mutableStateOf("Renad@123") }

    var fullNameError by remember { mutableStateOf<String?>(null) }
    var mobileError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

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
    ) {
        TopLogoSection()

        Text(
            text = "Create Your Account",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = colorScheme.secondary,
                fontSize = 24.sp
            )
        )

        FieldLabel("Full name")
        CustomTextField(
            modifier = modifier.fillMaxWidth(),

            value = fullName,
            hintText = "Enter your full name",
            errorMessage = fullNameError,
            onChange = {
                fullName = it
                fullNameError = null
            }
        )

        FieldLabel("Mobile number")
        CustomTextField(
            modifier = modifier.fillMaxWidth(),

            value = mobileNumber,
            hintText = "Enter your mobile number",
            keyboardType = KeyboardType.Phone,
            errorMessage = mobileError,
            onChange = {
                mobileNumber = it
                mobileError = null
            }
        )

        FieldLabel("E-mail")
        CustomTextField(
            modifier = modifier.fillMaxWidth(),

            value = email,
            hintText = "Enter your E-mail",
            keyboardType = KeyboardType.Email,
            errorMessage = emailError,
            onChange = {
                email = it
                emailError = null
            }
        )

        FieldLabel("Password")
        CustomTextField(
            modifier = modifier.fillMaxWidth(),

            value = password,
            hintText = "Enter password",
            keyboardType = KeyboardType.Password,
            isPassword = true,
            errorMessage = passwordError,
            onChange = {
                password = it
                passwordError = null
            }
        )

        CustomElevatedButton(
            modifier = modifier.fillMaxWidth(),

            text = "Register",
            onClick = {
                fullNameError = AppValidators.validateName(fullName)
                mobileError = AppValidators.validatePhone(mobileNumber)
                emailError = AppValidators.validateEmail(email)
                passwordError = AppValidators.validatePassword(password)

                val isValid = listOf(fullNameError, mobileError, emailError, passwordError)
                    .all { it == null }

                if (isValid) {
                    // TODO: call register API
                    onSignUpClick(fullName)
                }
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = colorScheme.secondary,
                    fontSize = 16.sp
                )
            )
            TextButton(onClick = { /* TODO: navigate to Login */
            onLoginClick()
            }) {
                Text(
                    text = "Login",
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