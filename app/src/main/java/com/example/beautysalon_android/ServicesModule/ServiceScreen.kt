package com.example.beautysalon_android.ServicesModule

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beautysalon_android.R

@Composable
fun ServiceScreen(services: List<Service>, serviceName: String) {
    val service = services.find { it.name == serviceName }!!

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
            Text(text = service.name!!, fontSize = 30.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service.price.toString(), fontSize = 20.sp)
        }
        Spacer(Modifier.size(padding))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = service.description!!, fontSize = 10.sp)
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
        ) {
            Text(text = stringResource(id = R.string.enroll), modifier = Modifier.padding(8.dp))
        }
    }
}