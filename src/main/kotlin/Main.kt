import java.io.File
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val rutaFichero = Path.of("src").resolve("main").resolve("resources").resolve("cotizacion.csv")
    val fichero = File("src/main/resources/cotizacion.csv")
    crearDiccionario(rutaFichero, fichero)
}

fun crearDiccionario(rutaArchivo: Path, archivo: File) {
    Files.newBufferedWriter(rutaArchivo)
}

//fun crearCsv(diccionario: ){
//
//
//}