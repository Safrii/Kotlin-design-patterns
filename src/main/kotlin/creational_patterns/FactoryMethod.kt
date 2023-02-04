package creational_patterns

fun main() {
    val vehicleFactory = VehicleFactory()

    val car: Vehicle? = vehicleFactory.createVehicle("car")
    car?.createVehicle()

    val boat: Vehicle? = vehicleFactory.createVehicle("boat")
    boat?.createVehicle()
}

interface Vehicle {
    fun createVehicle()
}

class Car : Vehicle {
    override fun createVehicle() {
        println("Inside Car::createVehicle() method")
    }
}

class Boat : Vehicle {
    override fun createVehicle() {
        println("Inside Boat::createVehicle() method")
    }
}

class VehicleFactory {
    fun createVehicle(vehicleType: String): Vehicle? {
        if (vehicleType.equals("Car", ignoreCase = true)) {
            return Car()
        } else if (vehicleType.equals("Boat", ignoreCase = true)) {
            return Boat()
        }
        return null
    }
}