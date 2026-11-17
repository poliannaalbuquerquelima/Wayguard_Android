package br.com.fiap.wayguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.fiap.wayguard.screens.HomeScreen
import br.com.fiap.wayguard.ui.theme.WayGuardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WayGuardTheme {
                HomeScreen()
            }
        }
    }
}
