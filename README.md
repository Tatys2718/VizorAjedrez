# Visor de Partidas de Ajedrez

## Descripción

Este proyecto es un visor de partidas de ajedrez desarrollado en Java. Permite visualizar partidas de ajedrez moviendo las piezas según una notación específica, y cuenta con funcionalidades de navegación como **siguiente** y **anterior** para avanzar y retroceder en los movimientos. Además, permite realizar un **deshacer movimiento** en caso de errores, conservando el historial de movimientos.

## Características

- **Visualización de Partidas**: Permite ver las posiciones de las piezas en un tablero de 8x8.
- **Navegación de Movimientos**: Opciones de avance y retroceso en la partida.
- **Función de Deshacer**: Para volver al estado anterior de la partida.
- **Control de Turnos**: Identifica de quién es el turno en cada movimiento (rojo o negro).

## Instalación

1. Clona este repositorio:
   git clone https://github.com/usuario/visor-partidas-ajedrez.git
2. Abre este proyecto en tu IDE preferido, yo utilice IntelliJ IDEA
3. Compila y ejecuta el proyecto desde el IDE.

## Estructura del Proyecto
- ChessController: Controlador principal que gestiona el estado del tablero, los movimientos y las reglas de las piezas.
- ChessBoard: Interfaz visual del tablero de ajedrez, que se actualiza con cada movimiento.
- Piece: Clase abstracta que representa una pieza genérica. Clases derivadas específicas (Rey, Reina, Torre, etc.) heredan de ella y definen los movimientos permitidos.
- Movimiento y Almacenamiento de Estado: Cada cambio de posición de una pieza se guarda en una lista de movimientos para permitir el uso de la función "deshacer".

##Uso
- Botones de Navegación: Usa los botones "Siguiente" y "Anterior" para moverte por la partida.
- Deshacer Movimiento: En caso de error, puedes utilizar esta opción para revertir al estado anterior.

