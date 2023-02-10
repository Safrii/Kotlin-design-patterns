package structural_patterns

import java.io.File

fun main() {
    val converter: VideoConversionFacade = VideoConversionFacade()
    converter.convertVideo("youtube.ogg","mp4")


}

class VideoFile(
    val name: String? = null,
    val codecType: String = name!!.substring(name.indexOf(".") + 1)
)

interface Codec {

}

class MPEG4compressCodec : Codec {

    val type: String = "mp4"
}

class OggCompressionCodec : Codec {
    val type: String = "ogg"
}

class CodecFactory {
    companion object {
        fun extract(file: VideoFile): Codec {
            val type = file.codecType
            if (type.equals("mp4")) {
                println("Codec factory: extracting mpeg audio")
                return MPEG4compressCodec()
            } else {
                println("Codec factory: extraction ogg audio")
                return OggCompressionCodec()
            }
        }
    }
}

class BitrateReader {
    companion object {
        fun read(file: VideoFile, codec: Codec): VideoFile {
            println("BitrateReader: reading file...")
            return file
        }

        fun convert(buffer: VideoFile, codec: Codec): VideoFile {
            println("BitrateReader: writing file...")
            return buffer
        }
    }
}

class AudioMixer {
    fun fix(result: VideoFile): File {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}

class VideoConversionFacade {
    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName)
        val sourceCodec = CodecFactory.extract(file)
        val destinationCodec: Codec
        if (format.equals("mp4")) {
            destinationCodec = MPEG4compressCodec()
        } else {
            destinationCodec = OggCompressionCodec()
        }
        val buffer = BitrateReader.read(file, sourceCodec)
        val intermediateResult = BitrateReader.convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)
        println("VideoConversionFacade: conversion completed")

        return result
    }
}