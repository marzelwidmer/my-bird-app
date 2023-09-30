package ch.keepcalm.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ch.keepcalm.app.birds.data.BirdImage
import ch.keepcalm.app.birds.presentation.BirdsViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun App() {
    MaterialTheme {
        val birdsViewModel = getViewModel(key = Unit, factory = viewModelFactory { BirdsViewModel() })
        BirdsPage(birdsViewModel)
    }
}


@Composable
fun BirdsPage(viewModel: BirdsViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    AnimatedVisibility(visible = uiState.images.isNotEmpty()) {
        LazyVerticalGrid(
            columns =  GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
            content = {
                items(uiState.images){birdImage : BirdImage ->
                    BirdImageCell(birdImage)
                }
            }
        )
    }

}

@Composable
fun BirdImageCell(image: BirdImage) {
    KamelImage(
       resource =  asyncPainterResource("https://sebi.io/demo-image-api/${image.path}"),
        contentDescription = "${image.category} be ${image.author}",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize().aspectRatio(1.0f)
    )
}

expect fun getPlatformName(): String

