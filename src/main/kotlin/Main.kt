import java.io.File
import java.nio.file.Path


fun main() {
    val rutaFichero = Path.of("src").resolve("main").resolve("resources").resolve("cotizacion.csv")
    val fichero = File("src/main/resources/cotizacion.csv")

    val diccionario = GestionFichero().crearDiccionario(rutaFichero, fichero)

    GestionFichero().crearCsv(diccionario, "src/main/resources/salida.csv")
}
