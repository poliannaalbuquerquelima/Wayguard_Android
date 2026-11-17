package br.com.fiap.wayguard.model

data class Trecho(
    val id: Int,
    val nome: String,
    val bairro: String,
    val descricao: String,
    val distanciaMetros: Int,
    val inclinacao: Int,
    val avaliacoes: Int,
    val imagem: Int,
    val categorias: List<Categoria>,
    val destaque: Boolean
)
