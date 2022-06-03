package com.admp.ebd.ui.alunos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.admp.ebd.databinding.ActivityListaAlunoBinding
import org.koin.android.ext.android.inject

class ListaAlunoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityListaAlunoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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