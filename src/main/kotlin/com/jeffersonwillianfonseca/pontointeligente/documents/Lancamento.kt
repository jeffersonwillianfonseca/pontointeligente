package com.jeffersonwillianfonseca.pontointeligente.documents

import com.jeffersonwillianfonseca.pontointeligente.enum.TipoEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Lancamento(
    val data: Date,
    val tipo: TipoEnum,
    val funcionarioId: String? = null,
    val descricao: String? = "",
    val localizacao: String? = "",
    @Id val id: String
)