package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random

class CardTest {

    @Test
    fun `특정 인덱스로 전체 카드 목록에서 카드를 가져온다`() {
        val card =
            Card.valueOf(Random(System.currentTimeMillis()).nextInt(Constant.MAX_CARDS))

        assertThat(card.rank).isNotNull()
        assertThat(card.suit).isNotNull()
        assertThat(card.suit.ordinal).isGreaterThan(-1)
        assertThat(card.rank.ordinal).isGreaterThan(-1)
    }

    @Test
    fun `카드 랭크 값을 가져온다`() {
        val card =
            Card.valueOf(Random(System.currentTimeMillis()).nextInt(Constant.MAX_CARDS))

        val value = Card.getRankValue(card.rank)
        assertThat(value).isGreaterThan(0)
        assertThat(value).isLessThan(Constant.ACE_MAX_RANK + 1)
    }

    @Test
    fun `카드 랭크가 ace인지 확인한다`() {
        val card = Card(Card.Suit.DIAMOND, Card.Rank.ACE)
        assertThat(Card.isAce(card.rank)).isEqualTo(true)
    }
}