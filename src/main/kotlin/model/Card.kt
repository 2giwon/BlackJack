package model

data class Card(
    val suit: Suit,
    val rank: Rank
) {
    enum class Suit(title: String) {
        HEART("하트"),
        DIAMOND("다이아몬드"),
        SPADE("스페이드"),
        CLUB("클로버")
    }

    enum class Rank(`val`: Int) {
        // ACE는 1 또는 11
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10)
    }

    companion object {
        fun valueOf(index: Int): Card {
            val suitIndex = index % Suit.values().size
            val rankIndex = index % Rank.values().size
            return Card(Suit.values()[suitIndex], Rank.values()[rankIndex])
        }
    }
}