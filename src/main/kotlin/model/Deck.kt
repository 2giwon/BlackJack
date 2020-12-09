package model

import constant.Constant

class Deck {

    private val myCards = mutableListOf<Card>()

    fun addCards(cards: List<Card>) {
        myCards.addAll(cards)
    }

    fun addCard(card: Card) {
        myCards.add(card)
    }

    fun createDeck(): List<Card> {
        val cards = mutableListOf<Card>()
        for (i in 0 until Constant.MAX_CARDS) {
            cards.add(Card.valueOf(i))
        }

        return cards.shuffled()
    }
}