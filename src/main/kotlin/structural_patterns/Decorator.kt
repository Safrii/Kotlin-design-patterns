package structural_patterns

import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.IOException
import java.util.*


fun main() {

}

interface DataSource {
    fun writeData(data: String)
    fun readData(): String
}

class FileDataSource(
    private val name: String
) : DataSource {
    override fun writeData(data: String) {
        val file = File(name)
        try {
            FileOutputStream(file).use { fos -> fos.write(data.encodeToByteArray(), 0, data.length) }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    override fun readData(): String {
        var buffer: CharArray? = null
        val file = File(name)
        try {
            FileReader(file).use { reader ->
                buffer = CharArray(file.length().toInt())
                buffer?.let { reader.read(it) }
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
        return buffer.toString()
    }
}

open class DataSourceDecorator(
    private val wrappee: DataSource
) : DataSource {
    override fun writeData(data: String) {
        wrappee.writeData(data)
    }

    override fun readData(): String {
        return wrappee.readData()
    }
}

class EncryptionDecorator(
    wrappee: DataSource
) : DataSourceDecorator(wrappee) {

    override fun writeData(data: String) {
        super.writeData(encode(data))
    }

    override fun readData(): String {
        return decode(super.readData())
    }

    private fun encode(data: String): String {
        val result = data.toByteArray()
        return Base64.getEncoder().encodeToString(result)
    }

    private fun decode(data: String): String {
        val result: ByteArray = Base64.getDecoder().decode(data)
        return result.toString()
    }
}