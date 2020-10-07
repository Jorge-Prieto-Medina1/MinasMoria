import java.io.File
import java.lang.Exception
import kotlin.jvm.internal.MagicApiIntrinsics

// Creado por Jorge Prieto Medina
fun main(args: Array<String>) {
    val salas = Array(36) {Sala()}
    var flechas: Int = 0
    var energia: Int = 0
    var hobbit = Hobbit (nombre = "Frodo", estado = true, anillo = true)
    var elfo = Elfo (nombre = "Légolas", estado = true, carcaj = 0)
    var mago = Mago (nombre = "Gándalf", estado = true, energíatotal = 0)

    println("Bienvenido a Minas Moria")
    do {
        try {
            println("Añada la energía inicial de la Vara de Gandalf")
            println("recuerde no puede ser menor que 1 ni mayor que 30")
            energia = readLine()?.toInt() as Int
        }
        catch (e: Exception){
            println("No escriba ni letras ni signos")
        }
    }while (energia >= 30 || energia <= 1)
    mago.energíatotal = energia
    do {
        try {
            println("Añada la cantidad de flechas del carcaj de Légolas")
            println("recuerde el numero no puede ser menor que 1 ni mayor que 20")
            flechas = readLine()?.toInt() as Int
        }
        catch (e: Exception){
            println("No escriba ni letras ni signos")
        }
    }while (flechas >= 20 || energia <= 1)
    elfo.carcaj = flechas

    println("Comenzando simulación")
    



}