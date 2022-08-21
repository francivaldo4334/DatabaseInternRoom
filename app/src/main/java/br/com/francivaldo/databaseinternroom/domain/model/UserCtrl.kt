package br.com.francivaldo.databaseinternroom.domain.model

import br.com.francivaldo.databaseinternroom.data.Room.User.UserEntity
import br.com.francivaldo.databaseinternroom.presentation.model.UserUI

data class UserCtrl(
    val firsName:String = "",
    val lastName:String = ""
)
fun UserCtrl.toEntity():UserEntity = UserEntity(
    firsName = this.firsName,
    lastName = this.lastName,
)
fun UserCtrl.fromEntity(item:UserEntity):UserCtrl{
    return UserCtrl(
        firsName = item.firsName,
        lastName = item.lastName
    )
}
fun UserCtrl.toUI():UserUI = UserUI(
    username = this.firsName,
    lastname = this.lastName
)