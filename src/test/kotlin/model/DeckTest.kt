package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun `덱 카드를 생성한다`() {
        val deck = Deck().createDeck()
        assertThat(deck.size).isEqualTo(Constant.MAX_CARDS)
    }

}