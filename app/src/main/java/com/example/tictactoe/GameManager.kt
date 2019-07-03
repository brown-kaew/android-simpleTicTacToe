package com.example.tictactoe

import android.util.Log

class GameManager  private constructor(){

    private var _turn:Int = 0
    private val _gameBoard:MutableList<List<String>> = mutableListOf(listOf("1","2","3","4","5","6","7","8","9"))

    object Holder{
        val INSTANCE = GameManager()
    }

    companion object{
        var instances:GameManager = Holder.INSTANCE
            private set

    }

    fun nextTurn(index:Int):String{
        val player = if(_turn%2==0) "X" else "O"
        val list:MutableList<String> = _gameBoard[_turn].toMutableList()
        list[index] = player
        _turn++
        _gameBoard.add(_turn,list)
        Log.d("${this.javaClass.simpleName}","list ${_gameBoard.toString()}")
        return player
    }

    fun reset(){
//        _turn = 0
//        _gameBoard.clear()
//        _gameBoard.add(listOf("1","2","3","4","5","6","7","8","9"))
    }
}
