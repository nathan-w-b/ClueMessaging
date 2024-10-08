package com.example.cluemessaging.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.MainActivity
import com.example.cluemessaging.R
import com.example.cluemessaging.ui.ClueMessagingRouter
import com.example.cluemessaging.ui.ClueMessagingScreens
import com.example.cluemessaging.ui.composable_lib.LibButton
import com.example.cluemessaging.ui.composable_lib.LibClickableText
import com.example.cluemessaging.ui.composable_lib.LibSurface
import com.example.cluemessaging.ui.composable_lib.LibTextFocus
import com.example.cluemessaging.ui.composable_lib.LibTextBadge
import com.example.cluemessaging.ui.composable_lib.LibText
import com.example.cluemessaging.ui.theme.ClueMessagingTheme

@Composable
fun AllowPermissionsScreen(context: Context? = null) {
    LibSurface() {
        Column (
        ) {
            LibTextFocus("Allow Permissions", false, centered = false)
            Spacer(modifier = Modifier.height(18.dp))
            LibText("To help you message people you know, " +
                    "Clue will request these permissions.")
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
                LibClickableText(textVal = "Not now") {
                   ClueMessagingRouter.navigateTo(ClueMessagingScreens.SignUpPhoneNumberScreen)
                }
                Spacer(modifier = Modifier.weight(1f))
               LibButton(textVal = "Next") {
                   if (context != null) (context as MainActivity).getPermissions()
                   else ClueMessagingRouter.navigateTo(ClueMessagingScreens.WorkInProgressScreen)
               }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AllowPermissionsScreenPreview() {
    ClueMessagingTheme(){
        AllowPermissionsScreen(null)
    }
}

