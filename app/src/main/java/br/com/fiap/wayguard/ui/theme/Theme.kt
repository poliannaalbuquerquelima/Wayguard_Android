package br.com.fiap.wayguard.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val CoresWayGuard = lightColorScheme(
    primary = Vermelho,
    onPrimary = Branco,
    secondary = Preto,
    onSecondary = Branco,
    background = CinzaClaro,
    onBackground = Preto,
    surface = Branco,
    onSurface = Preto
)

@Composable
fun WayGuardTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CoresWayGuard,
        typography = Typography,
        content = content
    )
}
