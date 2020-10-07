open class personaje (val nombre: String, var estado: Boolean)

class mago (nombre: String, estado: Boolean, var energíatotal: Int) : personaje (nombre, estado){
    fun recargarVara(energia: Int){
        energíatotal += energia
    }
    fun poderVara():Int{
       return energíatotal
    }
}

class elfo (nombre: String, estado: Boolean, var carcaj: Int) : personaje (nombre, estado){
    fun lanzarFlecha(){
        carcaj--
    }
    fun recargarCarcaj(flechas: Int){
        carcaj+=flechas

    }
}

class hobbit (nombre: String, estado: Boolean, var anillo: Boolean) : personaje (nombre, estado){
    fun ponerseAnillo (){
        anillo = true
    }

    fun quitarseAnillo (){
        anillo = false
    }
}
