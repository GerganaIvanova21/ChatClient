package com.example.chatappclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatappclient.app.PostOfficeApp
import com.example.chatappclient.navigation.PostOfficeAppRouter
import com.example.chatappclient.navigation.Screen
import com.example.chatappclient.screen.HomeScreen
import com.example.chatappclient.screen.LoginScreen
import com.example.chatappclient.screen.Registration
import com.example.chatappclient.ui.theme.ChatAppClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController: NavHostController = rememberNavController()
        PostOfficeAppRouter.navController = navController
        PostOfficeAppRouter.currentScreen.value = Screen.Registration // Set initial screen

        setContent {
            ChatAppClientTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = Screen.Registration.route) {
                        composable(Screen.Registration.route) {
                            Registration(navController = navController)
                        }
                        composable(Screen.LoginScreen.route) {
                            LoginScreen(navController = navController)
                        }
                        composable(Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview(){
    PostOfficeApp()
}

