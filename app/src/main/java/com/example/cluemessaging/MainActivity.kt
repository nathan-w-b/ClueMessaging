package com.example.cluemessaging

import android.Manifest.permission.READ_CONTACTS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.content.ContextCompat
import com.example.cluemessaging.ui.screens.LoginScreen
import com.example.cluemessaging.ui.screens.WorkInProgressScreen
import com.example.cluemessaging.ui.ClueMessagingRouter
import com.example.cluemessaging.ui.ClueMessagingScreens
import com.example.cluemessaging.ui.screens.*
import com.example.cluemessaging.ui.theme.ClueMessagingTheme

class MainActivity : ComponentActivity() {
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                ClueMessagingRouter.navigateTo(ClueMessagingScreens.WorkInProgressScreen)
            }
            else{
                ClueMessagingRouter.navigateTo(ClueMessagingScreens.WorkInProgressScreen)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClueMessagingTheme() {
                MessagingApp(this)
            }
        }
    }

    fun getPermissions() {
        if (ContextCompat.checkSelfPermission(this, READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    READ_CONTACTS)
        }
    }
}

@Composable
fun MessagingApp(context: Context){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(R.color.moonlight)
    ){
        Crossfade(targetState = ClueMessagingRouter.currentScreen, label = ""){ currentState ->
            when(currentState.value){
                is ClueMessagingScreens.LoginScreen -> {
                    LoginScreen()
                }
                is ClueMessagingScreens.TermsOpeningScreen -> {
                    TermsCheck()
                }
                is ClueMessagingScreens.AllowPermissionsScreen ->{
                    AllowPermissionsScreen(context)
                }
                is ClueMessagingScreens.ViewTermsScreen -> {
                    ViewTermsScreen()
                }
                is ClueMessagingScreens.SignUpPhoneNumberScreen -> {
                    SignUpPhoneNumberScreen()
                }
                is ClueMessagingScreens.WorkInProgressScreen -> {
                    WorkInProgressScreen(title = "Work In Progress")
                }
                is ClueMessagingScreens.SetupProfileScreen -> {
                    SetupProfileScreen()
                }
                else -> {
                    WorkInProgressScreen(title = "Work In Progress")
                }
            }
        }
    }
}