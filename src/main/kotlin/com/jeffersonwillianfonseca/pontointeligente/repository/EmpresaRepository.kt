package com.jeffersonwillianfonseca.pontointeligente.repository

import com.jeffersonwillianfonseca.pontointeligente.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String> {

  fun findByCnpj(cnpj: String): Empresa
}