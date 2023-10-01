package ch.keepcalm.app.images.domain

import ch.keepcalm.app.images.infrastructure.repository.Image

interface ImageRepository {
    suspend fun getImages(): List<Image>
    fun close()
}
