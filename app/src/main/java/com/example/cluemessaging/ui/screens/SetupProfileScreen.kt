package com.example.cluemessaging.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.R
import com.example.cluemessaging.ui.composable_lib.LibButton
import com.example.cluemessaging.ui.composable_lib.LibButtonBadge
import com.example.cluemessaging.ui.composable_lib.LibButtonImage
import com.example.cluemessaging.ui.composable_lib.LibSurface
import com.example.cluemessaging.ui.composable_lib.LibTextDescription
import com.example.cluemessaging.ui.composable_lib.LibTextField
import com.example.cluemessaging.ui.composable_lib.LibTextFocus
import com.example.cluemessaging.ui.theme.ClueMessagingTheme

@Composable
fun SetupProfileScreen() {
    LibSurface() {
        Column () {
            LibTextFocus(textVal = "Setup your profile", title = false, centered = false)

            LibTextDescription(textVal = "Profiles are visible to people you message, contacts, and groups.")
            // TODO - Add a "Learn More" to the end of the above text with an accompanying screen

            Row() {
                Spacer(modifier = Modifier.weight(.5f))
                LibButtonImage(imageId = R.drawable.logo_1_foreground) { }
                Spacer(modifier = Modifier.weight(.5f))
            }
            // TODO - Add camera functionality to take a picture for the profile photo

            LibTextField(labelValue = "First Name (required)", fillWidth = true)
            Spacer(modifier = Modifier.height(16.dp))
            LibTextField(labelValue = "Last Name (optional)", fillWidth = true)
            Spacer(modifier = Modifier.height(16.dp))
            LibButtonBadge(
                imageId = R.drawable.ic_contacts,
                titleString = "Who can find me by number?",
                textString = "Everyone") {}
            // TODO - add popup and remember selection of the popup for the above button

            Spacer(modifier = Modifier.weight(1f))
            Row() {
                Spacer(modifier = Modifier.weight(1f))
                LibButton("Next") {}
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SetupProfileScreenPreview() {
    ClueMessagingTheme {
        SetupProfileScreen()
    }
}