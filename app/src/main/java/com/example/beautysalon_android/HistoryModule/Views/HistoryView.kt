package com.example.beautysalon_android.HistoryModule.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.beautysalon_android.R
import com.example.beautysalon_android.ServicesModule.Service

@Composable
fun HistoryView(service: Service, master:String, time: String, onItemClick:(name:String, master:String, time:String ) -> Unit) {
    Row(modifier = Modifier
        .padding(all = 8.dp)
        .clickable { onItemClick(service.name!!, master, time) }) {
        Image(
            painter = painterResource(R.drawable.ic_book),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = service.name ?: "")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Мастер: $master")
            Text(text = "Дата и время посещения: $time")
        }
    }
}