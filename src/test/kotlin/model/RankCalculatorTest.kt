package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

object RankCalculator {

    fun getPlayerTotalCardPoints(player: Player): Int {
        return player.getCards()
            .asSequence()
            .map { Card.getRankValue(it.rank) }
            .sortedDescending()
            .reduce { acc, value: Int ->
                acc + if (value == Constant.ACE_VALUE) getAceCardValue(value) else value
            }
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

class RankCalculatorTest {


    @Test
    fun `플레이어가 Ace를 들고 있을때 카드합계가 21이 되는지 확인한다`() {
        val player = Player(
            listOf(

            ), "a"
        )

        assertThat(RankCalculator.getPlayerTotalCardPoints(player)).isEqualTo(Constant.WINNER_VALUE)
    }
}