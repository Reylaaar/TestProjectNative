package com.reylar.testprojectnativeandroid.presentation.home

sealed class Screen(val route: String){

    object home : Screen("homeScreen")

    object dashboard : Screen("dashboard")

    object info : Screen("info")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}