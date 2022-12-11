package com.example.beautysalon_android.HistoryModule

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beautysalon_android.NavigationItem
import com.example.beautysalon_android.R
import androidx.compose.material.Text as Text1

@Composable
fun HistoryScreen(services: List<com.example.beautysalon_android.ServicesModule.Service>, serviceName: String, master:String, time: String, navController: NavHostController) {
    val service = services.find { it.name == serviceName }!!

    var review by remember { mutableStateOf(TextFieldValue("")) }

    val padding = 16.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.ic_book),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = service.name!!, fontSize = 30.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = "Мастер: $master")
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text1(text = "Дата и время посещения: $time")
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = review,
                onValueChange = { review = it },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = { },
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
        ) {
            Text1(text = "Оставить отзыв", modifier = Modifier.padding(8.dp))
        }
    }
}