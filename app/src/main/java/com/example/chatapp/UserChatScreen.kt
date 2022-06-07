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

                LazyColumn {
                    // using TextButton, comes with certain default style and padding
                    item {
                        TextButton(modifier = Modifier.fillMaxWidth(), onClick = { }) {
                            Row {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    // painterResource(id = R.drawable.ic_baseline_add_24),
                                    contentDescription = "New Album"
                                )
                                Text("New Album")
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }

                    // divider text
                    item {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "More",
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
                        )
                    }

                    // using Row with Clickable
                    item {
                        Row(
                            modifier = Modifier.clickable {  }.padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                // painterResource(id = R.drawable.ic_baseline_add_24),
                                contentDescription = "New Album"
                            )
                            Text("New Album")
                            // Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
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