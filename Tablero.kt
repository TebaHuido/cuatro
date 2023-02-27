package connectfour
import kotlin.system.exitProcess

class Tablero {

    private var checktab=false
    private var fila=0
    private var columna=0
    private lateinit var arr: Array<IntArray>
    private lateinit var jugador1:String
    private lateinit var jugador2:String
    private var turn=0
    private var gamemode = 0
    private var pts1=0
    private var pts2=0
    private var ngame=1
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
        //printTable()
    }
    fun play(x: String):Boolean{
        if(x=="end"){
            println("Game over!")
            exitProcess(420)
        }
        if (isNumber(x)){
            val selection=x.toInt()
            if (selection in 1..columna){
                var i=fila
                while ( i-1>0&&arr[i-1][selection-1]!=0){i--}
                if (arr[i-1][selection-1]==0){
                    arr[i-1][selection-1]=turn+1
                    searchfour(turn+1,i-1,selection-1)
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
                println("The column number is out of range (1 - $columna)")
            }
        }else{
            println("Incorrect column number")
        }
        return true
    }
    fun searchfour(objetivo:Int,fil:Int,col:Int){
        //revisar si hay 4 en columna
        var cont=0
        if (fil<fila-3) {
            for (i in 1..3) {
                if (arr[fil + i][col] == objetivo) {
                    cont++
                    if (cont == 3) {
                        winner(objetivo)
                    }
                }
                else{
                    break
                }

            }

        }
        //revisa si hay 4 en diagonal(/)
        cont=0
        for (i in -3..3){
            if (fil+i in 0..fila-1 && col-i in 0..columna-1){
                if (arr[fil+i][col-i]==objetivo){
                    cont++
                    if (cont==4){
                        winner(objetivo)
                    }
                }else{
                    cont=0
                }
            }
        }
        //revisa si hay 4 en diagonal(\)
        cont=0
        for (i in -3..3){
            if (fil-i in 0..fila-1 && col-i in 0..columna-1){
                if (arr[fil-i][col-i]==objetivo){
                    cont++
                    if (cont==4){
                        winner(objetivo)
                    }
                }else{
                    cont=0
                }
            }
        }
        //revisa si hay 4 en fila
        cont=0
        for (i in -3..3){
            if (col-i in 0..columna-1){
                if (arr[fil][col-i]==objetivo){
                    cont++
                    if (cont==4){
                        winner(objetivo)
                    }
                }else{
                    cont=0
                }
            }
        }
        //revisar empate
        cont=0
        for (i in 0..columna-1){
                if (arr[0][i]==0){
                    break
                }else{
                    cont++
                }
        }
        if (cont==columna){
            build()
            println("It is a draw")
            pts1++
            pts2++
            fingame()
        }

    }
    private fun winner(x:Int){
        build()
        if (x == 1) {
            println("Player $jugador1 won")
            pts1 += 2
        } else {
            println("Player $jugador2 won")
            pts2 += 2
        }
        fingame()
    }
    fun gamemode():Boolean{
        if (gamemode==0){
            return true
        }
        return false
    }
    fun gamemodeSetter(x:String){
        if (x ==""){
            gamemode=1
        }else if (isNumber(x)){
            if(x.toInt()>0) {
                gamemode = x.toInt()
            }else{
                println("Invalid input")
            }
        }else{
            println("Invalid input")
        }
    }
    fun gamemodeGetter():Int{
        return gamemode
    }
    fun fingame(){
        if (gamemode==ngame){
            if(gamemode!=1) {
                println("Score\n" +
                        "$jugador1: $pts1 $jugador2: $pts2")
            }
            println("Game over!")
            exitProcess(420)
        }else{
            ngame++
            println("Score\n" +
                    "$jugador1: $pts1 $jugador2: $pts2")
            println("Game #$ngame")
            arrSet()
        }
    }

}