package br.com.francivaldo.databaseinternroom.data.Room

import android.content.Context
import br.com.francivaldo.databaseinternroom.data.Room.User.UserDao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.francivaldo.databaseinternroom.data.Room.User.UserEntity

@Database(entities = [(UserEntity::class)], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {

        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppRoomDatabase::class.java,
                        "product_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}