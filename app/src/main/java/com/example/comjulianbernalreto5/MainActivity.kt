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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComJulianBernalReto5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    ListaScreen(
                        elementos = elementos,
                        onElementoClick = { id ->
                            // La navegacion la agregamos despues
                        },
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

