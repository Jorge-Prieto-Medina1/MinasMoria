open class Personaje (val nombre: String, var estado: Boolean)

class Mago (nombre: String, estado: Boolean, var energíatotal: Int) : Personaje (nombre, estado){
    fun recargarVara(energia: Int){
        energíatotal += energia
    }
    fun poderVara():Int{
       return energíatotal
    }
}

class Elfo (nombre: String, estado: Boolean, var carcaj: Int) : Personaje (nombre, estado){
    fun lanzarFlecha(){
        carcaj--
    }
    fun recargarCarcaj(flechas: Int){
        carcaj+=flechas

    }
}

class Hobbit (nombre: String, estado: Boolean, var anillo: Boolean) : Personaje (nombre, estado){


    fun ponerseAnillo (){
        anillo = true
    }

    fun quitarseAnillo (){
        anillo = false
    }
}
