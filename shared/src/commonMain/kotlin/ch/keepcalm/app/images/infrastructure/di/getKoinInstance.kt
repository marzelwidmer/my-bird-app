package ch.keepcalm.app.images.infrastructure.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/*
val imageViewModel: ImageViewModel = getKoinInstance()
 */
inline fun <reified T> getKoinInstance() = object : KoinComponent {
    val value: T by inject()
}.value
