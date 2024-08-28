package com.example.cluemessaging.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.R
import com.example.cluemessaging.ui.ClueMessagingRouter
import com.example.cluemessaging.ui.ClueMessagingScreens
import com.example.cluemessaging.ui.composable_lib.LibButton
import com.example.cluemessaging.ui.composable_lib.LibText
import com.example.cluemessaging.ui.composable_lib.LibTextFieldOutlined
import com.example.cluemessaging.ui.composable_lib.LibTextFieldPassword
import com.example.cluemessaging.ui.composable_lib.LibTextFocus

@Preview(showSystemUi = true)
@Composable
fun LoginScreen(){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LibText("Welcome", false)
        Spacer(modifier = Modifier.height(12.dp))
        LibTextFocus(textVal = "Please Login", true)
        Spacer(modifier = Modifier.height(36.dp))
        LibTextFieldOutlined(
            labelValue = "Email Address",
            initValue = email,
            leadingIconId = R.mipmap.email
        ) {
            email = it
        }
        Spacer(modifier = Modifier.height(12.dp))
        LibTextFieldPassword(
            initValue = password
        ) {
            password = it
        }
        Spacer(modifier = Modifier.height(24.dp))
        LibButton(textVal = "Login") {
            Log.i("Button", "Email: $email Password: $password")
            ClueMessagingRouter.navigateTo(ClueMessagingScreens.TermsOpeningScreen)
        }
    }
}