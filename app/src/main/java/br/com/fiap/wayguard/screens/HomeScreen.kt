package br.com.fiap.wayguard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.wayguard.components.CategoriaChip
import br.com.fiap.wayguard.components.DestaqueCard
import br.com.fiap.wayguard.components.TituloSecao
import br.com.fiap.wayguard.components.TrechoCard
import br.com.fiap.wayguard.model.Categoria
import br.com.fiap.wayguard.repository.TrechoRepository
import br.com.fiap.wayguard.ui.theme.Branco
import br.com.fiap.wayguard.ui.theme.CinzaClaro
import br.com.fiap.wayguard.ui.theme.CinzaTexto
import br.com.fiap.wayguard.ui.theme.Preto
import br.com.fiap.wayguard.ui.theme.Vermelho
import br.com.fiap.wayguard.ui.theme.WayGuardTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val repository = remember { TrechoRepository() }
    var categoriaSelecionada by remember { mutableStateOf(Categoria.TODAS) }

    val destaques = repository.getDestaques()
    val trechosFiltrados = repository.getTrechosPorCategoria(categoriaSelecionada)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = null,
                            tint = Vermelho
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "wayguard", fontWeight = FontWeight.Bold)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Preto,
                    titleContentColor = Branco
                )
            )
        },
        containerColor = CinzaClaro
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
                    Text(
                        text = "Saiba o que esperar do caminho",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Veja os obstáculos antes de começar a caminhar.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = CinzaTexto
                    )
                }
            }

            item { TituloSecao(texto = "Destaques da comunidade") }

            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(destaques) { trecho ->
                        DestaqueCard(trecho = trecho)
                    }
                }
            }

            item { TituloSecao(texto = "Filtrar por categoria") }

            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(repository.getCategorias()) { categoria ->
                        CategoriaChip(
                            categoria = categoria,
                            selecionada = categoria == categoriaSelecionada,
                            onClick = { categoriaSelecionada = categoria }
                        )
                    }
                }
            }

            item { TituloSecao(texto = "Trechos (${trechosFiltrados.size})") }

            items(trechosFiltrados) { trecho ->
                TrechoCard(
                    trecho = trecho,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WayGuardTheme {
        HomeScreen()
    }
}
