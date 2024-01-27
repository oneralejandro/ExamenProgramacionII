package com.example.cobros.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cobros")
data class Cobros(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("Medidor")
    val medidor: String,
    @ColumnInfo("tipoMedidor")
    val tipoMedidor: String,

    @ColumnInfo("fecha")
    val fecha: String


)


