package ch.keepcalm.app

import androidx.compose.runtime.Composable
import ch.keepcalm.app.birds.repository.BirdsRepository
import ch.keepcalm.app.birds.theme.BirdAppTheme
import ch.keepcalm.app.birds.screens.BirdsViewModel
import ch.keepcalm.app.birds.screens.BirdsPage
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App() {
    BirdAppTheme {
        val birdsRepository = BirdsRepository()
        val birdsViewModel = getViewModel(key = Unit, factory = viewModelFactory { BirdsViewModel(birdsRepository) })
        BirdsPage(birdsViewModel)
    }
}


expect fun getPlatformName(): String

