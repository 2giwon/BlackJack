package model

import constant.Constant

data class Card(
    val suit: Suit,
    val rank: Rank
) {
    companion object {
        fun isAce(rank: Rank): Boolean = Rank.ACE == rank

        fun getRankValue(rank: Rank): Int {
            return when (rank) {
                Rank.ACE -> Constant.ACE_VALUE
                Rank.JACK, Rank.QUEEN, Rank.KING -> Constant.JACK_QUEEN_KING_VALUE
                else -> rank.`val`.toInt()
            }
        }

        fun valueOf(index: Int): Card {
            val suitIndex = index / Rank.values().size
            val rankIndex = index % Rank.values().size
            return Card(Suit.values()[suitIndex], Rank.values()[rankIndex])
        }
    }
}