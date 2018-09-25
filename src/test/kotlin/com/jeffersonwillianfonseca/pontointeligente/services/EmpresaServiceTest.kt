package com.jeffersonwillianfonseca.pontointeligente.services

import com.jeffersonwillianfonseca.pontointeligente.documents.Empresa
import com.jeffersonwillianfonseca.pontointeligente.repository.EmpresaRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class EmpresaServiceTest {

  private val CNPJ = "08080876908"

  @Autowired
  private val empresaService: EmpresaService? = null

  @MockBean
  private val empresaRepository: EmpresaRepository? = null

  @Before
  @Throws(Exception::class)
  fun setUp(){
    BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
    BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
  }

  @Test
  fun testePersistirEmpresa() {
    val empresa: Empresa? = empresaService?.persistir(empresa())
    Assert.assertNotNull(empresa)
  }

  @Test
  fun testeBuscarEmpresaPorCnpj(){
    val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ)
    Assert.assertNotNull(empresa)
  }

  fun empresa() : Empresa = Empresa("Razao Social",CNPJ, "1")
}