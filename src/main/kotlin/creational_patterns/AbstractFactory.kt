package creational_patterns

fun main() {

    val factory: WeaponFactory = Crossbow.Factory
    val crossbow = factory.buildWeapon()

    println(crossbow.use())
}

interface Weapon {

    fun use(): String
}

abstract class WeaponFactory {

    abstract fun buildWeapon(): Weapon
}

class Crossbow : Weapon {

    companion object Factory : WeaponFactory() {
        override fun buildWeapon(): Weapon {
            return Crossbow()
        }
    }

    override fun use(): String {
        return "Using crossbow weapon"
    }

}

class Katana : Weapon {

    companion object Factory : WeaponFactory() {
        override fun buildWeapon(): Weapon {
            return Katana()
        }
    }

    override fun use(): String {
        return "Using katana weapon"
    }
}