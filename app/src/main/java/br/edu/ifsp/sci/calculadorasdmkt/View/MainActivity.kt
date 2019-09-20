package br.edu.ifsp.sci.calculadorasdmkt.View

import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

}
