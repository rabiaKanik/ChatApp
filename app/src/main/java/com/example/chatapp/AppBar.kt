package com.example.chatapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun AppBar(title : String, icon: ImageVector, iconClickAction: ()-> Unit){
    TopAppBar(
        navigationIcon = {
            Icon(
                icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 20.dp

                    )
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        },
        title = { Text(text = title) }
    )
}
