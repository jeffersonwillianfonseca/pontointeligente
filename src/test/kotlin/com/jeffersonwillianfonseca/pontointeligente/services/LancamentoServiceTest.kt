package com.jeffersonwillianfonseca.pontointeligente.services

import com.jeffersonwillianfonseca.pontointeligente.documents.Lancamento
import com.jeffersonwillianfonseca.pontointeligente.enum.TipoEnum
import com.jeffersonwillianfonseca.pontointeligente.repository.LancamentoRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class LancamentoServiceTest {

  @MockBean
  private val lancamentoRepository: LancamentoRepository? = null

  @Autowired
  private val lancamentoService: LancamentoService? = null

  private val id: String = "1"

  @Before
  @Throws(Exception::class)
  fun setUp() {
    BDDMockito.given(lancamentoRepository?.findByFuncionarioId(id, PageRequest.of(0, 10)))
        .willReturn(PageImpl(ArrayList<Lancamento>()))
    BDDMockito.given(lancamentoRepository?.findOne("1"))
        .willReturn(lancamento())
    BDDMockito.given(lancamentoRepository?.save(any(Lancamento::class.java)))
        .willReturn(lancamento())
  }

  @Test
  fun testBuscarLancamentPorFuncionarioId() {
    val lancamento: Page<Lancamento>? = lancamentoService?.buscarPorFuncionaId(id,
        PageRequest(0, 10))
    Assert.assertNotNull(lancamento)
  }

  private fun lancamento(): Lancamento =
      Lancamento(
          data = Date(),
          tipo = TipoEnum.INICIO_TRABALHO,
          funcionarioId = id,
          id = id
      )
}