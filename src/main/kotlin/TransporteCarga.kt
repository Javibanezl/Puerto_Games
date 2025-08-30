abstract class TransporteCarga(
    val patente : String,
    val peso : Double,
    val capacidad : Double
){
    abstract fun descripcion(): String
    abstract fun precioEnvio(): Double

    fun validar(): Result<Unit> {
        return try{
            when{
                patente.isBlank() -> Result.failure(IllegalArgumentException("La patente no puede estar vacía."))
                peso <= 0 -> Result.failure(IllegalArgumentException("El peso debe ser mayor a 0."))
                capacidad <= 0 -> Result.failure(IllegalArgumentException("La capacidad debe ser mayor a 0."))
                peso > capacidad -> Result.failure(IllegalArgumentException("El peso no puede superar la capacidad."))
                else -> Result.success(Unit)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}