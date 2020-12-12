package model

import constant.Constant

class Player(cards: List<Card>, val name: String) : User(cards) {

    private val playerCards = mutableListOf<Card>().apply {
        addAll(cards)
    }

    fun getCards(): List<Card> = playerCards

    fun addCard(card: Card) {
        playerCards.add(card)
    }

    fun getCardRankSum(cards: List<Card>): Int {
        var sum = 0
        cards.forEach {
            sum += if (Card.isAce(it.rank)) getAceCardValue(sum) else Card.getRankValue(it.rank)
        }

        return sum
    }

    private fun getAceCardValue(sum: Int): Int {
        // ACE는 1 또는 11
        return if (sum + Constant.ACE_MAX_RANK > Constant.WINNER_VALUE) Constant.ACE_VALUE
        else Constant.ACE_MAX_RANK
    }
}