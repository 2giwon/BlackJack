package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameTest {

    private lateinit var game: Game

    @BeforeEach
    fun setup() {
        game = Game(
            listOf(
                Player(listOf(Card.valueOf(0), Card.valueOf(1)), "a"),
                Player(listOf(Card.valueOf(2), Card.valueOf(3)), "b")
            ),
            Deck().apply { createDeck() }
        )
    }

    @Test
    fun `플레이어 카드를 한장 추가한다`() {
        val count = game.players[0].getCards().size
        game.addPlayerCard(0)
        assertThat(game.players[0].getCards().size).isGreaterThan(count)
    }

    @Test
    fun `플레이어의 카드 합계가 카드 한장을 더 주어도 21을 넘지 않는지 체크 한다`() {
        val player = Player(
            listOf(
                Card(Card.Suit.DIAMOND, Card.Rank.TEN),
                Card(Card.Suit.HEART, Card.Rank.TEN),
                Card(Card.Suit.CLUB, Card.Rank.ACE)
            ), "a"
        )

        val game = Game(listOf(player), Deck())

        assertThat(game.checkMoreCard(0)).isEqualTo(false)
    }
}