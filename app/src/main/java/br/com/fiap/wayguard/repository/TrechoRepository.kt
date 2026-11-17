package br.com.fiap.wayguard.repository

import br.com.fiap.wayguard.R
import br.com.fiap.wayguard.model.Categoria
import br.com.fiap.wayguard.model.Trecho

class TrechoRepository {

    private val trechos = listOf(
        Trecho(
            id = 1,
            nome = "Escadaria do Bixiga",
            bairro = "Bela Vista",
            descricao = "Escadaria longa, sem rampa ao lado.",
            distanciaMetros = 120,
            inclinacao = 35,
            avaliacoes = 24,
            imagem = R.drawable.img_escada,
            categorias = listOf(Categoria.ESCADAS),
            destaque = true
        ),
        Trecho(
            id = 2,
            nome = "Rua Augusta (subida)",
            bairro = "Consolação",
            descricao = "Subida forte entre a Paulista e a Rua Peixoto Gomide.",
            distanciaMetros = 450,
            inclinacao = 14,
            avaliacoes = 18,
            imagem = R.drawable.img_subida,
            categorias = listOf(Categoria.SUBIDAS, Categoria.SEMAFORO),
            destaque = true
        ),
        Trecho(
            id = 3,
            nome = "Av. Paulista",
            bairro = "Bela Vista",
            descricao = "Calçada larga e plana, com piso tátil.",
            distanciaMetros = 900,
            inclinacao = 2,
            avaliacoes = 41,
            imagem = R.drawable.img_rampa,
            categorias = listOf(Categoria.CADEIRANTE, Categoria.IDOSOS, Categoria.SEMAFORO),
            destaque = true
        ),
        Trecho(
            id = 4,
            nome = "Beco do Batman",
            bairro = "Vila Madalena",
            descricao = "Viela estreita com degraus no final.",
            distanciaMetros = 200,
            inclinacao = 10,
            avaliacoes = 9,
            imagem = R.drawable.img_calcada,
            categorias = listOf(Categoria.CALCADA_ESTREITA, Categoria.ESCADAS),
            destaque = false
        ),
        Trecho(
            id = 5,
            nome = "Rua Teodoro Sampaio",
            bairro = "Pinheiros",
            descricao = "Calçada estreita em alguns pontos, muito movimento.",
            distanciaMetros = 600,
            inclinacao = 6,
            avaliacoes = 12,
            imagem = R.drawable.img_calcada,
            categorias = listOf(Categoria.CALCADA_ESTREITA, Categoria.SEMAFORO),
            destaque = false
        ),
        Trecho(
            id = 6,
            nome = "Praça da Sé",
            bairro = "Sé",
            descricao = "Área plana com rampas nas travessias.",
            distanciaMetros = 300,
            inclinacao = 1,
            avaliacoes = 15,
            imagem = R.drawable.img_rampa,
            categorias = listOf(Categoria.CADEIRANTE, Categoria.IDOSOS),
            destaque = false
        ),
        Trecho(
            id = 7,
            nome = "Ladeira Porto Geral",
            bairro = "Centro",
            descricao = "Descida íngreme e calçada irregular.",
            distanciaMetros = 250,
            inclinacao = 18,
            avaliacoes = 7,
            imagem = R.drawable.img_subida,
            categorias = listOf(Categoria.SUBIDAS, Categoria.CALCADA_ESTREITA),
            destaque = false
        ),
        Trecho(
            id = 8,
            nome = "Cruzamento Rebouças x Faria Lima",
            bairro = "Pinheiros",
            descricao = "Semáforo para pedestres com tempo curto de travessia.",
            distanciaMetros = 80,
            inclinacao = 3,
            avaliacoes = 21,
            imagem = R.drawable.img_semaforo,
            categorias = listOf(Categoria.SEMAFORO),
            destaque = true
        )
    )

    fun getTrechos(): List<Trecho> {
        return trechos
    }

    fun getDestaques(): List<Trecho> {
        return trechos.filter { it.destaque }
    }

    fun getTrechosPorCategoria(categoria: Categoria): List<Trecho> {
        if (categoria == Categoria.TODAS) {
            return trechos
        }
        return trechos.filter { it.categorias.contains(categoria) }
    }

    fun getCategorias(): List<Categoria> {
        return Categoria.values().toList()
    }
}
