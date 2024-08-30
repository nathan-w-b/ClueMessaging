package com.example.cluemessaging.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluemessaging.ui.composable_lib.LibButton
import com.example.cluemessaging.ui.composable_lib.LibComboField
import com.example.cluemessaging.ui.composable_lib.LibText
import com.example.cluemessaging.ui.composable_lib.LibTextField
import com.example.cluemessaging.ui.composable_lib.LibTextFocus
import com.example.cluemessaging.ui.composable_lib.Toolbar
import com.example.cluemessaging.ui.theme.ClueMessagingTheme

@Composable
fun SignUpPhoneNumberScreen(){
    // TODO - Auto focus on phone number text field
    // TODO - Constrain Phone Number to fill in a format (10 numbers)
    Toolbar() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 48.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background),
            ) {

                Spacer(modifier = Modifier.height(16.dp))
                LibTextFocus("Phone number", true, centered = false)
                Spacer(modifier = Modifier.height(16.dp))
                LibText("Enter your phone number to get started.", false)
                Spacer(modifier = Modifier.height(16.dp))
                Row () {
                    LibComboField(arrayOf("+1", "+2", "+3"), width = 96.dp)
                    Spacer(modifier = Modifier.height(8.dp))
                    LibTextField("Phone number", keyboard = KeyboardType.Phone)
                }
                Spacer(modifier = Modifier.weight(.6f))
                Row() {
                    Spacer(modifier = Modifier.weight(1f))
                    LibButton("Continue") {}
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpPhoneNumberScreenPreview(){
    ClueMessagingTheme {
        SignUpPhoneNumberScreen()
    }
}