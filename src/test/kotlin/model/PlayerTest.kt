package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class PlayerTest {

    @Test
    fun `플레이어 카드를 한장 추가한다`() {
        val player = Player("a")
        val playerCardCount = player.playerCards.size
        player.addCard(Card.valueOf(3))

        assertThat(player.playerCards.size).isNotEqualTo(playerCardCount)
    }
}