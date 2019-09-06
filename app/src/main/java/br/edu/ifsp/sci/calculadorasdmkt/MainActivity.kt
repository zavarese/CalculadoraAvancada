package br.edu.ifsp.sci.calculadorasdmkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var concatenaLcd: Boolean=true 
/*
    fun onClickZeroPontoResultadoDivisao(view: View?) {
        when (view){
            zeroBt -> {
                // Limpa LCD se último clicado foi um operador
                if (!concatenaLcd) {
                    lcdTv.text = ""
                }
                lcdTv.append((view as Button).text.toString())
                concatenaLcd = true
            }
            pontoBt -> {
                if (!lcdTv.text.toString().contains(".")){
                    if (!concatenaLcd) {
                        lcdTv.text = "0"
                    }
                    lcdTv.append(".")
                    concatenaLcd = true
                }
            }
            resultadoBt -> {
                lcdTv.text = Calculadora.calcula(
                    lcdTv.text.toString().toFloat(),
                    Operador.RESULTADO
                ).toString()
                concatenaLcd = false
            }
            divisaoBt -> {
                lcdTv.text = Calculadora.calcula(
                    lcdTv.text.toString().toFloat(),
                    Operador.DIVISAO
                ).toString()
                concatenaLcd = false
            }
        }
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        seteBt.setOnClickListener(this)
        oitoBt.setOnClickListener(this)
        noveBt.setOnClickListener(this)

        adicaoBt.setOnClickListener(this)

        umBt.setOnClickListener {
            if(!concatenaLcd){
                lcdTv.text=""
            }

            lcdTv.append((it as Button).text.toString())
            concatenaLcd=true
        }

        doisBt.setOnClickListener {it->
            if(!concatenaLcd){
                lcdTv.text=""
            }

            lcdTv.append((it as Button).text.toString())
            concatenaLcd=true
        }

        tresBt.setOnClickListener { p0: View->
            if(!concatenaLcd){
                lcdTv.text=""
            }

            lcdTv.append((p0 as Button).text.toString())
            concatenaLcd=true
        }

        multiplicacaoBt.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                lcdTv.text=Calculadora.calcula(
                        lcdTv.text.toString().toFloat(),
                    Operador.MULTIPLICACAO
                ).toString()

                concatenaLcd=false

            }
        })

        zeroBt.setOnClickListener(::onClickZeroPontoResultadoDivisao)
        pontoBt.setOnClickListener(){::onClickZeroPontoResultadoDivisao}
        resultadoBt.setOnClickListener(::onClickZeroPontoResultadoDivisao)
        val f: (View) -> Unit=::onClickZeroPontoResultadoDivisao
        divisaoBt.setOnClickListener(f)

 */
    }

    override fun onClick(p0: View?){
        if (p0==seteBt || p0==oitoBt || p0==noveBt){
            if(!concatenaLcd){
                lcdTv.text=""
            }
            lcdTv.append((p0 as Button).text.toString())
            concatenaLcd=true
        }else{
            if (p0==adicaoBt){
                lcdTv.text=Calculadora.calcula(
                    lcdTv.text.toString().toFloat(),
                    Operador.ADICAO
                ).toString()
            }
        }
    }

    fun onClickBtNum(p0:View?){
        if(!concatenaLcd){
            lcdTv.text=""
        }
        lcdTv.append((p0 as Button).text.toString())
        println("LOG1="+lcdTv.text.toString())
        concatenaLcd=true
    }

    fun onClickBtDiv(p0: View?){
        lcdTv.text=Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.DIVISAO
        ).toString()
        concatenaLcd=false
    }

    fun onClickBtSub(p0: View?){
        lcdTv.text=Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.SUBTRACAO
        ).toString()
        concatenaLcd=false
    }

    fun onClickBtMult(p0: View?){
        lcdTv.text=Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.MULTIPLICACAO
        ).toString()
        concatenaLcd=false
    }

    fun onClickBtAdic(p0: View?){
        lcdTv.text=Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.ADICAO
        ).toString()
        concatenaLcd=false
    }

    fun onClickBtResult(p0: View?){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.RESULTADO
        ).toString()
        concatenaLcd = false
    }

    fun onClickBtRoot(p0: View?){
        lcdTv.text=Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.RAIZ
        ).toString()
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.RESULTADO
        ).toString()
        concatenaLcd=false
    }

    fun onClickBtReset(p0: View?){
        lcdTv.text=Calculadora.calcula(
            0.0f,
            Operador.MULTIPLICACAO
        ).toString()
        lcdTv.text = Calculadora.calcula(
            0.0f,
            Operador.RESULTADO
        ).toString()
        concatenaLcd=false
    }

    fun onClickBtSubReset(p0: View?){
        lcdTv.text=""
        concatenaLcd=false
    }

    fun onClickBtPercent(p0: View?){
        lcdTv.text = (lcdTv.text.toString().toFloat()*0.01).toString()
        concatenaLcd = false
    }

    fun onClickBtPonto(p0: View?){
        if (!lcdTv.text.toString().contains(".")){
            if (!concatenaLcd) {
                lcdTv.text = "0"
            }
            lcdTv.append(".")
            concatenaLcd = true
        }
    }
}
