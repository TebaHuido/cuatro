package connectfour
fun main() {
    println("Connect Four")
    println("First player's name:")
    val fname = readln()
    println("Second player's name:")
    val sname = readln()
    var seg = true
    var vali = Triple(false, 0,0)
    while (seg){
        println("Set the board dimensions (Rows x Columns)\n" +
                "Press Enter for default (6 x 7)")
        vali=validartablero( readln())
        seg=vali.first.not()
    }
    println("$fname VS $sname\n" +
            "${vali.second} X ${vali.third} board")
    artabla(vali.second,vali.third)
}