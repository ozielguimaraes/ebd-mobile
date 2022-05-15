package com.admp.ebd.ui.chamada

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.admp.ebd.databinding.ActivitySelecionarClasseBinding

class SelecionarClasseActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelecionarClasseBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelecionarClasseBinding.inflate(layoutInflater)
        setContentView(binding.root)
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