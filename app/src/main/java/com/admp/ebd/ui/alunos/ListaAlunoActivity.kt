package com.admp.ebd.ui.alunos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.admp.ebd.databinding.ActivityListaAlunoBinding

class ListaAlunoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaAlunoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(activity: Activity) : Intent =
            Intent(activity, ListaAlunoActivity::class.java)

        fun getIntent(activity: Activity, bundle: Bundle) : Intent =
            getIntent(activity).apply {
                putExtras(bundle)
            }
    }
}