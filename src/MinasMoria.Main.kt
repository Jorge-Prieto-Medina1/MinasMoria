import java.io.File
import java.lang.Exception
import java.util.*
import java.time.LocalDateTime
//imports de clases de java necesarias

// Creado por Jorge Prieto Medina
fun main(args: Array<String>) {
    //declaración de las variables que serán usadas durante la ejecución del programa
    val archivo = File("moria.txt")
    //la constante archivo contiene el nombre del archivo en el que se escribe la información
    var numaleatorio = Random()
    //la variable numaleatorio (salía error al poner numAleatorio por eso hay variables con ambas palabras
    //escritas en minusculas) se encarga de generar los numeros aleatorios
    var enemigos: Int = 0
    var probabilidad: Int = 0
    var salas = Array(36) {Sala()}
    //la variable salas es una lista de arrays de objetos de la clase sala
    var numSalas: Int = 0
    var flechas: Int = 0
    var energia: Int = 0
    //las variables flechas, energía son las que reciben un valor cuando
    //el numero de flechas o energía cambia
    var salaSuperada: Boolean = false
    // Boolean que se usa para comprobar si la sala ha sido superada
    // solo se usa en la sala mágica y en la maligna pues son las unicas
    // cuyo indice de victoria se calcula con numeros random
    var numpeligro: Int = 0
    //declaración de los personajes
    var hobbit = Hobbit (nombre = "Frodo", estado = true, anillo = false)
    var elfo = Elfo (nombre = "Légolas", estado = true, carcaj = 0)
    var mago = Mago (nombre = "Gándalf", estado = true, energíatotal = 0)

    //comprobación de la existencia del archivo de texto
    //si no existe se crea
    if (!archivo.exists()){
        archivo.createNewFile()
    }

    println("Bienvenido a Minas Moria")
    //metodos para rellenar la vara y el carcaj con try catch para no producirse errores
    do {
        try {
            println("Añada la energía inicial de la Vara de Gandalf")
            println("recuerde no puede ser menor que 1 ni mayor que 30")
            energia = readLine()?.toInt() as Int
        }
        catch (e: Exception){
            println("No escriba ni letras ni signos")
        }
    }while (energia > 30 || energia < 1)
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
    }while (flechas > 20 || flechas < 1)
    elfo.carcaj = flechas




    //inicio de la simulación
    println("Comenzando simulación")
    //la constante fechainicial guarda la fecha en la que se inicia la simulación
    val fechainicial = LocalDateTime.now()
    do{
        print("Bienvenido a la sala numero: ")
        println(numSalas+1)

        do {
            //codigo con el que se pregunta al jugador el poder maligno de la sala
            try {
                println("Elige el numero del poder maligno de la sala")
                println("Del numero 1 al 3 el peligro será de acción")
                println("Del numero 4 al 7 el peligro será mágico")
                println("Del numero 8 al 10 el peligro será maligno")
                numpeligro = readLine()?.toInt() as Int
            }
            catch (e: Exception){
                println("No escriba ni letras ni signos")
            }
        }while (numpeligro > 10 || numpeligro < 1)
        salas[numSalas].poderMaligno=numpeligro
        //sala de acción
        if(salas[numSalas].poderMaligno <= 3){
            salas[numSalas].tipoPeligro=peligro.accion
            println("Esta sala es de acción")

            do {
                try {
                    println("Parece que en esta sala hubo un enfrentamiento anterior y hay algunas flechas")
                    println("recuerde el numero no puede ser menor que 1 ni mayor que 10")
                    flechas = readLine()?.toInt() as Int
                }
                catch (e: Exception){
                    println("No escriba ni letras ni signos")
                }
            }while (flechas > 10 || flechas < 1)
            elfo.recargarCarcaj(flechas)
            flechas = 0

            println("Esta sala está plagada de enemigos")
            do {
                try {
                    println("Añada la cantidad de enemigos de la sala")
                    println("recuerde el numero no puede ser menor que 1 ni mayor que 10")
                    enemigos = readLine()?.toInt() as Int
                }
                catch (e: Exception){
                    println("No escriba ni letras ni signos")
                }
            }while (enemigos > 10 || enemigos < 1)
            salas[numSalas].numeroEnemigos = enemigos
            do{
                elfo.lanzarFlecha();
                salas[numSalas].numeroEnemigos--
            }while(elfo.carcaj > 0 && salas[numSalas].numeroEnemigos > 0)
            if(salas[numSalas].numeroEnemigos == 0){
                println("Légolas derrotó a sus enemigos")
            } else{
                println("Légolas se ha quedado sin flechas")
                println("Intentando retirada")
                probabilidad = numaleatorio.nextInt(100)+1
                if (probabilidad <= 80){
                    println("Retirada conseguida")

                }else{
                    println("Retirada fallida Légolas ha muerto Mision Fallida")
                    elfo.estado = false
                }

            }

            numSalas++;


        //sala de mágica
        } else if (salas[numSalas].poderMaligno >= 4 && salas[numSalas].poderMaligno <= 7){
            salas[numSalas].tipoPeligro=peligro.magico
            println("Esta sala es de Mágica")
            energia = numaleatorio.nextInt(10)+1
            print("Ha Gándalf le ha venido la inspiración y ha recargado la vara en: ")
            print(energia)
            println(" puntos")
            mago.recargarVara(energia)
            println("Esta sala está plagada de enemigos")
            do {
                try {
                    println("Añada la cantidad de enemigos de la sala")
                    println("recuerde el numero no puede ser menor que 1 ni mayor que 10")
                    enemigos = readLine()?.toInt() as Int
                }
                catch (e: Exception){
                    println("No escriba ni letras ni signos")
                }
            }while (enemigos > 10 || enemigos < 1)
            salas[numSalas].numeroEnemigos = enemigos
            do {
                try {
                    println("Elige la cantidad de puntos con lo que deseas cargar la vara")
                    println("recuerde el numero no puede ser menor que 1 ni mayor que 10")
                    print ("uste tiene una carga total de: ")
                    println(mago.poderVara())
                    energia = readLine()?.toInt() as Int
                }
                catch (e: Exception){
                    println("No escriba ni letras ni signos")
                }
            }while (energia > 10 || energia < 1)
            mago.recargarVara(-energia)
            salas[numSalas].numeroEnemigos = enemigos
            if (salas[numSalas].numeroEnemigos < energia){
                println("El poder de la vara de Gandalf era superior al numero de enemigos")
                println("Victoria asegurada")
                salaSuperada = true
            }else if (salas[numSalas].numeroEnemigos == energia) {
                probabilidad = numaleatorio.nextInt(100)+1
                if (probabilidad <= 60){
                    println("El  poder de la vara de Gándalf era igual al numero de enemigos")
                    println("Pero gracias a la indudable superioridad del mago Gris fueron derrotados")
                    salaSuperada=true

                }else{
                    println("Gandalf ha fracasado tenemos que retirarnos")
                    salaSuperada=false
                }

            } else{
                probabilidad = numaleatorio.nextInt(100)+1
                if (probabilidad <= 30){
                    println("El  poder de la vara de Gandalf era inferior al numero de enemigos")
                    println("Pero una vez Gándalf ha demostrado ser superior")
                    salaSuperada=true

                }else{
                    println("Gandalf ha fracasado tenemos que retirarnos")
                    salaSuperada=false
                }

            }
            if(!salaSuperada){
                println("Intentando retirada")
                probabilidad = numaleatorio.nextInt(100)+1
                if (probabilidad <= 80){
                    println("Retirada conseguida")

                }else{
                    println("Retirada fallida Gandalf ha caido intentando protegernos Mision Fallida")
                    mago.estado = false
                }
            }

            numSalas++;
        }



        //sala maligna
        else{
            salas[numSalas].tipoPeligro=peligro.maligno

            println("Esta sala es maligna")
            probabilidad = numaleatorio.nextInt(100)+1
            if (probabilidad >= 50){
                println("Frodo se ha puesto el anillo")
                hobbit.ponerseAnillo()

            }else{
                println("Frodo no se puso el anillo")
            }

            if(hobbit.anillo){
                probabilidad = numaleatorio.nextInt(100)+1
                if(probabilidad <= 90){
                    println("Peligro superado")
                    salaSuperada=true;
                } else{
                    println("Peligro no superado")
                    salaSuperada=false;
                }
            }else{
                probabilidad = numaleatorio.nextInt(100)+1
                if(probabilidad <= 30){
                    println("Peligro superado")
                    salaSuperada=true;
                } else{
                    println("Peligro no superado")
                    salaSuperada=false
                }

            }

            if(!salaSuperada){
                println("Intentando retirada")
                probabilidad = numaleatorio.nextInt(100)+1
                if (probabilidad <= 80){
                    println("Retirada conseguida")

                }else{
                    println("Retirada fallida Frodo ha muerto Mision Fallida")
                    hobbit.estado = false
                }
            }
            hobbit.quitarseAnillo()
            numSalas++

        }

    //comprobador que asegura que todos los personajes estan vivios y que no se han recorrido las 36 salas
    }while(hobbit.estado && elfo.estado && mago.estado && numSalas < 36)

    //constante que recoge la fecha final
    val fechafinal = LocalDateTime.now()

    //final ganador
    if(hobbit.estado && elfo.estado && mago.estado){
        print("Felicidades ha conseguido superar las minas de Moria ha ganado superando un total de ")
        print(numSalas)
        println(" salas")
        //escritura en el archivo
        archivo.printWriter().use { out ->
            out.println("Ronda de minas moria ganada")
            out.println("Salas superadas: "+numSalas)
            out.println("Fecha de inicio: "+fechainicial)
            out.println("Fecha de finalización: "+fechafinal)


        }
        archivo.printWriter().close()
        //ciere del escritor
    }
    //final malo
    else{
        print("Ha fracasado en intentar superar las minas de Moria aunque ha superado un total de ")
        print(numSalas)
        print ( " y ha fracasado ")
        println( 36 - numSalas)
        //escritura en el archivo
        archivo.printWriter().use { out ->
            out.println("Ronda de minas moria perdida")
            out.println("Salas superadas: "+numSalas)
            out.println("Fecha de inicio: "+fechainicial)
            out.println("Fecha de finalización: "+fechafinal)

        }
        archivo.printWriter().close()
        //ciere del escritor
    }







}