package com.example.tictactoe.model

import android.util.Log

class GameManager {

    private var _turn: Int = 0
    private val _gameBoard: MutableList<List<String>> =
        mutableListOf(listOf("1", "2", "3", "4", "5", "6", "7", "8", "9"))

    fun nextTurn(index: Int): String {
        val currentPlayer = if (_turn % 2 == 0) "X" else "O"
        val list: MutableList<String> = _gameBoard[_turn].toMutableList()
        list[index] = currentPlayer
        _turn++
        _gameBoard.add(_turn, list)
//        Log.d("${this.javaClass.simpleName}", "list ${_gameBoard.toString()}")
        return if (_turn % 2 == 0) "X" else "O"
    }

    fun checkWinner(): String? {
        val list: List<String> = getCurrentBoard()

        //rows check
        val cols = 3
        for (row in 0..2) {
            val increment = row * cols
            if (list[0 + increment] == list[1 + increment] && list[0 + increment] == list[2 + increment]) {
                return list[0 + increment]
            }
        }
        //columns check
        for (col in 0..2) {
            if (list[0 + col] == list[3 + col] && list[0 + col] == list[6 + col]) {
                return list[0 + col]
            }
        }
        //cross check
        if (list[0] == list[4] && list[0] == list[8]) {
            return list[0]
        } else if (list[6] == list[4] && list[6] == list[2]) {
            return list[6]
        }

        return null
    }

    fun getCurrentBoard(): List<String> {
        return _gameBoard[_turn]
    }

    fun reset() {
        _turn = 0
        _gameBoard.clear()
        _gameBoard.add(listOf("1", "2", "3", "4", "5", "6", "7", "8", "9"))
    }
}
