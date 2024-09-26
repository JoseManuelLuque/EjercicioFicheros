import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class GestionFichero() {

    fun crearDiccionario(rutaArchivo: Path, archivo: File) {
        var Diccionario = mutableMapOf<String, String>()

        Files.newBufferedReader(rutaArchivo).use {
            stream -> stream.forEachLine {
                line -> println(line)
            }
        }

    }

    fun crearCsv(){
        TODO()
    }
}