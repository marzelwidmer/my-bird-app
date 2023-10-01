package ch.keepcalm.app

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
