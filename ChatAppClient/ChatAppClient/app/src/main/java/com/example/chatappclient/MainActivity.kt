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
import com.example.chatappclient.app.PostOfficeApp
import com.example.chatappclient.navigation.PostOfficeAppRouter
import com.example.chatappclient.navigation.Screen
import com.example.chatappclient.ui.theme.ChatAppClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PostOfficeAppRouter.currentScreen.value = Screen.Registration // Set initial screen
        setContent {
            PostOfficeApp()
        }
    }
}


@Preview
@Composable
fun DefaultPreview(){
    PostOfficeApp()
}

