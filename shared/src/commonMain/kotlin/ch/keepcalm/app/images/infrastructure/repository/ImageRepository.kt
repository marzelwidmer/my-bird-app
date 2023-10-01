package ch.keepcalm.app.images.infrastructure.repository

import ch.keepcalm.app.images.domain.ImageRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class ImageRepositoryImpl : ImageRepository {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    override suspend fun getImages(): List<Image> =
        httpClient.get("https://sebi.io/demo-image-api/pictures.json").body()

    override fun close() {
        httpClient.close()
    }
}
