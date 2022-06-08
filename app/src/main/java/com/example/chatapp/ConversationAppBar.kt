package com.example.chatapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun ConversationAppBar( id :Int, icon: ImageVector, iconClickAction: ()-> Unit){
    val userProfile = userProfileList[id]
    TopAppBar(
        navigationIcon = {
            Icon(
                icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp

                    )
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        },
        title = {
            Row() {
                ProfilePicture(pictureUrl = userProfile.pictureUrl, onlineStatus = userProfile.status, imageSize = 32.dp)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = userProfile.name,
                    fontSize = 17.sp,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(
                            //start = 0.5.dp,
                            top = 18.dp
                        )
                    ) }
            }
    )
}

@Composable
fun ButtonBarChat(){
    var message: TextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var expanded: Boolean by remember { mutableStateOf(true) }

    BottomNavigation(
        elevation = 2.dp,
        modifier = Modifier.padding(top = 12.dp)
    ){
        AnimatedVisibility(visible = expanded) {
            Icon(
                imageVector = Icons.Rounded.NavigateNext,
                contentDescription = "openbar",
                Modifier
                    .padding(8.dp, 4.dp, 4.dp, 4.dp)
                    .clickable(onClick = { expanded = false })
            )
        }
        AnimatedVisibility(visible = !expanded) {
            Row(){
                Icon(
                    imageVector = Icons.Rounded.CameraAlt,
                    contentDescription = "Camera",
                    Modifier
                        .padding(8.dp, 13.dp, 4.dp, 4.dp)
                        .clickable(onClick = { })
                )
                Icon(
                    imageVector = Icons.Rounded.Image,
                    contentDescription = "New Album",
                    Modifier
                        .padding(8.dp, 13.dp, 4.dp, 4.dp)
                        .clickable(onClick = { })
                )
                Icon(
                    imageVector = Icons.Rounded.Mic,
                    contentDescription = "New Album",
                    Modifier
                        .padding(8.dp, 13.dp, 4.dp, 4.dp)
                        .clickable(onClick = { })
                )


            }
        }
        Row(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.9f))
                .padding(top = 2.dp, end = 3.dp),
            //.weight(1f,true)
            verticalAlignment = Alignment.CenterVertically
        ){
            BasicTextField(
                value = message ,
                onValueChange = { message = it ; expanded = true},
                modifier = Modifier
                    .padding(bottom = 3.dp, end = 8.dp)
                    .weight(0.5f, true),
                textStyle = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.onSurface),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.None ),
                visualTransformation = VisualTransformation.None
            )
            Icon(
                imageVector = Icons.Rounded.EmojiEmotions,
                tint = MaterialTheme.colors.primary,
                contentDescription = "Emoji",
                modifier = Modifier
                    .padding(4.dp, 4.dp)
                    .clickable(onClick = {})
            )
        }
        when(message.text.isNotEmpty()){
            true ->{
                Icon(
                    imageVector = Icons.Rounded.Send,
                    contentDescription = "send button",
                    modifier = Modifier.clickable(onClick = {
                        //onSendClick(message.text)
                        message = TextFieldValue("")
                    })
                        .padding(8.dp, 4.dp)
                )
            }
            false ->{
                IconButton(onClick = {}) {

                }

            }
        }


    }



}
@Composable
fun BarScreen(userProfile: UserProfile, navController: NavHostController?){
    Scaffold(topBar = {
        ConversationAppBar(
            id = userProfile.id,
             // bi bak
            icon = Icons.Default.ArrowBack
        ) { }
    },
    bottomBar = { ButtonBarChat() }
    ){

    }


}

@Preview(showBackground = true)
@Composable
fun AppBarLeftIconPreview(){
    ButtonBarChat()
}


@Preview(showBackground =false)
@Composable
fun BarScreenPreview(){
    BarScreen(userProfile = UserProfile(0,"Michaela Runnings",true,"https://images.unsplash.com/photo-1485290334039-a3c69043e517?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80 "), navController = null)
}


