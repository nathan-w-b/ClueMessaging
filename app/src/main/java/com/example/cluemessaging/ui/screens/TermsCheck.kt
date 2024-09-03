package com.example.cluemessaging.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.R
import com.example.cluemessaging.SystemBackButtonHandler
import com.example.cluemessaging.ui.composable_lib.LibTextFocus
import com.example.cluemessaging.ui.ClueMessagingRouter
import com.example.cluemessaging.ui.ClueMessagingScreens
import com.example.cluemessaging.ui.composable_lib.LibButton
import com.example.cluemessaging.ui.composable_lib.LibClickableText
import com.example.cluemessaging.ui.composable_lib.LibSurface

@Composable
fun TermsCheck(){
    LibSurface() {
        Column (
            modifier = Modifier
                .fillMaxSize()
//                .padding(32.dp)
                ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(400.dp),
                painter = painterResource(id = R.drawable.logo_namecentered),
                contentDescription = "")
            LibTextFocus("Take privacy with you.\nBe yourself in every message.", false)
            Spacer(modifier = Modifier.size(18.dp))
            LibClickableText("Terms & Privacy Policy", centered = true) {
                ClueMessagingRouter.navigateTo(
                    ClueMessagingScreens.ViewTermsScreen
                )
            }
            Spacer(modifier = Modifier.size(18.dp))
            LibButton("Continue") {
                ClueMessagingRouter.navigateTo(
                    ClueMessagingScreens.AllowPermissionsScreen)
            }
        }
    }
    SystemBackButtonHandler {
        ClueMessagingRouter.navigateBack()
    }
}

@Preview(showSystemUi = true)
@Composable
fun TermsCheckPreview() {
    TermsCheck()
}