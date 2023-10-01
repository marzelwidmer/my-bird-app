package ch.keepcalm.app.birds.di

import ch.keepcalm.app.birds.repository.BirdsRepository
import ch.keepcalm.app.birds.presentation.BirdsViewModel
import org.koin.dsl.module

val commonModule = module {
    single { BirdsRepository() }
    single {
        BirdsViewModel(get())
    }
}
