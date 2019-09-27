package br.edu.ifsp.sci.calculadorasdmkt.Model

interface ConfiguracaoDao {
    // CRUD, exceto Delete no nosso exemplo
    fun createOrUpdateConfiguracao(configuracao: Configuracao)
    fun readConfiguracao(): Configuracao
}
