package com.example.cobros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.cobros.navigation.NavManager
import com.example.cobros.room.CobrosDatabase
import com.example.cobros.ui.theme.CobrosTheme
import com.example.cobros.viewmodels.CobrosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobrosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, CobrosDatabase::class.java, "db_cobros").build()
                    val dao = database.cobrosDao()

                    val viewModel = CobrosViewModel(dao)

                    NavManager(viewModel = viewModel)

                }
            }
        }
    }
}

