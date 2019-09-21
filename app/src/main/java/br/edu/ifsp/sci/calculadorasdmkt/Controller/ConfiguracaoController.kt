package br.edu.ifsp.sci.calculadorasdmkt.Controller

import br.edu.ifsp.sci.calculadorasdmkt.Model.Configuracao
import br.edu.ifsp.sci.calculadorasdmkt.Model.ConfiguracaoService
import br.edu.ifsp.sci.calculadorasdmkt.View.ConfiguracaoActivity

class ConfiguracaoController(var view: ConfiguracaoActivity) {
    //Model
    val model: ConfiguracaoService
    init{
        model = ConfiguracaoService(view.applicationContext)
    }

    fun salvaConfiguracao(configuracao: Configuracao){
        model.setConfiguracao(configuracao)
        view.atualizaView(configuracao)
    }

    fun buscaConfiguracao(){
        val configuracao = model.getConfiguracao()
        view.atualizaView(configuracao)
    }
}