package model

class Player : User() {

    override val cards: MutableList<Card> = mutableListOf()

    override fun makeUser(cards: List<Card>) {

    }

    fun addCard(card: Card) {

    }



}