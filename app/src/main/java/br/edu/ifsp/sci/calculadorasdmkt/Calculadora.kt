package br.edu.ifsp.sci.calculadorasdmkt

/* Classe de enumeraÃ§Ã£o para constantes de operadores */
enum class Operador {
    RESULTADO, ADICAO, SUBTRACAO, MULTIPLICACAO, DIVISAO, LIMPEZA, RAIZ, PERCENTAGEM
}

/* Singleton que calcula operaÃ§Ãµes aritmÃ©ticas bÃ¡sicas */
object Calculadora {
    // primeiro operando
    var operando: Float = 0.0f

    // operador que serÃ¡ aplicado entre primeiro e segundo operando
    var operador: Operador = Operador.RESULTADO

    /* calcula um valor de retorno com base no operando e operador jÃ¡ existentes, novo valor
     e atualiza valor de operando e operador */
    fun calcula(valor: Float, operador: Operador): Float {
        when (this.operador) {
            Operador.RESULTADO -> operando = valor
            Operador.ADICAO -> operando += valor
            Operador.SUBTRACAO -> operando -= valor
            Operador.MULTIPLICACAO -> operando *= valor
            Operador.DIVISAO -> operando /= valor
            Operador.LIMPEZA -> operando = valor*0.0f
            Operador.RAIZ -> operando = Math.sqrt(valor.toDouble()).toFloat()
        }
        this.operador = operador
        return operando
    }
}