package com.example.beautysalon_android.AuthModule

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beautysalon_android.R

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    var login by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var surname by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var site by remember { mutableStateOf(TextFieldValue("")) }

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
                value = login,
                onValueChange = { login = it },
                label = { Text(text = stringResource(id = R.string.login)) },
                placeholder = { Text(text = stringResource(id = R.string.login)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = stringResource(id = R.string.name)) },
                placeholder = { Text(text = stringResource(id = R.string.name)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                label = { Text(text = stringResource(id = R.string.surname)) },
                placeholder = { Text(text = stringResource(id = R.string.surname)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
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
        Surface(
            color = Color.White,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            OutlinedTextField(
                value = site,
                onValueChange = { site = it },
                label = { Text(text = stringResource(id = R.string.site)) },
                placeholder = { Text(text = stringResource(id = R.string.site)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp))
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
        ) {
            Text(text = stringResource(id = R.string.register), modifier = Modifier.padding(8.dp))
        }
    }
}