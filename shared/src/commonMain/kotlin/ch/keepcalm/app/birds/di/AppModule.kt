package ch.keepcalm.app.birds.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun appModule() = listOf(commonModule)

/*
iOSApp.swift :
    init() {
        AppModuleKt.doInitKoin()
    }
MainActivity:
      initKoin()
*/
fun initKoin() = startKoin {
    modules(appModule())
}

inline fun <reified T> getKoinInstance() = object : KoinComponent {
    val value: T by inject()
}.value
