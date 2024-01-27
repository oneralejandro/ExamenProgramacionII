package com.example.cobros.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cobros.models.Cobros
import com.example.cobros.viewmodels.CobrosViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarView(navController: NavController, viewModel: CobrosViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Agregar Cuenta", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ) {
        ContentAgregarView(it, navController, viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ContentAgregarView(it: PaddingValues, navController: NavController, viewModel: CobrosViewModel) {
    var medidor by remember { mutableStateOf("") }
    var tipoMedidor = listOf("Agua","Luz", "Gas")
    var tipoMedidorSeleccionado by rememberSaveable { mutableStateOf( tipoMedidor[0]) }
    var fecha by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = medidor,
            onValueChange = { medidor = it },
            label = { Text(text = "medidor") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(

            value = fecha,
            onValueChange = { fecha = it },
            label = { Text(text = "Fecha") },
            placeholder = { Text("2024-12-25") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )


        Column(Modifier.selectableGroup()) {
            tipoMedidor.forEach { tipoMedidor ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (tipoMedidor == tipoMedidorSeleccionado),
                            onClick = { tipoMedidorSeleccionado = tipoMedidor },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (tipoMedidor == tipoMedidorSeleccionado),
                        onClick = null
                    )
                    Text(
                        text = tipoMedidor,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }



        Button(
            onClick = {
                val cobros = Cobros(medidor = medidor, tipoMedidor = tipoMedidorSeleccionado, fecha = fecha)

                viewModel.agregarCobros(cobros)
                navController.popBackStack()
            }
        ) {
            Text(text = "Regitrar Medicion")
        }
    }
}