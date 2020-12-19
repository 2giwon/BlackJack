package model

import constant.Constant

class Game(val players: List<Player>, val deck: Deck) {

    fun checkMoreCard(index: Int): Boolean {
        val totalPoints = RankCalculator.getPlayerTotalCardPoints(players[index])
        return totalPoints <= Constant.WINNER_VALUE
    }
}