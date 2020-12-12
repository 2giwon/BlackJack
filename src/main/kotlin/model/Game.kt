package model

import constant.Constant

class Game(val players: List<Player>, private val deck: Deck) {

    fun addPlayerCard(index: Int) {
        players[index].addCard(deck.popCard())
    }

    fun checkMoreCard(index: Int): Boolean {
        val cards = players[index].getCards()
        return players[index].getCardRankSum(cards) < Constant.WINNER_VALUE
    }
}