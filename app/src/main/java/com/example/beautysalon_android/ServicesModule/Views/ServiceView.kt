package com.example.beautysalon_android.ServicesModule.Views

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
fun ServiceView(service: Service,
                onItemClick:(name:String) -> Unit) {
    // Add padding around our message
    Row(modifier = Modifier
        .padding(all = 8.dp)
        .clickable { onItemClick(service.name!!) }) {
        Image(
            painter = painterResource(R.drawable.ic_book),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = service.name ?: "")
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = service.price.toString())
            Text(text = service.description ?: "")
        }
    }
}