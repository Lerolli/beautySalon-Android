package com.example.beautysalon_android.EnrollModule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.beautysalon_android.NavigationItem
import com.example.beautysalon_android.R
import com.example.beautysalon_android.ServicesModule.Service
import java.time.LocalDateTime
import java.util.Date

@Composable
fun EnrollScreen(services: List<Service>, serviceName: String, navController: NavHostController) {
    val service = services.find { it.name == serviceName }!!
    val times = listOf(
        LocalDateTime.now(),
        LocalDateTime.now().plusDays(5),
        LocalDateTime.now().plusDays(10),
    )
    val masters = listOf(
        "Галя",
        "Людмила",
        "Томара",
    )

    var masterExpanded by remember { mutableStateOf(false) }
    var timeExpanded by remember { mutableStateOf(false) }

    var master by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
    var tTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val mIcon = if (masterExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val tIcon = if (timeExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val padding = 16.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorPrimaryDark))
            .wrapContentSize(Alignment.Center)
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
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = master,
                onValueChange = { master = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        mTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Мастер") },
                trailingIcon = {
                    Icon(mIcon, "contentDescription",
                        Modifier.clickable { masterExpanded = !masterExpanded })
                }
            )

            DropdownMenu(
                expanded = masterExpanded,
                onDismissRequest = { masterExpanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
            ) {
                masters.forEach { label ->
                    DropdownMenuItem(onClick = {
                        master = label
                        masterExpanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        tTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Время") },
                trailingIcon = {
                    Icon(tIcon, "contentDescription",
                        Modifier.clickable { timeExpanded = !timeExpanded })
                }
            )

            DropdownMenu(
                expanded = timeExpanded,
                onDismissRequest = { timeExpanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { tTextFieldSize.width.toDp() })
            ) {
                times.forEach { label ->
                    DropdownMenuItem(onClick = {
                        time = label.toString()
                        timeExpanded = false
                    }) {
                        Text(text = label.toString())
                    }
                }
            }
        }
        Button(
            onClick = { },
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = stringResource(id = R.string.enroll), modifier = Modifier.padding(8.dp))
        }
    }
}