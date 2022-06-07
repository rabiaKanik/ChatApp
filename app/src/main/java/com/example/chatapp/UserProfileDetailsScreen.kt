package com.example.chatapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.ui.theme.MyTheme

@Composable
fun UserProfileDetailsScreen(userId :Int, navController: NavHostController?){
    val userProfile = userProfileList.first { userProfile -> userId == userProfile.id }
    Scaffold( topBar = {
        AppBar(
            title = "Kişi Bilgisi",
            icon = Icons.Default.ArrowBack)
        {
            navController?.navigateUp()
        }

    }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ProfilePicture(userProfile.pictureUrl, userProfile.status,240.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
                ProfileButtonAction()
                ProfileNotification()
                ProfileChildNotification()
            }
        }
    }
}
@Composable
fun ProfileNotification(){

    Card(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        elevation = 2.dp,
        )
        {
            Column() {
                Row(
                    Modifier
                        .padding(start = 15.dp)
                        .clickable{ },
                ) {
                    Icon(

                        Icons.Filled.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier.padding(start = 25.dp, top = 15.dp, bottom = 5.dp),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {

                        Text(
                            buildAnnotatedString {

                                Text("Bildirimleri sesize al")
                            }
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(start = 15.dp)
                        .clickable{ },
                ) {
                    Icon(

                        Icons.Filled.MusicNote,
                        contentDescription = "Notification",
                        modifier = Modifier.padding(start = 25.dp, top = 15.dp, bottom = 5.dp),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {

                        Text(
                            buildAnnotatedString {

                                Text("Özel Bildirimler")
                            }
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(start = 15.dp)
                        .clickable{ },
                ) {
                    Icon(

                        Icons.Filled.Image,
                        contentDescription = "Media",
                        modifier = Modifier.padding(start = 25.dp, top = 15.dp, bottom = 5.dp),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {

                        Text(
                            buildAnnotatedString {

                                Text("Medya görünürlüğü")
                            }
                        )
                    }
                }
            }
        }
}
/*

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* ... */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = "Notification",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Bildirimleri sesize al")
            }
            Button(
                onClick = { /* ... */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){

                    Icon(
                        Icons.Filled.MusicNote,
                        contentDescription = "privateNotification",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Özel Bildirimler")
                }
            }
            Button(
                onClick = { /* ... */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Row(

                ) {
                    Icon(
                        Icons.Filled.Image,
                        contentDescription = "Media",
                    )
                    //Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        text="Medya görünürlüğü"

                        )
                }

            }
        }
 */
@Composable
fun ProfileButtonAction(){
    Row(
        Modifier
            .padding(1.dp)

    ) {
        Button(
            onClick = {
                // do something here
            },
            modifier = Modifier.size(width = 100.dp,height = 60.dp)
        ) {
            Column(
                modifier = Modifier.padding(11.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Localized description"
                )
                //Text(text = "Sesli")
            }

        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {
                // do something here
            },
            modifier = Modifier.size(width = 100.dp,height = 60.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Videocam,
                    contentDescription = "Localized description"
                )
                //Text(text = "Görüntülü")
            }
        }

        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {
                // do something here
            },
            modifier = Modifier.size(width = 100.dp,height = 60.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Localized description"
                )
                //Text(text = "Ara")
            }
        }
    }
}

@Composable
fun ProfileChildNotification(){
    Card(
        modifier = Modifier
            //.padding(2.dp)
            .clickable { },
        elevation = 2.dp,
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            Modifier
                .padding(start = 15.dp)
        ) {
            Icon(
                modifier = Modifier.padding(start = 25.dp, top = 25.dp),
                imageVector = Icons.Filled.Lock,
                contentDescription = "Localized description"
            )
            Column(
                modifier = Modifier.padding(15.dp)
            ) {

                Text(
                    buildAnnotatedString {
                        append("Şifreleme")
                    }
                )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Light, fontSize = 15.sp, color = Color.Gray)
                        ) {
                            append("Mesajlar ve aramalar uçtan uca şifrelidir. ")
                            append(" Doğrulamak için dokunun")
                        }

                    }
                )
            }
        }
        }

}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsScreenPreview() {
    MyTheme{
        UserProfileDetailsScreen(userId = 0,null)
    }
}