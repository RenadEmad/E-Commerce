//package com.example.kotlin.ui.component
//
//import android.graphics.drawable.Icon
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.MaterialTheme.colorScheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.OutlinedTextFieldDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun CustomTextField(modifier: Modifier = Modifier, value : String ,hintText:String, onChange : (String)->Unit ) {
//    val colorScheme = MaterialTheme.colorScheme
//
//    OutlinedTextField(
//
//        value = value,
//        onValueChange = onChange,
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(12.dp),
//        singleLine = true,
////        trailingIcon = {
////            Icons.Default.Visability
////        },
//        textStyle = TextStyle(
//            fontSize = 18.sp,
//            color = androidx.compose.ui.graphics.Color.Black
//        ),
//        colors = OutlinedTextFieldDefaults.colors(
//            // الخلفية
//            focusedContainerColor = colorScheme.secondary,
//            unfocusedContainerColor = colorScheme.secondary,
//            // border
//            focusedBorderColor = colorScheme.onPrimary,
//            unfocusedBorderColor = androidx.compose.ui.graphics.Color.Transparent,
//            //  cursor
//            focusedTextColor = androidx.compose.ui.graphics.Color.Black,
//            unfocusedTextColor = androidx.compose.ui.graphics.Color.Black,
//            cursorColor = colorScheme.primary
//        ),
//        placeholder = {
//            Text(
//                text = hintText ,
//                style = TextStyle(
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp,
//                    color = colorScheme.tertiary
//                )
//            )
//        }
//    )
//
//}

package com.example.kotlin.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ErrorLightRed = Color(0xFFFF8A80)

@Composable
fun CustomTextField(
    value: String,
    hintText: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    errorMessage: String? = null,
    leadingIcon: @Composable() (() -> Unit)? = null,
    size: Dp?=16.dp
) {
    val colorScheme = MaterialTheme.colorScheme
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onChange,
//        modifier = modifier.fillMaxWidth(),
        modifier = modifier,

        shape = RoundedCornerShape(size!!),
        singleLine = true,
        isError = errorMessage != null,
        supportingText = errorMessage?.let { msg ->
            {
                Text(
                    text = msg,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = ErrorLightRed
                    )
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        leadingIcon =  leadingIcon,
        visualTransformation = if (isPassword && !passwordVisible)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        trailingIcon = if (isPassword) {
            {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.VisibilityOff
                        else Icons.Default.Visibility,
                        contentDescription = if (passwordVisible) "Hide password"
                        else "Show password",
                        tint = Color.Gray
                    )
                }
            }
        } else null,
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = colorScheme.secondary,
            unfocusedContainerColor = colorScheme.secondary,
            errorContainerColor = colorScheme.secondary,
            focusedBorderColor = colorScheme.onPrimary,
            unfocusedBorderColor = Color.Transparent,
            errorBorderColor = ErrorLightRed,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            errorTextColor = Color.Black,
            cursorColor = colorScheme.primary,
            errorCursorColor = ErrorLightRed,
            errorSupportingTextColor = ErrorLightRed
        ),
        placeholder = {
            Text(
                text = hintText,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = colorScheme.tertiary
                )
            )
        }
    )
}