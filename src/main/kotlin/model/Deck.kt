package model

import constant.Constant
import java.util.*

class Deck {

    private val cards: Queue<Card> = LinkedList<Card>()

    fun createDeck() {
        val cards = mutableListOf<Card>()
        for (i in 0 until Constant.MAX_CARDS) {
            cards.add(Card.valueOf(i))
        }

        this.cards.addAll(cards.shuffled())
    }

    fun popCard(): Card = cards.poll()
}