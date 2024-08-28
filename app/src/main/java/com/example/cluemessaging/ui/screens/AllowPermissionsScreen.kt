package com.example.cluemessaging.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.R
import com.example.cluemessaging.ui.composable_lib.LibButton
import com.example.cluemessaging.ui.composable_lib.LibClickableText
import com.example.cluemessaging.ui.composable_lib.LibTextFocus
import com.example.cluemessaging.ui.composable_lib.LibTextBadge
import com.example.cluemessaging.ui.composable_lib.LibText

@Preview(showSystemUi = true)
@Composable
fun AllowPermissionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color.Transparent)){
        Column (
            modifier = Modifier.background(color = colorResource(R.color.moonlight))
        ) {
            LibTextFocus("Allow Permissions", true)
            Spacer(modifier = Modifier.height(18.dp))
            LibText("To help you message people you know, " +
                    "ClueMessaging will request these permissions.")
            Spacer(modifier = Modifier.height(24.dp))
            LibTextBadge(
                R.drawable.ic_notifications,
                "Notifications",
                "Get notified when new messages arrive."
            )
            Spacer(modifier = Modifier.height(8.dp))
            LibTextBadge(
                R.drawable.ic_contacts,
                "Contacts",
                "Find people you know. Your contacts are encrypted and not visible to the ClueMessaging service."
            )
            Spacer(modifier = Modifier.height(8.dp))
            LibTextBadge(
                imageId = R.drawable.ic_phone,
                titleString = "Phone calls",
                textString = "Make registering easier and enable additional calling features."
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically) {
               LibClickableText(textVal = "Not now") {}
               Spacer(modifier = Modifier.weight(1f))
               LibButton(textVal = "Next") {}
            }
        }
    }
}

