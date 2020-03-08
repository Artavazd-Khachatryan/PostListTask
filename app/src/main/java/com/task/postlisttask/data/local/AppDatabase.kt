package com.task.postlisttask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.postlisttask.data.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun postDao(): PostDao

}