import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class GestionFichero() {

    fun crearDiccionario(rutaArchivo: Path, archivo: File) {
        //Lista que reune en cada posicion toodos los datos de cada empresa
        var listaEmpresas = mutableListOf<String>()
        Files.newBufferedReader(rutaArchivo).use { stream -> stream.forEachLine { listaEmpresas.add(it) } }

        var listaSpliteada = mutableListOf<List<String>>()
        listaEmpresas.forEach {linea -> listaSpliteada.add(linea.split(";"))}

        //Lista de listas
        var listaNombres = mutableMapOf<String, String>()
        var titulos = mutableListOf<String>()
        titulos.add(listaEmpresas.get(0))

        var empresas = mutableListOf<String>()
        

    }

    fun crearCsv(){
        TODO()
    }
}