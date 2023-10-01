package ch.keepcalm.app.birds.infrastructure.di

import ch.keepcalm.app.birds.domain.BirdsRepository
import ch.keepcalm.app.birds.domain.usecases.BirdsViewModel
import ch.keepcalm.app.birds.infrastructure.repository.BirdsRepositoryImpl
import org.koin.dsl.module

val commonModule = module {
    single<BirdsRepository> { BirdsRepositoryImpl() }
    single { BirdsViewModel(get()) }
}
