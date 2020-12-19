package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankCalculatorTest {

    @Test
    fun `플레이어가 Ace를 중간에 들고 있을때 카드합계가 21이 되는지 확인`() {
        val user = User()
        user.addCard(Card(Suit.DIAMOND, Rank.FOUR))
        user.addCard(Card(Suit.CLUB, Rank.ACE))
        user.addCard(Card(Suit.HEART, Rank.SIX))

        assertThat(RankCalculator.getPlayerTotalCardPoints(user)).isEqualTo(Constant.WINNER_VALUE)
    }

    @Test
    fun `플레이어가 Ace카드를 2장 들고 있을때 카드 합계가 12인지 확인`() {
        val user = User()
        user.addCard(Card(Suit.DIAMOND, Rank.ACE))
        user.addCard(Card(Suit.CLUB, Rank.ACE))

        assertThat(RankCalculator.getPlayerTotalCardPoints(user)).isEqualTo(12)
    }

    @Test
    fun `플레이어가 Ace카드를 마지막에 있을때 카드 합계가 21인지 확인`() {
        val user = User()
        user.addCard(Card(Suit.HEART, Rank.QUEEN))
        user.addCard(Card(Suit.HEART, Rank.KING))
        user.addCard(Card(Suit.CLUB, Rank.ACE))

        assertThat(RankCalculator.getPlayerTotalCardPoints(user)).isEqualTo(Constant.WINNER_VALUE)
    }

    @Test
    fun `플레이어가 Ace카드 처음에 있을때 카드 합계가 21인지 확인`() {
        val user = User()
        user.addCard(Card(Suit.CLUB, Rank.ACE))
        user.addCard(Card(Suit.HEART, Rank.QUEEN))
        user.addCard(Card(Suit.HEART, Rank.KING))

        assertThat(RankCalculator.getPlayerTotalCardPoints(user)).isEqualTo(Constant.WINNER_VALUE)
    }
}