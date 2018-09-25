package com.jeffersonwillianfonseca.pontointeligente.utils

import org.junit.Assert
import org.junit.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtilsTest {

  private val SENHA = "123456"
  private val BCryptEncoder = BCryptPasswordEncoder()

  @Test
  fun gerarBcrypt_GerarHashSenha() {
    val hash = SenhaUtils().gerarBcrypt(SENHA)
    Assert.assertTrue(BCryptEncoder.matches(SENHA, hash))
  }
}