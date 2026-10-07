package com.example.comjulianbernalreto5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.comjulianbernalreto5.model.Elemento

@Composable
fun DetalleScreen(
    //Se accede a la clase elemento-model para acceder a los atributos de esa clase
    elemento: Elemento,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = elemento.titulo,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Categoría: ${elemento.categoria}",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = elemento.descripcionLarga,
            style = MaterialTheme.typography.bodyLarge
        )
        //Boton para regrear a la lista
        Button(
            onClick = onVolver
        ) {
            Text("Volver")
        }
    }
}