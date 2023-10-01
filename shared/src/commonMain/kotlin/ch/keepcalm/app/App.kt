package ch.keepcalm.app

import androidx.compose.runtime.Composable
import ch.keepcalm.app.birds.di.getKoinInstance
import ch.keepcalm.app.birds.presentation.BirdsPage
import ch.keepcalm.app.birds.presentation.BirdsViewModel
import ch.keepcalm.app.birds.theme.BirdAppTheme

@Composable
fun App() {
    BirdAppTheme {
//        val birdsRepository = BirdsRepository()
//        val birdsViewModel = getViewModel(key = Unit, factory = viewModelFactory { BirdsViewModel(birdsRepository) })
//        BirdsPage(birdsViewModel)

        val birdsViewModel: BirdsViewModel = getKoinInstance()
        BirdsPage(birdsViewModel)
    }
}


expect fun getPlatformName(): String

