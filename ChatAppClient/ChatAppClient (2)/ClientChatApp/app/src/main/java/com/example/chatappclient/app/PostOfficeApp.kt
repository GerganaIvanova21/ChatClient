package com.example.chatappclient.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chatappclient.navigation.PostOfficeAppRouter
import com.example.chatappclient.navigation.Screen
import com.example.chatappclient.screen.HomeScreen
import com.example.chatappclient.screen.LoginScreen
import com.example.chatappclient.screen.Registration



@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.Registration ->{
                    Registration(navController = PostOfficeAppRouter.navController)
                }
                is Screen.LoginScreen -> {
                    LoginScreen(navController = PostOfficeAppRouter.navController)
                }
                is Screen.LoginScreen -> {
                    HomeScreen(navController = PostOfficeAppRouter.navController)
                }
                /*is Screen.LoginScreen -> {
                    LoginScreen()
                }*/
                else -> {
                    // Handle unexpected cases or provide a default behavior
                    Text("Unexpected screen state", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
