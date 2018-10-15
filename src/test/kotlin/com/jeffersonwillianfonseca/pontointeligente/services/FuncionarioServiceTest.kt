package com.jeffersonwillianfonseca.pontointeligente.services

import com.jeffersonwillianfonseca.pontointeligente.documents.Funcionario
import com.jeffersonwillianfonseca.pontointeligente.enum.PerfilEnum
import com.jeffersonwillianfonseca.pontointeligente.repository.FuncionarioRepository
import com.jeffersonwillianfonseca.pontointeligente.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

  private val email: String = "joao@gmail.com"
  private val cpf: String = "34324132323"
  private val id: String = "1"

  @MockBean
  private val funcionarioRepository: FuncionarioRepository? = null

  @Autowired
  private val funcionarioService: FuncionarioService? = null

  @Before
  @Throws(Exception::class)
  fun setUp() {
    given(funcionarioRepository?.save(any(Funcionario::class.java)))
        .willReturn(funcionario())
    given(funcionarioRepository?.findByCpf(cpf))
        .willReturn(funcionario())
    given(funcionarioRepository?.findByEmail(email))
        .willReturn(funcionario())
    given(funcionarioRepository?.findOneById(id)).willReturn(funcionario())
  }

  @Test
  fun testePersistirFuncionario() {
    val funcionario: Funcionario? =
        funcionarioService?.persistir(funcionario())
    Assert.assertNotNull(funcionario)
  }

  @Test
  fun testeBuscarPorCpf() {
    val funcionario: Funcionario? =
        funcionarioService?.buscarPorCpf(cpf)
    Assert.assertNotNull(funcionario)
  }

  @Test
  fun testeBuscarPorId() {
    val funcionario: Funcionario? =
        funcionarioService?.buscarPorId(id)
    Assert.assertNotNull(funcionario)
  }

  @Test
  fun testeBuscarPorEmail() {
    val funcionario: Funcionario? =
        funcionarioService?.buscarPorEmail(email)
    Assert.assertNotNull(funcionario)
  }

  private fun funcionario(): Funcionario = Funcionario("Joao",
      email, SenhaUtils().gerarBcrypt("2423"),
      cpf, PerfilEnum.ROLE_USUARIO, id)
}