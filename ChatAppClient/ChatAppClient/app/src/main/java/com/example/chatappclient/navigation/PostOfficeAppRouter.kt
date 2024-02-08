package com.example.chatappclient.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController

sealed class Screen(val route: String) {
    object Registration : Screen("registration")
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("home")

}


object PostOfficeAppRouter {

    lateinit var navController: NavHostController

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.Registration)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }


}