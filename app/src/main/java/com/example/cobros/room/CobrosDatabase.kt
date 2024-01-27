package com.example.cobros.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cobros.models.Cobros

@Database(
    entities = [Cobros::class],
    version = 5,
    exportSchema = false
)
abstract class CobrosDatabase :RoomDatabase(){
    abstract fun cobrosDao(): CobrosDatabaseDao
}

class MedidoresDatabase {
}