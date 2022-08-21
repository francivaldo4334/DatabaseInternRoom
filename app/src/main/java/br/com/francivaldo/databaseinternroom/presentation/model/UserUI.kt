package br.com.francivaldo.databaseinternroom.presentation.model

import br.com.francivaldo.databaseinternroom.domain.model.UserCtrl

data class UserUI (
    val username: String = "",
    val lastname: String = ""
)
fun UserUI.toCtrl():UserCtrl = UserCtrl(
    firsName = this.username,
    lastName = this.lastname
)