package model

import constant.Constant

class Game(val players: List<Player>, private val deck: Deck) {

    fun addPlayerCard(index: Int) {
        players[index].addCard(deck.popCard())
    }

    fun checkMoreCard(index: Int): Boolean {
        return players[index].getCardRankSum(players[index].getCards()) <= Constant.WINNER_VALUE
    }
}