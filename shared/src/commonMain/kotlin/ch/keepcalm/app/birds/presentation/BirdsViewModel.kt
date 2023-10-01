package ch.keepcalm.app.birds.presentation

import ch.keepcalm.app.birds.repository.BirdsRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class BirdsViewModel(private val birdsRepository: BirdsRepository) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(BirdsUiState())

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
        birdsRepository.close()
    }

    private fun updateImages() {
        viewModelScope.launch {
            val images = birdsRepository.getImages()
            _uiState.update { birdsUiState ->
                birdsUiState.copy(images = images)
            }
        }
    }
}
