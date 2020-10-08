
// clase sala
class Sala () {
    //las variables se encuentran declaradas porque es necesario para la lista de Salas
    var numeroDeSala: Int = 0
    var poderMaligno: Int = 0
    var numeroEnemigos: Int = 0
    var numeroFlechas: Int = 0
    var tipoPeligro: peligro = peligro.accion



}
//clase enum que determina los tipos de salas
enum class peligro {
    magico,
    accion,
    maligno
}