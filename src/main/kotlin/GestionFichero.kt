import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class GestionFichero() {
    fun crearDiccionario(rutaArchivo: Path, archivo: File): MutableMap<String, MutableList<Any>> {
        val diccionario = mutableMapOf<String, MutableList<Any>>()

        Files.newBufferedReader(rutaArchivo).use { stream ->
            val lines = stream.readLines()

            // Leer la primera línea
            val headers = lines[0].split(";")

            // Inicializar las listas vacías para cada columna
            headers.forEach { header ->
                diccionario[header] = mutableListOf()
            }

            // Leer los valores a partir de la segunda línea
            for (line in lines.drop(1)) {
                val values = line.split(";")

                // Añadir los valores a las listas correspondientes
                for (i in values.indices) {
                    val value = values[i]

                    // Intentar convertir a número solo si es una columna numérica
                    val convertedValue: Any = value.toDoubleOrNull() ?: value  // Si no se puede convertir, dejar como String
                    diccionario[headers[i]]?.add(convertedValue)
                }
            }
        }
        return diccionario
    }

    fun crearCsv(diccionario: MutableMap<String, MutableList<Any>>, rutaSalida: String) {
        val file = File(rutaSalida)
        file.printWriter().use { out ->
            out.println("Columna,Mínimo,Máximo,Media")

            for ((columna, valores) in diccionario) {
                // Filtrar solo las columnas numéricas
                val valoresNumericos = valores.filterIsInstance<Double>()
                if (valoresNumericos.isNotEmpty()) {
                    val minimo = valoresNumericos.minOrNull() ?: 0.0
                    val maximo = valoresNumericos.maxOrNull() ?: 0.0
                    val media = if (valoresNumericos.isNotEmpty()) valoresNumericos.average() else 0.0

                    out.println("$columna,$minimo,$maximo,$media")
                }
            }
        }
    }


}