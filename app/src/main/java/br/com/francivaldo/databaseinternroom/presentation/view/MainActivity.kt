package br.com.francivaldo.databaseinternroom.presentation.view

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.francivaldo.databaseinternroom.presentation.Common
import br.com.francivaldo.databaseinternroom.presentation.viewmodel.MainViewModel
import br.com.francivaldo.databaseinternroom.presentation.model.UserUI
import br.com.francivaldo.databaseinternroom.presentation.view.ui.theme.DatabaseInternRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Init viewModel
        val application = applicationContext as Application
        Common.setViewModel(MainViewModel(application))
        //Create layout
        Common.getViewModel().getlistUsers()
        setContent {
            DatabaseInternRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var valueFirstN by remember{
                        mutableStateOf("")
                    }
                    var valueLastN by remember{
                        mutableStateOf("")
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(text = "FirstName:")
                        TextField(value = valueFirstN, onValueChange = {valueFirstN = it},modifier = Modifier.fillMaxWidth())
                        Text(text = "LastName:")
                        TextField(value = valueLastN, onValueChange = {valueLastN = it},modifier = Modifier.fillMaxWidth())
                        //Buttons
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Button(onClick = {
                                if(valueFirstN.isBlank() || valueFirstN.isEmpty() || valueLastN.isBlank() || valueLastN.isEmpty())
                                    return@Button
                                Common.getViewModel().setUser(UserUI(valueFirstN,valueLastN))
                                Common.getViewModel().getlistUsers()
                            }) {
                                Text(text = "Add user")
                            }
                        }
                        //List items
                        LazyColumn{
                            items(Common.getViewModel().listUserResponse){
                                Text(text = "${it.username}\n${it.lastname}",modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}