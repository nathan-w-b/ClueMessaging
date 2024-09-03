package com.example.cluemessaging.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class ClueMessagingScreens (){
    data object LoginScreen: ClueMessagingScreens()
    data object TermsOpeningScreen : ClueMessagingScreens()
    data object AllowPermissionsScreen : ClueMessagingScreens()
    data object SignUpPhoneNumberScreen : ClueMessagingScreens()
    data object ViewTermsScreen: ClueMessagingScreens()
    data object WorkInProgressScreen: ClueMessagingScreens()
    data object SetupProfileScreen: ClueMessagingScreens()
}

object ClueMessagingRouter {
    var currentScreen: MutableState<ClueMessagingScreens> = mutableStateOf(ClueMessagingScreens.LoginScreen)
    var prevScreen: MutableState<ClueMessagingScreens> = mutableStateOf(ClueMessagingScreens.TermsOpeningScreen)

    fun navigateTo(nextScreen: ClueMessagingScreens){
        prevScreen.value = currentScreen.value
        currentScreen.value = nextScreen
    }

    fun navigateBack(){
        currentScreen.value = prevScreen.value
    }
}