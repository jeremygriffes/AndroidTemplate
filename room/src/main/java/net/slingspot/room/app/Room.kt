package net.slingspot.room.app

import android.content.Context
import androidx.room.Room

internal class Room constructor(context: Context) {
    private val db = Room.databaseBuilder(context, AppDatabase::class.java, dbName)
        .fallbackToDestructiveMigration()
        .build()

    internal val dao = db.appDao()

    companion object {
        private val tag = Room::javaClass.name
        const val dbName = "myapplication"
    }
}
