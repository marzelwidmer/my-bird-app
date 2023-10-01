package ch.keepcalm.app.birds.domain.entities

import ch.keepcalm.app.birds.infrastructure.repository.BirdImage

data class BirdsUiState(
    val images: List<BirdImage> = emptyList(),
    val selectedCategory : String? = null
){
    val categories: Set<String> = images.map { it.category }.toSet()
    val selectedImages =  images.filter { it.category == selectedCategory }
}
