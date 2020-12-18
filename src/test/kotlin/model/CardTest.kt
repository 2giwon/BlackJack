package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CardTest {

    @Test
    fun `카드 랭크가 ace인지 확인한다`() {
        val card = Card(Suit.DIAMOND, Rank.ACE)
        assertThat(Card.isAce(card.rank)).isEqualTo(true)
    }
}