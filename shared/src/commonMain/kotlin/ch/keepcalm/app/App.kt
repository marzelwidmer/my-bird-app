package ch.keepcalm.app

import androidx.compose.runtime.Composable
import ch.keepcalm.app.birds.infrastructure.di.getKoinInstance
import ch.keepcalm.app.birds.domain.usecases.BirdsViewModel
import ch.keepcalm.app.birds.presentation.BirdsPage
import ch.keepcalm.app.theme.BirdAppTheme

@Composable
fun App() {
    BirdAppTheme {
        val birdsViewModel: BirdsViewModel = getKoinInstance()
        BirdsPage(birdsViewModel)
    }
}


expect fun getPlatformName(): String

