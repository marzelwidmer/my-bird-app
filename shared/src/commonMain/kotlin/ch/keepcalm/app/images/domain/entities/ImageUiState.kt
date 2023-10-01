package ch.keepcalm.app.images.domain.entities

import ch.keepcalm.app.images.infrastructure.repository.Image

data class ImageUiState(
    val images: List<Image> = emptyList(),
    val selectedCategory : String? = null
){
    val categories: Set<String> = images.map { it.category }.toSet()
    val selectedImages =  images.filter { it.category == selectedCategory }
}
