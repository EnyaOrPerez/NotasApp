package net.enyaortiz.notasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.enyaortiz.notasapp.ui.screens.AddNoteScreen
import net.enyaortiz.notasapp.ui.screens.HomeScreen
import net.enyaortiz.notasapp.ui.theme.NotasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita el borde a borde de la pantalla
        setContent {
            NotasAppTheme {
                NotasApp() // Llamamos a la función de navegación
            }
        }
    }
}

@Composable
fun NotasApp() {
    val navController = rememberNavController()

    // Definimos las pantallas dentro del NavHost
    NavHost(navController = navController, startDestination = "home") {
        // Pantalla principal
        composable("home") {
            HomeScreen(
                onAddNoteClick = {
                    // Navegar a la pantalla de agregar nota
                    navController.navigate("add_note")
                }
            )
        }

        // Pantalla para agregar una nota
        composable("add_note") {
            AddNoteScreen(
                onSaveNote = { title, description ->
                    // Aquí puedes procesar el guardado de la nota
                    navController.popBackStack() // Regresa a la pantalla principal
                },
                onBack = {
                    navController.popBackStack() // Regresa a la pantalla anterior
                }
            )
        }
    }
}
