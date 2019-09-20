package br.edu.ifsp.sci.calculadorasdmkt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.edu.ifsp.sci.calculadorasdmkt.R

class CalculadoraAvancadaFragment {
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculadora_avancada, container, false)
    }
}