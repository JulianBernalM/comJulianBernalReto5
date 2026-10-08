# Análisis — Taller 5

## 1. Predicción inicial

Antes de realizar la prueba, mi predicción fue que si el usuario toca la misma tarjeta tres veces rapidamente antes de que aparezca completamente la pantalla de detalle, se realizarian tres llamadas a `navigate()`.

Por lo tanto, esperaba que se apilaran tres pantallas de detalle iguales. Al presionar el botón "Volver", no se regresaría directamente a la lista, sino que se mostraria nuevamente otra pantalla de detalle que habia quedado apilada.

Esta situación se produciria porque cada toque genera una nueva navegación hacia la misma ruta de detalle.

## 2 Solucion aplicada
El problema se produce porque cada vez que el usuario toca una tarjeta se ejecuta `navController.navigate()` para abrir la pantalla de detalle.

La navegación agrega el nuevo destino a la pila de navegación. Si el usuario toca rápidamente la misma tarjeta varias veces, se pueden realizar varias llamadas a `navigate()` antes de que la interfaz termine de mostrar el detalle.

Como resultado, se pueden crear varias instancias de la misma pantalla de detalle dentro de la pila.

## 3 Ruta de captura de pantalla
