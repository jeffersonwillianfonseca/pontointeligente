package com.jeffersonwillianfonseca.pontointeligente.services.impl

import com.jeffersonwillianfonseca.pontointeligente.documents.Empresa
import com.jeffersonwillianfonseca.pontointeligente.repository.EmpresaRepository
import com.jeffersonwillianfonseca.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {
  override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)
  override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}