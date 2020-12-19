package model

class Player(val name: String) : User() {

    override val cards: MutableList<Card> = mutableListOf()
    val playerCards: List<Card> get() = cards

    fun addCard(card: Card) {
        cards.add(card)
    }
}