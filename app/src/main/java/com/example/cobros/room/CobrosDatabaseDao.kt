package com.example.cobros.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cobros.models.Cobros
import kotlinx.coroutines.flow.Flow

@Dao
interface CobrosDatabaseDao {

    @Query("SELECT * FROM cobros")
    fun obtenerCobros(): Flow<List<Cobros>>

    @Query("SELECT * FROM cobros WHERE id = :id ")
    fun obtenerCobros(id: Int): Flow<Cobros>

    @Insert
    suspend fun agregarCobro(cobros: Cobros)


}