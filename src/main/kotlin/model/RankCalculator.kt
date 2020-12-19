package model

import constant.Constant

object RankCalculator {

    fun getPlayerTotalCardPoints(user: User): Int {
        var sum = 0
        val groupCards = user.playerCards.groupBy { Card.isAce(it.rank) }

        groupCards[false]?.forEach {
            sum += Card.getRankValue(it.rank)
        }
        groupCards[true]?.forEach { _ -> sum += getAceCardValue(sum) }
        return sum
    }

    private fun getAceCardValue(sum: Int): Int {
        return if (sum + Constant.ACE_MAX_RANK > Constant.WINNER_VALUE) Constant.ACE_VALUE
        else Constant.ACE_MAX_RANK
    }
}