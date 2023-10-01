package ch.keepcalm.app.birds.infrastructure.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/*
val birdsViewModel: BirdsViewModel = getKoinInstance()
 */
inline fun <reified T> getKoinInstance() = object : KoinComponent {
    val value: T by inject()
}.value
