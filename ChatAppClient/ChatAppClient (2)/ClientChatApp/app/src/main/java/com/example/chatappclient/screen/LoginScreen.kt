package com.example.chatappclient.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatappclient.R
import com.example.chatappclient.component.ButtonComponent
import com.example.chatappclient.component.ClickableLoginTextComponent
import com.example.chatappclient.component.DividerTextComponent
import com.example.chatappclient.component.HeadingTextComponent
import com.example.chatappclient.component.NormalTextComponent
import com.example.chatappclient.component.PasswordTextFieldStyleComponent
import com.example.chatappclient.component.TextFieldStyleComponent
import com.example.chatappclient.navigation.PostOfficeAppRouter
import com.example.chatappclient.navigation.PostOfficeAppRouter.navController
import com.example.chatappclient.navigation.Screen
import com.example.chatappclient.navigation.SystemBackButtonHandler


@Composable
fun LoginScreen(navController: NavController) {
    /*SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.RegistrationScreen)
    }*/
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            NormalTextComponent(
                value = stringResource(id = R.string.login),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            HeadingTextComponent(
                value = stringResource(id = R.string.welcome),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )


            Spacer(modifier = Modifier.height(20.dp))

            TextFieldStyleComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.mail),
                iconSize = 32.dp // Adjust the size as needed
            )


            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextFieldStyleComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.padlock),
                iconSize = 32.dp // Adjust the size as needed
            )


            Spacer(modifier = Modifier.height(60.dp))

            ButtonComponent(
                value = stringResource(id = R.string.login)
            ){ navController.navigate(Screen.HomeScreen.route)}

            Spacer(modifier = Modifier.height(100.dp))


            /*DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.Registration)
            })*/
            
            Text(text = stringResource(id = R.string.go_to_signUp),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp),
                style = TextStyle(
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )
            )
            ButtonComponent(value = stringResource(id = R.string.sign_up)){
                navController.navigate(Screen.Registration.route)
            }
        }
    }

}





/*@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen()
}*/