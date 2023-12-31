package ch.keepcalm.app.images.presentation

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import ch.keepcalm.app.images.infrastructure.repository.Image
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ImageCell(image: Image) {
    KamelImage(
        resource = asyncPainterResource("https://sebi.io/demo-image-api/${image.path}"),
        contentDescription = "${image.category} be ${image.author}",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize().aspectRatio(1.0f)
    )
}
