package br.edu.ifsp.sci.calculadorasdmkt.Model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONObject

class ConfiguracaoService(context: Context) {
    var configuracaoDao: ConfiguracaoDao
    init{
        // Inicializando conforme a fonte de dados utilizada
        configuracaoDao = ConfiguracaoSharedPreferences(context)
        // configuracaoDao = ConfiguracaoSqlite(context)
    }
    fun setConfiguracao(configuracao: Configuracao) {
        /* Qualquer tratamento necessário aos dados antes de salvá-los
        na fonte de dados escolhida deve ser feita no Service.
        As classes que implementam o DAO devem esconder as peculiaridades
        para acesso a cada fonte de dados diferente e executar apenas as funções
        de CRUD.*/
        // Tratamento de dados aqui!
        // Delegando ao modelo
        configuracaoDao.createOrUpdateConfiguracao(configuracao)
    }
    fun getConfiguracao(): Configuracao {
        // Tratamento de dados aqui!
        // Delegando ao modelo
        return configuracaoDao.readConfiguracao()
    }
}


/*
class ConfiguracaoService (context: Context){

    companion object {
        val NOME_ARQUIVO = "configuracoes"
        val MODO_ARQUIVO = Context.MODE_PRIVATE
        val TAG_CONFIGURACAO = "configuracao"
    }

    val gson: Gson
    val sharedPreferences: SharedPreferences

    init{
        sharedPreferences = context.getSharedPreferences(NOME_ARQUIVO, MODO_ARQUIVO)
        gson = GsonBuilder().create()
    }

    fun setConfiguracao(configuracao: Configuracao){
        val configuracaoJson = JSONObject(gson.toJson(configuracao))
        val spEditor: SharedPreferences.Editor = sharedPreferences.edit()
        spEditor.putString(TAG_CONFIGURACAO,configuracaoJson.toString())
        spEditor.commit()
    }

    fun getConfiguracao(): Configuracao{
        val configuracaoString = sharedPreferences.getString(TAG_CONFIGURACAO,"")

        return if(configuracaoString != "")
            gson.fromJson(configuracaoString, Configuracao::class.java)
        else
            Configuracao()
    }


}*/