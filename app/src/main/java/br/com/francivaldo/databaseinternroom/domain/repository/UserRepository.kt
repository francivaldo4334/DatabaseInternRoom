package br.com.francivaldo.databaseinternroom.domain.repository

import br.com.francivaldo.databaseinternroom.data.Room.User.UserDao
import br.com.francivaldo.databaseinternroom.domain.model.UserCtrl
import br.com.francivaldo.databaseinternroom.domain.model.fromEntity
import br.com.francivaldo.databaseinternroom.domain.model.toEntity

class UserRepository(
  private val userDao: UserDao
) :UserRepositoryImterface {
    override suspend fun setUser(user: UserCtrl) {
        userDao.setUser(user = user.toEntity())
    }

    override suspend fun getUser(id: Long): UserCtrl {
        return UserCtrl().fromEntity(userDao.getUser(id))
    }

    override suspend fun listUsers(): List<UserCtrl> {
        return userDao.listUsers().map { UserCtrl().fromEntity(it) }
    }

    override suspend fun deleteUser(id: Long) {
        userDao.deleteUser(id)
    }
}
interface UserRepositoryImterface {
    suspend fun setUser(user: UserCtrl)
    suspend fun getUser(id:Long): UserCtrl
    suspend fun listUsers():List<UserCtrl>
    suspend fun deleteUser(id:Long)
}