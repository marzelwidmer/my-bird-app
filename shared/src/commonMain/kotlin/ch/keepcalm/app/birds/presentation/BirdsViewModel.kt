package ch.keepcalm.app.birds.presentation

import ch.keepcalm.app.birds.data.BirdImage
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class BirdsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<BirdsUiState>(BirdsUiState())

    val uiState = _uiState.asStateFlow()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    init {
        updateImages()
    }

    fun selectCategory(category: String) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }

    override fun onCleared() {
        httpClient.close()
    }

    private fun updateImages() {
        viewModelScope.launch {
            val images = getImages()
            _uiState.update { birdsUiState ->
                birdsUiState.copy(images = images)
            }
        }
    }

    private suspend fun getImages(): List<BirdImage> =
        httpClient.get("https://sebi.io/demo-image-api/pictures.json").body()
}
