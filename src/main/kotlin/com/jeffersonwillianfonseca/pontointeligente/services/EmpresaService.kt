package com.jeffersonwillianfonseca.pontointeligente.services

import com.jeffersonwillianfonseca.pontointeligente.documents.Empresa

interface EmpresaService {

  fun buscarPorCnpj(cnpj: String): Empresa?

  fun persistir(empresa: Empresa): Empresa
}