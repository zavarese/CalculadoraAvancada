package br.edu.ifsp.sci.calculadorasdmkt.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.sci.calculadorasdmkt.Controller.ConfiguracaoController
import br.edu.ifsp.sci.calculadorasdmkt.Model.Configuracao
import br.edu.ifsp.sci.calculadorasdmkt.Model.Separador
import kotlinx.android.synthetic.main.toolbar.*

import br.edu.ifsp.sci.calculadorasdmkt.R
import kotlinx.android.synthetic.main.activity_configuracao.*

class ConfiguracaoActivity: AppCompatActivity()  {
    object Constantes{
        //chave de retorno  para a MainActivity

        val CONFIGURACAO ="CONFIGURACAO"

    }

    //Referencia para Controller

    lateinit var configuracaoController: ConfiguracaoController

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)

        toolbar.title = "configuracao"
        setSupportActionBar(toolbar)

        //chama o controller e atualizar view
        configuracaoController = ConfiguracaoController(this)
        configuracaoController.buscaConfiguracao()
    }

    //funcao chamada pelo controller depois de acessar o model
    fun atualizaView(configuracao: Configuracao){
        //ajusta o leiaute conforme a configuracao
        leiauteSpn.setSelection(if(configuracao.leiauteAvancado) 1 else 0)
        separadorRg.check(
            if(configuracao.separador == Separador.PONTO)
                R.id.pontoRb
            else
                R.id.virgulaRb
        )

        setResult(AppCompatActivity.RESULT_OK, Intent().putExtra(Constantes.CONFIGURACAO,configuracao))
    }

    fun onClickSalvaConfiguracao(v: View) {
        //Pega dados da tela
        val leiauteAvancado = leiauteSpn.selectedItemPosition == 1
        val separador = if (pontoRb.isChecked) Separador.PONTO else Separador.VIRGULA

        //Criar um objeto Configuracao
        val novaConfiguracao: Configuracao = Configuracao(leiauteAvancado, separador)


        //Chamar o Controller para salvar
        configuracaoController.salvaConfiguracao(novaConfiguracao)

        Toast.makeText(this,"Configuracao salva",Toast.LENGTH_SHORT).show()
    }
}

