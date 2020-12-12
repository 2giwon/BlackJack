package controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import view.ConsoleInputView
import view.ConsoleOuputView

class BlackJackGameTest {

    private lateinit var blackJackGame: BlackJackGame

    @BeforeEach
    fun setup() {
        blackJackGame = BlackJackGame(ConsoleInputView(), ConsoleOuputView())
    }

    @Test
    fun `덱을 생성한다`() {
        val deck = blackJackGame.getDeck()
        assertThat(deck).isNotEqualTo(null)
    }

    @Test
    fun `플레이어를 생성한다`() {
        val deck = blackJackGame.getDeck()
        val players = blackJackGame.makePlayers(listOf("a", "b"), deck)

        assertThat(players).isNotEqualTo(null)
        assertThat(players).hasSizeGreaterThan(0)
    }

}