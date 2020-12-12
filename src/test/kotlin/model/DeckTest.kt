package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class DeckTest {

    @Test
    fun `카드를 한장 뽑는다`() {
        val deck = Deck()
        deck.createDeck()
        assertThat(deck.popCard()).isNotEqualTo(null)
    }
}