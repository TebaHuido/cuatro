package connectfour

fun main(){
    var tabla = Tablero()
    println("Connect Four")
    println("First player's name:")
    tabla.jugador1Setter(readln())
    println("Second player's name:")
    tabla.jugador2Setter(readln())
    while (tabla.legalGetter().not()){
        println("Set the board dimensions (Rows x Columns)\n" +
                "Press Enter for default (6 x 7)")
        tabla.dimensionSetter(validartablero( readln()))
    }

    println("${tabla.jugador1Getter()} VS ${tabla.jugador2Getter()}\n" +
            "${tabla.filaGetter()} X ${tabla.columnaGetter()} board")
    tabla.primerarmar()
    while (true) {
        tabla.armar()
        //tabla.printabla()
        tabla.quienjuega()
        while (tabla.jugada(readln())){
            tabla.quienjuega()
        }
    }
}