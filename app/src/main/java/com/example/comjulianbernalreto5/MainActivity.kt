package com.example.comjulianbernalreto5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.comjulianbernalreto5.ui.theme.ComJulianBernalReto5Theme
import com.example.comjulianbernalreto5.ui.theme.ComJulianBernalReto5Theme
import com.example.comjulianbernalreto5.data.elementos
//Para crear las rutas de navegacion
import androidx.navigation.compose.rememberNavController
//Para agregar el navHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComJulianBernalReto5Theme {
                //Controlador de navegacion que maneja las pantallas
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    //Indica que nuestra aplicación utilizará navegación y que inicialmente mostrará la ruta "lista"
                    NavHost(
                        navController = navController,
                        startDestination = "lista",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        //Define la pantalla de la lista como la primera ruta.
                        composable ("lista") {

                            ListaScreen(
                                elementos = elementos,
                                onElementoClick = { id ->
                                    navController.navigate("detalle/$id") {
                                        //le indica al NavController que no agregue otra instancia de la misma ruta si ya está en la parte superior.
                                        launchSingleTop = true
                                    }

                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        //Definimos la ruta del detalle
                        composable ("detalle/{elementoId}") { backStackEntry ->

                            //Recibe el id y lo convierte a numero con el toIntOrNull()
                            val elementoId = backStackEntry.arguments?.getString("elementoId")?.toIntOrNull()

                            //Busca dentro de la lista el elemento cuyo id sea el buscado
                            val elemento = elementos.find {
                                it.id == elementoId
                            }

                            //comprueba que encontramos el elemento.
                            if (elemento != null) {
                                DetalleScreen(
                                    elemento = elemento,
                                    onVolver = {
                                        navController.popBackStack()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

