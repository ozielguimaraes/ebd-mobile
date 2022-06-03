package com.admp.ebd.ui.chamada

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.admp.ebd.data.remote.entities.revista.RevistaRemoteEntity
import com.admp.ebd.databinding.ActivitySelecionarClasseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SelecionarClasseActivity : AppCompatActivity() {
    private val viewModel: SelecionarClasseViewModel by viewModel()
    private val binding by lazy { ActivitySelecionarClasseBinding.inflate(layoutInflater) }
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
        viewModel.turmasLiveData.observe(this) { turmas ->
//            val items: List<String> = emptyList()
//            for (item in turmas){
//                items.plus(item.turmaId)
//            }
//            turmas.map { it.turmaId }
//            val adapter = ArrayAdapter(this, null, items)
//            binding.spinnerTurmas.adapter = adapter
            Timber.i("chegou  a lista $turmas")
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