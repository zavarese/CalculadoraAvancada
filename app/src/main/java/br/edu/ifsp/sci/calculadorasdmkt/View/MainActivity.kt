package br.edu.ifsp.sci.calculadorasdmkt.View

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.sci.calculadorasdmkt.Model.Configuracao
import br.edu.ifsp.sci.calculadorasdmkt.R
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction().replace(R.id.calculadoraFl, CalculadoraBasicaFragment()).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    object Constantes{
        val CONFIGURACOES_REQUEST_CODE = 0
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var retorno = false
        when (item.itemId){
            R.id.sairMenuItem -> {
                retorno = true
                finish()
            }
            R.id.configuracoesMenuItem -> {
                retorno = true
                val configuracaoIntent = Intent(this,ConfiguracaoActivity::class.java)
                startActivityForResult(configuracaoIntent,Constantes.CONFIGURACOES_REQUEST_CODE) //Chama onActivityResult
            }
        }
        return retorno
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /*
        when(requestCode){
            Constantes.OUTRA_TELA_REQUEST_CODE->{

            }
            Constantes.OUTRA_TELA_REQUEST_CODE_2->{

            }
        }
         */
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Constantes.CONFIGURACOES_REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK){
            //Pegar a configuracao retornada
            val configuracao = data?.getParcelableExtra<Configuracao>(ConfiguracaoActivity.Constantes.CONFIGURACAO)

           if(configuracao!!.leiauteAvancado){
                supportFragmentManager.beginTransaction().replace(R.id.calculadoraFl, CalculadoraAvancadaFragment()).commit()
            }else{

                    supportFragmentManager.beginTransaction().replace(R.id.calculadoraFl, CalculadoraBasicaFragment()).commit()

            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.calculadoraFl, CalculadoraBasicaFragment()).commit()

    }

}
