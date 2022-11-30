package com.example.beautysalon_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.beautysalon_android.HistoryModule.HistoryVisitingScreen
import com.example.beautysalon_android.ProfileModule.ProfileScreen
import com.example.beautysalon_android.ServicesModule.ServiceScreen
import com.example.beautysalon_android.ServicesModule.ServicesViewModel

val servicesViewModel = ServicesViewModel()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {},
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.colorPrimaryDark) // Set background color to avoid the white flashing when you switch between screens
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Services.route) {
        composable(NavigationItem.Services.route) {
            servicesViewModel.getServices()
            ServicesScreen(servicesViewModel.services, navController)
        }
        composable(NavigationItem.HistoryVisiting.route) {
            HistoryVisitingScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(
            NavigationItem.Service.route + "/{serviceName}",
            arguments = listOf(navArgument("serviceName") { type = NavType.StringType })
        )
        { backStackEntry ->
            val serviceName = backStackEntry.arguments!!.getString("serviceName")!!
            ServiceScreen(servicesViewModel.services, serviceName)
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Services,
        NavigationItem.HistoryVisiting,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}
sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Services : NavigationItem("services", R.drawable.ic_book, "Услуги")
    object HistoryVisiting : NavigationItem("historyVisiting", R.drawable.ic_book, "История посещений")
    object Profile : NavigationItem("profile", R.drawable.ic_book, "Профиль")
    object Service : NavigationItem("service", R.drawable.ic_book, "Услуга")
}