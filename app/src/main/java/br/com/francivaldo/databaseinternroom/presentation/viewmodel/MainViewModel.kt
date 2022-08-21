package br.com.francivaldo.databaseinternroom.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.francivaldo.databaseinternroom.data.Room.AppRoomDatabase
import br.com.francivaldo.databaseinternroom.domain.model.toUI
import br.com.francivaldo.databaseinternroom.domain.repository.UserRepository
import br.com.francivaldo.databaseinternroom.presentation.model.UserUI
import br.com.francivaldo.databaseinternroom.presentation.model.toCtrl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application) : ViewModel() {
    private val repository : UserRepository

    var userResponse by mutableStateOf(UserUI())
    var listUserResponse by mutableStateOf(listOf<UserUI>())
    init {
        val userDB = AppRoomDatabase.getInstance(application)
        val userDao = userDB.userDao()
        repository = UserRepository(userDao)
    }
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    fun getUser(id:String){
        viewModelScope.launch {
            userResponse =  repository.getUser(id.toLong()).toUI()
        }
    }
    fun getlistUsers(){
        coroutineScope.launch {
            listUserResponse  = repository.listUsers().map { it.toUI() }
        }
    }
    fun setUser(user:UserUI){
        coroutineScope.launch {
            repository.setUser(user.toCtrl())
        }
    }
    fun deleteUser(id:String){
        coroutineScope.launch {
            repository.deleteUser(id.toLong())
        }
    }
}