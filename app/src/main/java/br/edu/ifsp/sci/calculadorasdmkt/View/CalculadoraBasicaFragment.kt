package br.edu.ifsp.sci.calculadorasdmkt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.get
import androidx.fragment.app.Fragment
import br.edu.ifsp.sci.calculadorasdmkt.R
import br.edu.ifsp.sci.calculadorasdmkt.Utils.Calculadora
import br.edu.ifsp.sci.calculadorasdmkt.Utils.Operador
import kotlinx.android.synthetic.main.fragment_calculadora_basica.*

class CalculadoraBasicaFragment: Fragment(), View.OnClickListener {
    var concatenaLcd: Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculadora_basica, container, false)
    }

    override fun onClick(p: View?) {
        when (p) {
            // Números
            umBt, doisBt, tresBt, quatroBt, cincoBt,
            seisBt, seteBt, oitoBt, noveBt, zeroBt -> {
                // Limpa LCD se último clicado foi um operador
                if (!concatenaLcd) {
                    lcdTv.text = ""
                }
                lcdTv.append((p as Button).text.toString())
                concatenaLcd = true
            }
            // Ponto
            pontoBt -> {
                if (!lcdTv.text.toString().contains(".")){
                    if (!concatenaLcd) {
                        lcdTv.text = "0"
                    }
                    lcdTv.append(",")
                    concatenaLcd = true
                    //lcdTv.text.toString().replace(",",".",false)
                }
            }

            // Operadores
            adicaoBt -> cliqueOperador(Operador.ADICAO)
            subtracaoBt -> cliqueOperador(Operador.SUBTRACAO)
            multiplicacaoBt -> cliqueOperador(Operador.MULTIPLICACAO)
            divisaoBt -> cliqueOperador(Operador.DIVISAO)
            resultadoBt -> cliqueOperador(Operador.RESULTADO)
        }
    }

    fun cliqueOperador (operador: Operador){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            operador
        ).toString()
        concatenaLcd = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0..(view as ViewGroup).childCount - 1){
            val v = view.get(i)
            if(v is Button){
                v.setOnClickListener(::onClick)
            }
        }
    }
}