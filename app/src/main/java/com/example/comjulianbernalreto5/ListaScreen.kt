package com.example.comjulianbernalreto5

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
//Hace que un componente ocupetodo el ancho disponible:
import androidx.compose.foundation.layout.fillMaxWidth
//Sirve para agregar espacio alrededor o dentro de un componente.
import androidx.compose.foundation.layout.padding
//Crea una lista vertical desplazable.
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.comjulianbernalreto5.model.Elemento

@Composable
fun ListaScreen(
    //Elementos Es la lista que se creo anteriormente
    elementos: List<Elemento>,
    //Esta es una función que recibimos desde fuera
    onElementoClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) { //Dice algo como: "Recorre todos los elementos de esta lista."
    LazyColumn(
        modifier = modifier
    ) {
        items(
            elementos,
            //Significa: Obtén el id del elemento actual
            key = { it.id }
        //Para cada elemento de la lista, llámalo temporalmente elemento para acceder a ellos
        ) { elemento ->
            //Cada videojuego tendrá una tarjeta independiente
            Card(
                //Dice algo como: A esta tarjeta daletodo el ancho disponible y agrega 8dp de espacio
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    //Dice algo como: Cuando el usuario toque esta tarjeta, ejecuta esto...(onElementoClick(elemento.id))
                    .clickable {
                        onElementoClick(elemento.id)
                    }
            ) { //Dentro de la tarjeta, coloca los elementos verticalmente
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = elemento.titulo,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = elemento.descripcionCorta,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}