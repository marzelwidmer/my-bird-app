package ch.keepcalm.app.birds.di

import org.koin.core.context.startKoin

/*
iOS: iOSApp.swift

import SwiftUI
import shared

@main
struct iOSApp: App {
	init() {
        AppModuleKt.doInitKoin()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}

Android: MainActivity:

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import ch.keepcalm.app.birds.di.initKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin()
        setContent {
            MainView()
        }
    }
}

*/
fun initKoin() = startKoin {
    modules(appModule())
}
