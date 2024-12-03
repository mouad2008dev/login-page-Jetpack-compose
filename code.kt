@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.password

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.password.ui.theme.PasswordTheme
import androidx.compose.material3.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(modifier = Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        //==================email text field=================================================
        var email by remember { mutableStateOf("") }

        OutlinedTextField(value = email,
            onValueChange = {email =it},
            placeholder = { Text(text = "email")},
            label = { Text(text = "email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        /*============================spacer================================================*/
        Spacer(modifier = Modifier.height(24.dp))
        /*======================password text fiels========================================*/
        var password by remember { mutableStateOf("") }
        var passwordvisibility by remember { mutableStateOf(false) }

        var icon = if(passwordvisibility==true)
            painterResource(id = R.drawable.baseline_visibility_24)
        else
            painterResource(id = R.drawable.baseline_visibility_off_24)
        OutlinedTextField(value = password,
            onValueChange ={password= it},
            placeholder = { Text(text = "password")},
            label = { Text(text = "password")},
            trailingIcon = { IconButton(onClick = {passwordvisibility = !passwordvisibility}) {
                Icon(painter = icon, contentDescription = "visibility")
                }
            },
            visualTransformation = if (passwordvisibility == true){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        /*============================spacer================================================*/
        Spacer(modifier = Modifier.height(24.dp))
        /*==========================Button======================================*/
        Button(onClick = { /*Type here what do you want the button to do*/ }, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Login")
            Icon(painter = painterResource(id = R.drawable.baseline_login_24), contentDescription = "login")

        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PasswordTheme {
        Greeting()
    }
}
