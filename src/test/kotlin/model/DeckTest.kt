package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeckTest {

    private lateinit var deck: Deck

    @BeforeEach
    fun setup() {
        deck = Deck()
    }

    @Test
    fun `덱 카드 52장을 랜덤하게 생성한다`() {
        val deckSize = deck.cards.size
        deck.createDeck()
        val totalCardCount = Constant.MAX_CARDS

        assertThat(deckSize).isNotEqualTo(deck.cards.size)
        assertThat(deck.cards.size).isEqualTo(totalCardCount)
    }

    @Test
    fun `덱 카드에서 카드 한장을 뽑는다`() {
        deck.createDeck()
        val deckSize = deck.cards.size
        deck.popCard()

        assertThat(deckSize).isNotEqualTo(deck.cards.size)
    }
}