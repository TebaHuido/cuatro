package connectfour

fun artabla(x:Int, y:Int) {
    var i = 0
    var j = 0
    while (i<y){
        print(" ${i+1}")
        i++
    }
    print("\n")
    while (j<x){
        i=0
        while (i<=y){
            print("║ ")
            i++
        }
        print("\n")
        j++
    }
    print("╚")
    j=0
    while (j<y-1){
        print("═╩")
        j++
    }
    print("═╝")
}