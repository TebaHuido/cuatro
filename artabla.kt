package connectfour

fun artabla(fila:Int, columna:Int,arr:Array<IntArray>) {
    var i = 0
    var j = 0
    while (i<columna){
        print(" ${i+1}")
        i++
    }
    print("\n")
    while (j<fila){
        i=0
        while (i<=columna){
            print("║")
            if (i<columna) {
                if (arr[j][i] == 0) {
                    print(" ")
                } else if (arr[j][i] == 1) {
                    print("o")
                } else {
                    print("*")
                }
            }
            i++
        }
        print("\n")
        j++
    }
    print("╚")
    j=0
    while (j<columna-1){
        print("═╩")
        j++
    }
    print("═╝\n")
}