package com.example.cluemessaging.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.R
import com.example.cluemessaging.SystemBackButtonHandler
import com.example.cluemessaging.ui.ClueMessagingRouter
import com.example.cluemessaging.ui.composable_lib.LibText
import com.example.cluemessaging.ui.composable_lib.LibTextFocus

@Composable
fun ViewTermsScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.moonlight))
        .padding(16.dp)){
        val workInProgressString = "This page is a work in progress..."

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.moonlight)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LibTextFocus("Terms and Conditions", true)
            LibText(workInProgressString, false)
        }
    }

    SystemBackButtonHandler {
        ClueMessagingRouter.navigateBack()
    }
}