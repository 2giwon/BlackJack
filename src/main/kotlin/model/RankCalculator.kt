package model

import constant.Constant

object RankCalculator {

    fun getPlayerTotalCardPoints(player: Player): Int {
        return player.playerCards
            .asSequence()
            .map { Card.getRankValue(it.rank) }
            .sortedDescending()
            .reduce { acc, value: Int ->
                acc + if (value == Constant.ACE_VALUE) getAceCardValue(value) else value
            }
    }

    private fun getAceCardValue(sum: Int): Int {
        return if (sum + Constant.ACE_MAX_RANK > Constant.WINNER_VALUE) Constant.ACE_VALUE
        else Constant.ACE_MAX_RANK
    }
}