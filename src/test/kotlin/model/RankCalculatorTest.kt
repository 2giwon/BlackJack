package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankCalculatorTest {

    @Test
    fun `플레이어가 Ace를 들고 있을때 카드합계가 21이 되는지 확인한다`() {
        val player = Player("a")
        player.addCard(Card(Suit.DIAMOND, Rank.FOUR))
        player.addCard(Card(Suit.HEART, Rank.SIX))
        player.addCard(Card(Suit.CLUB, Rank.ACE))

        assertThat(RankCalculator.getPlayerTotalCardPoints(player)).isEqualTo(Constant.WINNER_VALUE)
    }
}