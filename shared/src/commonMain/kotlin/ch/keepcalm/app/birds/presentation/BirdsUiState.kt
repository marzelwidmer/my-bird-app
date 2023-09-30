package ch.keepcalm.app.birds.presentation

import ch.keepcalm.app.birds.data.BirdImage

data class BirdsUiState(
    val images: List<BirdImage> = emptyList()
)
