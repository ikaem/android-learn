package xyz.imkaem.shameless

import java.io.Serializable

data class Message(
    val contactName: String,
    val number: String,
    val myName: String,
    val jobTitle: String,
    val startDate: String,
    val shouldIncludeJunior: Boolean,
    val canStartImmediately: Boolean,
): Serializable