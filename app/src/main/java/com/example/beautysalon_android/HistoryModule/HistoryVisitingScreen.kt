package com.example.beautysalon_android.HistoryModule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beautysalon_android.HistoryModule.Views.HistoryView
import com.example.beautysalon_android.NavigationItem
import com.example.beautysalon_android.R
import com.example.beautysalon_android.ServicesModule.Service
import com.example.beautysalon_android.ServicesModule.Views.ServiceView
import com.example.beautysalon_android.servicesViewModel
import java.time.LocalDateTime

@Composable
fun HistoryVisitingScreen(navController: NavHostController) {
    val history = listOf(
        Triple("Галя",LocalDateTime.now().toString(), servicesViewModel.services[0]),
        Triple("Томара", LocalDateTime.now().minusDays(3).toString(), servicesViewModel.services[1]),
        Triple("Антонина", LocalDateTime.now().minusDays(5).toString(), servicesViewModel.services[2])
    )

    LazyColumn {
        history.map {
            item {
                HistoryView(it.third, it.first, it.second, onItemClick = { name, master, time ->
                    navController.navigate(NavigationItem.History.route + "/${name}/${master}/${time}")
                })
            }
        }
    }
}