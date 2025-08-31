class Camioneta(
    patente: String,
    peso: Double,
    capacidad: Double
): TransporteCarga(patente, peso, capacidad){

    override fun descripcion(): String {
        return "Camioneta de patente $patente, carga actual de : $peso kg y capacidad máxima de: $capacidad kg"
    }

    override fun precioEnvio(): Double {
        return peso*1000
    }
}