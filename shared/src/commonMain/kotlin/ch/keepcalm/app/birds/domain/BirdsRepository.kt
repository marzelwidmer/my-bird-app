package ch.keepcalm.app.birds.domain

import ch.keepcalm.app.birds.infrastructure.repository.BirdImage

interface BirdsRepository {
    suspend fun getImages(): List<BirdImage>
    fun close()
}
