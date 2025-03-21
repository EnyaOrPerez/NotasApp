package net.enyaortiz.notasapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons // Asegúrate de tener esta importación

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    onSaveNote: (String, String) -> Unit,
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nueva Nota") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,  // Usamos el ImageVector de ArrowBack
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Aquí usamos containerColor correctamente
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Campo para el título
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Campo para la descripción
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Botón para guardar la nota
            Button(
                onClick = {
                    onSaveNote(title, description)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Guardar Nota")
            }
        }
    }
}
