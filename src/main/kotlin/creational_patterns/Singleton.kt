package creational_patterns

fun main() {
    val singletonObject = AdminAccount
    val whoIsThis = singletonObject.whoIsAdmin()
    println(whoIsThis)
}

object AdminAccount {
    private var name = "Admin name"
    private var username = "Admin"
    private var email = "admin@email.com"

    fun whoIsAdmin(): String {
        return """
            {
                this is admin data,
                name: $name,
                username: $username,
                email: $email
            }
        """.trimIndent()
    }
}