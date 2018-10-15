package com.jeffersonwillianfonseca.pontointeligente.services.impl

import com.jeffersonwillianfonseca.pontointeligente.documents.Funcionario
import com.jeffersonwillianfonseca.pontointeligente.repository.FuncionarioRepository
import com.jeffersonwillianfonseca.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

  override fun persistir(funcionario: Funcionario): Funcionario =
      funcionarioRepository.save(funcionario)

  override fun buscarPorCpf(cpf: String): Funcionario? =
      funcionarioRepository.findByCpf(cpf)

  override fun buscarPorEmail(email: String): Funcionario? =
      funcionarioRepository.findByEmail(email)

  override fun buscarPorId(id: String): Funcionario? =
      funcionarioRepository.findOneById(id)

}