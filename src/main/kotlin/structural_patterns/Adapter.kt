package structural_patterns

interface Target {
    fun request()
}

class Adaptee {
    fun specificRequest() {
        println("Specific Request")
    }
}

class Adapter(private val adaptee: Adaptee) : Target {
    override fun request() {
        adaptee.specificRequest()
    }
}

fun main() {
    val adaptee = Adaptee()
    val target = Adapter(adaptee)
    target.request()
}
