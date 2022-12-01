package com.example.beautysalon_android.ProfileModule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.beautysalon_android.NavigationItem
import com.example.beautysalon_android.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var smsCode by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorPrimaryDark))
            .wrapContentSize(Alignment.Center)
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text(text = stringResource(id = R.string.phone)) },
                placeholder = { Text(text = stringResource(id = R.string.phone)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = stringResource(id = R.string.send_sms), modifier = Modifier.padding(8.dp))
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = smsCode,
                onValueChange = { smsCode = it },
                label = { Text(text = stringResource(id = R.string.smsCode)) },
                placeholder = { Text(text = stringResource(id = R.string.smsCode)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = {
                navController.navigate(NavigationItem.Services.route)
            },
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(
                text = stringResource(id = R.string.login_button),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}