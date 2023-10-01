package ch.keepcalm.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ch.keepcalm.app.birds.presentation.BirdsViewModel
import ch.keepcalm.app.birds.screens.BirdsPage
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App() {
    MaterialTheme {
        val birdsViewModel = getViewModel(key = Unit, factory = viewModelFactory { BirdsViewModel() })
        BirdsPage(birdsViewModel)
    }
}



expect fun getPlatformName(): String

