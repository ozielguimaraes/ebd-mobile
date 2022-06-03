package com.admp.ebd

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.admp.ebd.databinding.ActivityMainBinding
import com.admp.ebd.ioc.EbdModules
import com.admp.ebd.ui.alunos.ListaAlunoActivity
import com.admp.ebd.ui.chamada.SelecionarClasseActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        val viewPager: ViewPager = binding.viewPager
//        viewPager.adapter = sectionsPagerAdapter
//        val tabs: TabLayout = binding.tabs
//        tabs.setupWithViewPager(viewPager)
//
        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            startActivity(ListaAlunoActivity.getIntent(this))
        }

        binding.btnIrParaChamada.setOnClickListener {
            startActivity(SelecionarClasseActivity.getIntent(this))
        }
    }
}