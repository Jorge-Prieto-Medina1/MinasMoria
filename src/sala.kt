
class sala (val numeroDeSala: Int, val poderMaligno: Int, val numeroEnemigos: Int, val numeroFlechas: Int, val tipoPeligro: peligro ) {
}

enum class peligro {
    magico,
    accion,
    maligno
}