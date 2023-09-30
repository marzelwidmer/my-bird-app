package ch.keepcalm.app.birds.data

import kotlinx.serialization.Serializable

@Serializable
data class BirdImage(
    val author: String,
    val category: String,
    val path: String
)

