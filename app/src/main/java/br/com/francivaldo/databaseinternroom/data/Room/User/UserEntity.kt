package br.com.francivaldo.databaseinternroom.data.Room.User

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    @ColumnInfo(name = "firt")
    val firsName:String,
    @ColumnInfo(name = "last")
    val lastName:String
)
