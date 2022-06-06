package com.example.chatapp

data class UserProfile constructor(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf<UserProfile>(

    UserProfile(name = "Mike Doe", status = true, R.drawable.profile_picture),
    UserProfile(name = "Sully Doe", status = false, R.drawable.sully),
)