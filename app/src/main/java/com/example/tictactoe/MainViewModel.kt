package com.example.tictactoe

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _status: MutableLiveData<String> = MutableLiveData("Next player: X")
    private val _boardIsEnabled: MutableLiveData<MutableList<Boolean>> =
        MutableLiveData(
            mutableListOf(
                true, true, true,
                true, true, true,
                true, true, true
            )
        )

    val status: LiveData<String> = _status
    val boardIsEnable: LiveData<MutableList<Boolean>> = _boardIsEnabled

    fun onTap(view: View) {
//        Log.d("${this.javaClass.simpleName}","onTap()")
//        Toast.makeText(view.context,"${(view as TextView).text}",Toast.LENGTH_SHORT).show()

        val text: String = (view as TextView).text.toString()
        val index: Int = text.toInt() - 1
        val list: MutableList<Boolean> = _boardIsEnabled.value!!
        list[index] = false
        _boardIsEnabled.value = list
        val player: String = GameManager.instances.nextTurn(index)
        view.text = player
        _status.value = "Next player: $player"
    }

    fun reset() {
//        _boardIsEnabled.value =
//            mutableListOf(
//            true, true, true,
//            true, true, true,
//            true, true, true
//        )
//        GameManager.instances.reset()
    }
}