package connectfour

fun validartablero(tamanio:String): Triple<Boolean, Int, Int> {
    var rowa = 0
    var colb = 0
    if (tamanio==""){
        return Triple(true,6,7)
    }else{
        val i=tamanio.length
        var j = 0
        //busca row
        while ( j<i){
            if (tamanio[j] == ' '|| tamanio[j] == '\t'){
                j++
            }else if(tamanio[j].isDigit()){
                if (tamanio[j].digitToInt() in 5..9 && tamanio[j+1].isDigit().not()){
                    rowa=tamanio[j].digitToInt()
                    j++
                    break
                }else{
                    j++
                    while ( j<i){
                        if (tamanio[j].isDigit()) {
                            j++
                        }else{
                            if (tamanio[j] == ' '|| tamanio[j] == '\t'){
                                j++
                            }else if (tamanio[j].lowercaseChar()== 'x'){
                                break
                            }else{
                                println("Invalid input")
                                return Triple (false,0,0)
                            }
                        }
                    }
                    println("Board rows should be from 5 to 9")
                    return Triple (false,0,0)
                }
            }else {
                println("Invalid input")
                return Triple(false, 0, 0)
            }
        }
        //busca x
        while ( j<i){
            if (tamanio[j] == ' '|| tamanio[j] == '\t'){
                j++
            }else if (tamanio[j].lowercaseChar()== 'x'){
                j++
                break
            }else{
                println("Invalid input")
                return Triple (false,0,0)
            }
        }
        //busca colb
        while ( j<i){

            if (tamanio[j] == ' '|| tamanio[j] == '\t'){
                j++
            }else if(tamanio[j].isDigit()){
                if (tamanio[j].digitToInt() in 5..9) {
                    if (j+1<i){
                        if (tamanio[j+1].isDigit()){
                            println("Board columns should be from 5 to 9")
                            return Triple (false,0,0)
                        }
                    }
                    colb=tamanio[j].digitToInt()
                    j++
                    break
                }else{
                    println("Board columns should be from 5 to 9")
                    return Triple (false,0,0)
                }
            }else {
                println("Invalid input")
                return Triple(false, 0, 0)
            }
        }

        //revisa que no quede nada
        while (j<i){
            if (tamanio[j] == ' '|| tamanio[j] == '\t'){
                j++
            }else{
                println("Invalid input")
                return Triple (false,0,0)
            }
        }
        if (colb !=0) {
            return Triple(true, rowa, colb)
        }
        println("Invalid input")
        return Triple (false,0,0)

    }
}