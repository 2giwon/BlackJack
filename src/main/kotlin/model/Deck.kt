package model

import constant.Constant
import java.util.*

class Deck {

    private val _cards: Queue<Card> = LinkedList<Card>()
    val cards: List<Card> get() = _cards.toList()

    fun createDeck() {
        val cards = mutableListOf<Card>()
        for (i in 0 until Constant.MAX_CARDS) {
            cards.add(Card.valueOf(i))
        }

        this._cards.addAll(cards.shuffled())
    }

    fun popCard(): Card = _cards.poll()
}