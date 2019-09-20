package br.edu.ifsp.sci.calculadorasdmkt.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

enum class Separador{VIRGULA, PONTO}

@Parcelize
data class Configuracao(var leiauteAvancado: Boolean = false,
                        var separador: Separador = Separador.PONTO): Parcelable
