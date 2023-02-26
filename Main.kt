package connectfour
fun main() {
    val tabla = Tablero()
    println("Connect Four")
    println("First player's name:")
    //tabla.jugador1Setter("teba")
    tabla.jugador1Setter(readln())
    println("Second player's name:")
    //tabla.jugador2Setter("paupizarrolopez")
    tabla.jugador2Setter(readln())
    while (tabla.checkTable().not()){
        println("Set the board dimensions (Rows x Columns)\n" +
                "Press Enter for default (6 x 7)")
        //tabla.dimSetter("5x7")
        tabla.dimSetter(readln())
    }
    println("${tabla.jugador1getter()} VS ${tabla.jugador2getter()}\n" +
            "${tabla.filGetter()} X ${tabla.colGetter()} board")
    while (true){
        tabla.build()
        tabla.whoplay()
        while (tabla.play(readln())){
            tabla.whoplay()
        }
    }

}