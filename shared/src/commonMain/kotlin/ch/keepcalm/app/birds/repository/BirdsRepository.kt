package ch.keepcalm.app.birds.repository

import ch.keepcalm.app.birds.data.BirdImage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class BirdsRepository {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getImages(): List<BirdImage> =
        httpClient.get("https://sebi.io/demo-image-api/pictures.json").body()

    fun close() {
        httpClient.close()
    }
}
