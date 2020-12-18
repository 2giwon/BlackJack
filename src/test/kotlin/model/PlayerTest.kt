package model

import org.junit.jupiter.api.BeforeEach

class PlayerTest {

    private lateinit var cards: List<Card>
    private lateinit var player: Player

    @BeforeEach
    fun setup() {
        cards = listOf(Card.valueOf(1), Card.valueOf(3))
        player = Player(cards, "a")
    }
}