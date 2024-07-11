package com.example.market.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.market.R
import com.example.market.screen.state.LoginState
import com.example.market.screen.state.loginStateRemember
import com.example.market.ui.theme.MarketTheme
import com.google.firebase.auth.FirebaseAuth // this is error
import com.google.firebase.auth.ktx.auth  // this is error
import com.google.firebase.ktx.Firebase
import kotlin.math.log

@Composable
fun LoginScreen(navController: NavController, state: LoginState = loginStateRemember(inputState = "", alertState = false)) {
    val auth: FirebaseAuth = Firebase.auth  // this is error
    var loginERror by remember {
        mutableStateOf<String?>(null)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        OutlinedTextField(
            value = state.email,
            onValueChange = { state.email = it },
            label = {
                Text(text = "Email") },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    // Handle focus changes if needed
                }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        OutlinedTextField(
            value = state.password,
            onValueChange = { state.password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                auth.signInWithEmailAndPassword(state.email, state.password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            navController.navigate("marketapp")
                        }else{
                            loginERror = task.exception?.message
                        }
                    }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        loginERror?.let { 
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        // Dialog
        if (state.showDialog) {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog
                    state.showDialog = false
                },
                title = {
                    Text("User Information")
                },
                text = {
                    Column {
                        Text("Email: ${state.email}")
                        Text("Password: ${state.password}")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            // Dismiss the dialog
                            state.showDialog = false
                        }
                    ) {

                        Text("OK")
                    }
                }
            )
        }
    }
}


