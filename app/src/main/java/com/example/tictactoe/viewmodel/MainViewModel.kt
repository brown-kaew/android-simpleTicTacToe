package com.example.tictactoe.viewmodel

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoe.model.GameManager

class MainViewModel : ViewModel() {

    private val gameManager = GameManager()

    private val _status: MutableLiveData<String> = MutableLiveData("Next player: X")
    private val _board: MutableLiveData<List<String>> =
        MutableLiveData(
            gameManager.getCurrentBoard()
        )
    private val _boardIsEnabled: MutableLiveData<MutableList<Boolean>> =
        MutableLiveData(
            mutableListOf(
                true, true, true,
                true, true, true,
                true, true, true
            )
        )

    val status: LiveData<String> = _status
    val board: LiveData<List<String>> = _board
    val boardIsEnable: LiveData<MutableList<Boolean>> = _boardIsEnabled

    fun onTap(view: View) {

        //get index
        val text: String = (view as TextView).text.toString()
        val index: Int = text.toInt() - 1

        //set disabled view
        val list: MutableList<Boolean> = _boardIsEnabled.value!!
        list[index] = false
        _boardIsEnabled.value = list

        //set player turn
        val player: String = gameManager.nextTurn(index)
        _status.value = "Next player: $player"

        //update game board
        updateGameBoard()

        //check winner
        if (gameManager.checkWinner() != null) {
            _status.value = "${gameManager.checkWinner()} wins!!!"
            disableBoard()
        }
    }

    private fun disableBoard() {
        _boardIsEnabled.value =
            mutableListOf(
                false, false, false,
                false, false, false,
                false, false, false
            )
    }

    private fun updateGameBoard() {
        _board.value = gameManager.getCurrentBoard()
    }

    fun reset() {
        _boardIsEnabled.value =
            mutableListOf(
                true, true, true,
                true, true, true,
                true, true, true
            )
        gameManager.reset()
        updateGameBoard()
        _status.value = "Next player: X"
    }
}