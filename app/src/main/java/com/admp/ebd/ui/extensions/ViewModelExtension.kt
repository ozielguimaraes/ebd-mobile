package com.admp.ebd.ui.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.koin.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import kotlin.reflect.KClass

inline fun <reified T : ViewModel> AppCompatActivity.sharedViewModel(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { getSharedViewModel(qualifier, parameters) }

fun <T : ViewModel> AppCompatActivity.sharedViewModel(
    kClass: KClass<T>,
    qualifier: Qualifier? = null,
    parameters: ParametersDefinition? = null
): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { getSharedViewModel(kClass, qualifier, parameters) }

inline fun <reified T : ViewModel> AppCompatActivity.getSharedViewModel(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): T = getSharedViewModel(T::class, qualifier, parameters)

fun <T : ViewModel> AppCompatActivity.getSharedViewModel(
    kClass: KClass<T>,
    qualifier: Qualifier? = null,
    parameters: ParametersDefinition? = null
): T {
    return getKoin().getViewModel(
        this,
        kClass,
        qualifier,
        parameters
    )
}
