package com.admp.ebd.ui.chamada

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.admp.ebd.databinding.ActivitySelecionarClasseBinding
import com.admp.ebd.ui.extensions.sharedViewModel

class SelecionarClasseActivity : AppCompatActivity() {
    private val viewModel by sharedViewModel<SelecionarClasseViewModel>()
    private val binding by lazy {
        ActivitySelecionarClasseBinding.inflate(layoutInflater)
    }
    private val adapter by lazy {
//        SelecionarClasseAdapter(this)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setupObservers()
        viewModel.carregarListaTurma()
    }

    private fun setupObservers() {
        setupTurmasObserver()
    }

    private fun setupTurmasObserver() {
        viewModel.turmasLiveData.observe(this) {

        }
    }

    companion object {
        fun getIntent(activity: Activity) : Intent =
            Intent(activity, SelecionarClasseActivity::class.java)

        fun getIntent(activity: Activity, bundle: Bundle) : Intent =
            getIntent(activity).apply {
                putExtras(bundle)
            }
    }
}