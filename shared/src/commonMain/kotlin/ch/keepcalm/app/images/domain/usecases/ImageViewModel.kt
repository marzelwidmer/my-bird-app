package ch.keepcalm.app.images.domain.usecases

import ch.keepcalm.app.images.domain.ImageRepository
import ch.keepcalm.app.images.domain.entities.ImageUiState
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class ImageViewModel(private val imageRepository: ImageRepository) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(ImageUiState())

    val uiState = _uiState.asStateFlow()

    init {
        updateImages()
    }

    fun selectCategory(category: String) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }

    override fun onCleared() {
        imageRepository.close()
    }

    private fun updateImages() {
        viewModelScope.launch {
            val images = imageRepository.getImages()
            _uiState.update { birdsUiState ->
                birdsUiState.copy(images = images)
            }
        }
    }
}
