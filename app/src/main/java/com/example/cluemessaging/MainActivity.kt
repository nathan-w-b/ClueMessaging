package com.example.cluemessaging

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cluemessaging.ui.screens.LoginScreen
import com.example.cluemessaging.ui.screens.WorkInProgressScreen
import com.example.cluemessaging.ui.ClueMessagingRouter
import com.example.cluemessaging.ui.ClueMessagingScreens
import com.example.cluemessaging.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MessagingApp()
        }
    }

    fun CheckPermission(permission: String, requestCode: Int) {
        if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted.", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun MessagingApp(){
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
                    AllowPermissionsScreen()
                }
                is ClueMessagingScreens.ViewTermsScreen -> {
                    ViewTermsScreen()
                }
                is ClueMessagingScreens.SignUpPhoneNumberScreen -> {
                    WorkInProgressScreen(title = "Sign Up Phone Number")
                }
                is ClueMessagingScreens.WorkInProgressScreen ->{
                    WorkInProgressScreen(title = "Work In Progress")
                }
            }
        }
    }
}