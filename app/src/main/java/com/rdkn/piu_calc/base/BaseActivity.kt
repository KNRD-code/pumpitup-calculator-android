package com.rdkn.piu_calc.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.datastore.core.DataStore
import io.github.jan.supabase.SupabaseClient
import kotlinx.coroutines.flow.catch
import org.koin.android.ext.android.inject
import java.util.prefs.Preferences

abstract class BaseActivity<T: ViewDataBinding> : AppCompatActivity() {
    val dbClient: SupabaseClient by inject()
    lateinit var binding: T
    abstract var layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)

        init()
    }

    abstract fun init()

    companion object {
        const val KEY_TITLE = "TITLE"
        const val KEY_LEVEL = "LEVEL"
        const val KEY_USER_INFO = "USER_INFO"

        const val DATA_KEY_RATING = "RATING"
    }
}