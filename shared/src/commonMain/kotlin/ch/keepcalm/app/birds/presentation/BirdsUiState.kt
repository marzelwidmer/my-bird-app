package ch.keepcalm.app.birds.presentation

import ch.keepcalm.app.birds.data.BirdImage

data class BirdsUiState(
    val images: List<BirdImage> = emptyList(),
    val selectedCategory : String? = null
){
    val categories: Set<String> = images.map { it.category }.toSet()
    val selectedImages =  images.filter { it.category == selectedCategory }
}
