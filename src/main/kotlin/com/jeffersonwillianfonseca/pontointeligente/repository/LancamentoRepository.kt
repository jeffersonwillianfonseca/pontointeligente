package com.jeffersonwillianfonseca.pontointeligente.repository

import com.jeffersonwillianfonseca.pontointeligente.documents.Funcionario
import com.jeffersonwillianfonseca.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.repository.MongoRepository
import java.awt.print.Pageable

interface LancamentoRepository : MongoRepository<Lancamento, String> {
  fun findByFuncionarioId(idFun: String, pageRequest: PageRequest): Page<Lancamento>

  fun findOne(idFun: String): Lancamento
}