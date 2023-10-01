package ch.keepcalm.app

import androidx.compose.runtime.Composable
import ch.keepcalm.app.images.infrastructure.di.getKoinInstance
import ch.keepcalm.app.images.domain.usecases.ImageViewModel
import ch.keepcalm.app.images.presentation.ImagePage
import ch.keepcalm.app.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val imageViewModel: ImageViewModel = getKoinInstance()
        ImagePage(imageViewModel)
    }
}


expect fun getPlatformName(): String

