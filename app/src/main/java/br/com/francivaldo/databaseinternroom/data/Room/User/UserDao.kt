package br.com.francivaldo.databaseinternroom.data.Room.User

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun setUser(user:UserEntity)
    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUser(id:Long):UserEntity
    @Query("SELECT * FROM users")
    suspend fun listUsers():List<UserEntity>
    @Query("DELETE FROM users WHERE id = :id")
    suspend fun deleteUser(id:Long)
}