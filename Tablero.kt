package connectfour

class Tablero {

    private var checktab=false
    private var fila=0
    private var columna=0
    private lateinit var arr: Array<IntArray>
    private lateinit var jugador1:String
    private lateinit var jugador2:String
    private var turn=0
    fun jugador1Setter(x:String){jugador1=x}
    fun jugador1getter():String{return jugador1}
    fun jugador2Setter(x:String){jugador2=x}
    fun jugador2getter():String{return jugador2}
    fun filGetter():Int{return fila}
    fun colGetter():Int{return columna}
    private fun arrSet(){arr = Array(fila) { IntArray(columna) }}
    fun dimSetter(x:String){
        val (a,b,c) = validartablero(x)
        if (a) {
            checktab = true
            fila = b
            columna = c
            arrSet()
        }
    }
    fun checkTable():Boolean{return checktab}
    private fun printTable(){
        for (row in arr) {
            println(row.contentToString())
        }
    }
    fun whoplay(){
        if (turn==0){
            println("$jugador1's turn:")
        }else{
            println("$jugador2's turn:")
        }
    }
    fun build(){
        //arr[3][0]=1
        //arr[0][2]=2
        artabla(fila,columna,arr)
        printTable()
    }
    fun play(x: String):Boolean{
        if (isNumber(x)){
            val selection=x.toInt()
            if (selection in 1..columna){
                var i=fila
                while ( i-1>0&&arr[i-1][selection-1]!=0){i--}
                if (arr[i-1][selection-1]==0){
                    arr[i-1][selection-1]=turn+1
                    if (turn==0){
                        turn++
                    }else{
                        turn--
                    }
                    return false
                }else{
                    println("Column $selection is full")
                }
            }else{
                println("The column number is out of range (1 - 8)")
            }
        }else{
            println("Incorrect column number")
        }
        return true
    }
}