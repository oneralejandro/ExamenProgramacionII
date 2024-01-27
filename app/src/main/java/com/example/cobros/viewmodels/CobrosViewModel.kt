package com.example.cobros.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cobros.models.Cobros
import com.example.cobros.room.CobrosDatabaseDao
import com.example.cobros.states.CobrosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CobrosViewModel (
    private  val dao: CobrosDatabaseDao
): ViewModel(){
    var state by mutableStateOf(CobrosState())
        private set
    //compoartamiento cuando inicia el viewmodel
    init {
        //corrutina
        viewModelScope.launch {
            dao.obtenerCobros().collectLatest {
                state = state.copy(
                    listaCobros = it
                )
            }
        }
    }
    //llamados a los otros elementos del dao (agregar)
    fun agregarCobros(cobros: Cobros) = viewModelScope.launch {
        dao.agregarCobro(cobros = cobros)
    }


}