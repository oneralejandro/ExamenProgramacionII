package com.example.cobros.states

import com.example.cobros.models.Cobros

data class CobrosState(
    val listaCobros: List<Cobros> = emptyList()
)
