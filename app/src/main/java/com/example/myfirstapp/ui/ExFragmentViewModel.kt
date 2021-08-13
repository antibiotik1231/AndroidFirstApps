package com.example.myfirstapp.ui

import android.content.Context
import android.os.Looper
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.PriceAdapter
import com.example.myfirstapp.PriceResponse
import com.example.myfirstapp.Screens
import com.example.myfirstapp.Service
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ExFragmentViewModel @AssistedInject constructor(
    @Assisted private val number: Int,
    private val service: Service,
    private val router: Router
) : ViewModel() {

    private val adapter = PriceAdapter()

    fun getAdapter(): RecyclerView.Adapter<*> = adapter

    fun nextScreen() {
        router.navigateTo(Screens.ExScreen(number + 1))
    }

    fun exit() {
        router.exit()
    }

    fun someButton4(chainText: String) {
        return router.navigateTo(Screens.StartScreen(chainText))
    }

    fun someButton5() {
        val num = (number + 1).toString()
        val randomNumber = let { Random().nextInt(num.toInt()) }.toString()
        return router.navigateTo(Screens.RandomScreen(randomNumber, num))
    }

    fun someButton6(context: Context) {
        service.getPrice()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.from(ContextCompat.getMainExecutor(context)))
            .subscribe({it.valute?.also { adapter.setData(it) }}, { Log.i("exception", it.message ?: "")})
    }

    @AssistedFactory
    interface Factory {
        fun get(number: Int): ExFragmentViewModel
    }
}