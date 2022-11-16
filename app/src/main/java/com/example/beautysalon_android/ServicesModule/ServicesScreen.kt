package com.example.beautysalon_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import com.example.beautysalon_android.ServicesModule.Service
import com.example.beautysalon_android.ServicesModule.Views.ServiceView

@Composable
fun ServicesScreen(services: List<Service>) {
    LazyColumn {
        services.map { item { ServiceView(service = it)} }
    }
}