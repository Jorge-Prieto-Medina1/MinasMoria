//la clase personaje es la clase padre de la que heredan ñas clases Elfo, Mago y Hobbit
open class Personaje (val nombre: String, var estado: Boolean)

//La clase Mago representa el tipo de personaje mago cuenta con una variable que contiene la energñia total de la
//vara y dos metodos que la recargan y muestran la cantidad total de energía
class Mago (nombre: String, estado: Boolean, var energíatotal: Int) : Personaje (nombre, estado){
    fun recargarVara(energia: Int){
        energíatotal += energia
    }
    fun poderVara():Int{
       return energíatotal
    }
}
//La clase elfo cuenta con el carcaj el cual contiene el numero de flechas
//Y los métodos lanzar flecha que resta una flecha al carcaj y recargar flechas
//que añade flechas al carcaj dependiendo del parametro pasado
class Elfo (nombre: String, estado: Boolean, var carcaj: Int) : Personaje (nombre, estado){
    fun lanzarFlecha(){
        carcaj--
    }
    fun recargarCarcaj(flechas: Int){
        carcaj+=flechas

    }
}
//La clase Hobbit cuenta con el boolean anillo que cuando es true representa que el anillo está puesto
//y cuando es false qutado, cuenta con los metodos ponerse el anillo y quitarse el anillo
class Hobbit (nombre: String, estado: Boolean, var anillo: Boolean) : Personaje (nombre, estado){


    fun ponerseAnillo (){
        anillo = true
    }

    fun quitarseAnillo (){
        anillo = false
    }
}
