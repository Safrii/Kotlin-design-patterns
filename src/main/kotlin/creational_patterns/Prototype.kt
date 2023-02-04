package creational_patterns

fun main() {

    val prototypeClone = ConcretePrototype()
    prototypeClone.printAttribute()

    val clone = prototypeClone.clone()
    clone.printAttribute()

}

interface Prototype {
    fun clone(): Prototype
}

class ConcretePrototype : Prototype {
    private var attribute: String? = "vehicle"
    fun printAttribute() {
        println(this.attribute)
    }
    override fun clone(): ConcretePrototype {
        val clone = ConcretePrototype()
        clone.attribute = this.attribute + " clone"
        return clone
    }

}