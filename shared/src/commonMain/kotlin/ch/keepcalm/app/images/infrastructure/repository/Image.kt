package ch.keepcalm.app.images.infrastructure.repository

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val author: String,
    val category: String,
    val path: String
)

