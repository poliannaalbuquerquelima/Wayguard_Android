package br.com.fiap.wayguard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.wayguard.model.Categoria
import br.com.fiap.wayguard.ui.theme.Branco
import br.com.fiap.wayguard.ui.theme.Preto
import br.com.fiap.wayguard.ui.theme.Vermelho

@Composable
fun CategoriaChip(
    categoria: Categoria,
    selecionada: Boolean,
    onClick: () -> Unit
) {
    val corFundo = if (selecionada) Vermelho else Branco
    val corTexto = if (selecionada) Branco else Preto

    Card(
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(containerColor = corFundo),
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .clickable { onClick() }
    ) {
        Text(
            text = categoria.titulo,
            color = corTexto,
            fontWeight = if (selecionada) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
