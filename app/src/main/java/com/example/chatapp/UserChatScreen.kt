package com.example.chatapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.ui.theme.MyTheme

@Composable
fun UserChatScreen(){
    Scaffold(topBar = {
        AppBar(title = "user", icon = Icons.Default.ArrowBack) {}
    }) {
        Surface(modifier = Modifier.fillMaxSize()){


            }
        }

}
@Preview(showBackground = true)
@Composable
fun UserChatScreenPreview(){
    MyTheme() {
        UserChatScreen()
    }
}