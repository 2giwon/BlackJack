package model

class Game(val players: List<Player>, val deck: Deck) {

    fun checkMoreCard(index: Int): Boolean {
        val cards = players[index].getCards()
//        return players[index].getCardRankSum(cards) < Constant.WINNER_VALUE
        return true
    }
}