package behavioral_patterns

fun main() {
    val newsletter = Newsletter()
    val reader = Reader(newsletter)
    reader.update()
}

interface Observer {
    fun update()
}

interface Observable {
    val observers: ArrayList<Observer>

    fun add(observer: Observer) {
        observers.add(observer)
    }

    fun remove(observer: Observer) {
        observers.remove(observer)
    }

    fun sendUpdateEvent() {
        observers.forEach { it.update() }
    }
}

class Newsletter : Observable {
    override val observers: ArrayList<Observer> = ArrayList()
    var newestArticleUrl = ""
        set(value) {
            field = value
            sendUpdateEvent()
        }
}

class Reader(private val newsletter: Newsletter) : Observer {
    override fun update() {
        println("New Article: ${newsletter.newestArticleUrl}")
    }
}