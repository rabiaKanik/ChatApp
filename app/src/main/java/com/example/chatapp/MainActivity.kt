package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.chatapp.ui.theme.MyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme{
                UserApplication()
            }

        }
    }
}

@Composable
fun UserApplication(userProfiles: List<UserProfile> = userProfileList){
    val navController =  rememberNavController()
    NavHost(navController = navController, startDestination = "users_list"){
        composable("users_list"){
            UserListScreen(userProfiles, navController)
        }
        composable(
            route = "user_details/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            UserProfileDetailsScreen(navBackStackEntry.arguments!!.getInt("userId"), navController)
        }
    }
}
@Composable
fun UserListScreen(userProfiles: List<UserProfile>, navController: NavHostController?){
    Scaffold(topBar = {
        AppBar(
            title = "Users list",
            icon = Icons.Default.Home,
            //icon = Icons.Default.ArrowDropDown
        ) { }
    },
        bottomBar = {BottomBar()}
    )
    {
        Surface(
            modifier = Modifier.fillMaxSize()
        ){
            LazyColumn{
                items(userProfiles){
                    userProfile -> ProfileCard(userProfile = userProfile){
                        navController?.navigate("user_details/${userProfile.id}")
                    }
                }
            }

        }
    }


}
@Composable
fun BottomBar(){
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Sohbet") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.MailOutline,"")
        },
            label = { Text(text = "Arşiv") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Settings,"")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }


}
@Composable
fun UserProfileDetailsScreen(userId :Int, navController: NavHostController?){
    val userProfile = userProfileList.first { userProfile -> userId == userProfile.id }
    Scaffold( topBar = {
        AppBar(
        title = "users profile details",
        icon = Icons.Default.ArrowBack)
        {
            navController?.navigateUp()
        }

    }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(userProfile.pictureUrl, userProfile.status,240.dp)
                ProfileContent(userProfile.name, userProfile.status,Alignment.CenterHorizontally)
                ProfileButtonAction()

            }
        }
    }
}

@Composable
fun ProfileButtonAction(){
        Row(
            Modifier
                .padding(8.dp)

        ) {
            Button(
                onClick = {
                    // do something here
                }
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "Localized description"
                    )
                    Text(text = "Sesli")
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    // do something here
                }
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = "Localized description"
                    )
                    Text(text = "Görüntülü")
                }
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    // do something here
                }
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
                    Text(text = "Ara")
                }
            }
        }
        //Divider(color = Color.Blue, thickness = 1.dp)
        Card(
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(text = "Medya Bağıntıları")

        }

}

@Composable
fun AppBar(title : String, icon: ImageVector, iconClickAction: ()-> Unit){
    TopAppBar(
        navigationIcon = {
            Icon(
                icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = { iconClickAction.invoke() })
            )
        },
        title = { Text(text = title)}
    )
}
@Composable
fun ProfileCard(userProfile: UserProfile, clickAction:() -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = { clickAction.invoke() }),
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status,72.dp)
            ProfileContent(userProfile.name, userProfile.status,Alignment.Start)

        }

    }
}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ){
        CompositionLocalProvider(
            /*
            LocalContentAlpha provides (
                    if(onlineStatus) else ContentAlpha.medium
                    )
            AmbientContentAlpha provides(
                if(onlineStatus)
                    if else ContentAlpha.medium )

             */
        ) {

        }
        Text(
            text = userName,
            style = MaterialTheme.typography.h5
        )
        CompositionLocalProvider(LocalContentAlpha provides( ContentAlpha.medium)){
            Text(
                text = if (onlineStatus)"Active Now" else "Offline",
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, imageSize:Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus)
                Color.Green
                else Color.Red
        ),
        modifier = Modifier
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = rememberImagePainter(
                data = pictureUrl,
                builder = {
                    transformations(CircleCropTransformation())
                },
            ),
            modifier = Modifier.size(imageSize),
            contentDescription = "Profile picture description",
        )


    }
}


@Preview(showBackground = true)
@Composable
fun UserProfileDetailsScreenPreview() {
    MyTheme{
        UserProfileDetailsScreen(userId = 0,null)
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    MyTheme{
        UserListScreen(userProfiles = userProfileList,null)
    }
}