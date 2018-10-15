package com.jeffersonwillianfonseca.pontointeligente.services

import com.jeffersonwillianfonseca.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface LancamentoService {

  fun buscarPorFuncionaId(funcionarioId: String,
                          pageRequest: PageRequest): Page<Lancamento>

  fun buscarPorId(id: String): Lancamento?

  fun persistir(lancamento: Lancamento) : Lancamento

  fun remover(id: String)
}