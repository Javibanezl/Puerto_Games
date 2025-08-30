fun main(){

    println("=== Sistema de Registro de Transporte de Carga === \n")

    for (i in 1..2) {
        println("--- Registro de Vehículos --- \n")

        //Selección del tipo de transporte
        println("Seleccione el tipo de transporte: ")
        println("1. Camión")
        println("2. Camioneta")
        println("3. Drone")
        println("Opción: ")
        val opcion = readLine()?.toIntOrNull() ?: 0

        //Datos del transporte
        print("Ingrese la patente: ")
        val patente = readLine() ?: ""

        print("Ingrese el peso de la carga (kg): ")
        val peso = readLine()?.toDoubleOrNull() ?: 0.0

        print("Ingrese la capacidad máxima (kg): ")
        val capacidad = readLine()?.toDoubleOrNull() ?: 0.0

        //Transporte según opción
        val transporte : TransporteCarga? = when (opcion) {
            1 -> Camion(patente, peso, capacidad)
            2 -> Camioneta(patente, peso, capacidad)
            3 -> Drone(patente, peso, capacidad)
            else -> null
        }

        if (transporte == null) {
            println("Tipo de transporte inválido, no se registró.")
        } else {
            //validación antes del registro
            transporte.validar().onSuccess {
                println("Vehículo registrado correctamente")

                println("Costo de envío: ${transporte.precioEnvio()} CLP")
            } .onFailure {
                println("Error al registrar: ${it.message}")
            }
        }
    }

    println("=== Fin del registro de transportes ===")
}