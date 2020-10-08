

class Sala () {
    var numeroDeSala: Int = 0
    var poderMaligno: Int = 0
    var numeroEnemigos: Int = 0
    var numeroFlechas: Int = 0
    var tipoPeligro: peligro = peligro.accion



}

enum class peligro {
    magico,
    accion,
    maligno
}