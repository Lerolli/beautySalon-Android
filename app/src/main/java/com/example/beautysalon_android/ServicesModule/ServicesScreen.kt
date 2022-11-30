package com.example.beautysalon_android

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.beautysalon_android.ServicesModule.Service
import com.example.beautysalon_android.ServicesModule.Views.ServiceView

@Composable
fun ServicesScreen(services: List<Service>, navController: NavHostController) {
    LazyColumn {
        services.map {
            item {
                ServiceView(service = it, onItemClick = { name ->
                    navController.navigate(NavigationItem.Service.route + "/${name}")
                })
            }
        }
    }
}