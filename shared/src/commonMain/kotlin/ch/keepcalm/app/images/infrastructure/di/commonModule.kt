package ch.keepcalm.app.images.infrastructure.di

import ch.keepcalm.app.images.domain.ImageRepository
import ch.keepcalm.app.images.domain.usecases.ImageViewModel
import ch.keepcalm.app.images.infrastructure.repository.ImageRepositoryImpl
import org.koin.dsl.module

val commonModule = module {
    single<ImageRepository> { ImageRepositoryImpl() }
    single { ImageViewModel(get()) }
}
