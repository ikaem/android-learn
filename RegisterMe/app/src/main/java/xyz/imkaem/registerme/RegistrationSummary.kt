package xyz.imkaem.registerme

data class RegistrationSummary(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val password: String?,
    val phoneNumber: String?,
    val title: String?,
): java.io.Serializable
