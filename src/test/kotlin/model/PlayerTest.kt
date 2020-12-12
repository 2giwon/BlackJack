package model

import constant.Constant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Player(cards: List<Card>, val name: String) : User(cards) {

    private val playerCards = mutableListOf<Card>().apply {
        addAll(cards)
    }

    fun getCards(): List<Card> = playerCards

    fun addCard(card: Card) {
        playerCards.add(card)
    }

    fun getCardRankSum(cards: List<Card>): Int {
        return cards.map {
            Card.getRankValue(it.rank)
        }.fold(0) { acc, i ->
            acc + if (i == Constant.ACE_VALUE) getAceCardValue(acc) else i
        }
    }

    private fun getAceCardValue(sum: Int): Int {
        return if (sum + Constant.ACE_MAX_RANK > Constant.WINNER_VALUE) Constant.ACE_VALUE
        else Constant.ACE_MAX_RANK
    }
}

class PlayerTest {

    private lateinit var cards: List<Card>
    private lateinit var player: Player

    @BeforeEach
    fun setup() {
        cards = listOf(Card.valueOf(1), Card.valueOf(3))
        player = Player(cards, "a")
    }

    @Test
    fun `플레이어 카드를 가져온다`() {
        assertThat(player.getCards()).isNotEqualTo(null)
        assertThat(player.getCards()).hasSizeGreaterThan(0)
    }

    @Test
    fun `플레이어의 카드를 추가한다`() {
        val count = player.getCards().size
        player.addCard(Card.valueOf(4))
        assertThat(player.getCards()).hasSizeGreaterThan(count)
    }

    @Test
    fun `플레이어 카드들의 점수 합계를 가져온다`() {
        val sum = player.getCardRankSum(player.getCards())
        assertThat(sum).isGreaterThan(0)
        player.addCard(Card.valueOf(5))
        assertThat(player.getCardRankSum(player.getCards())).isNotEqualTo(sum)
    }

    @Test
    fun `플레이어 카드에게 ACE가 있고 합이 21이 넘을 때 ACE의 계산법을 가져온다`() {
        val player = Player(
            listOf(
                Card(Card.Suit.DIAMOND, Card.Rank.TEN),
                Card(Card.Suit.HEART, Card.Rank.TEN),
                Card(Card.Suit.CLUB, Card.Rank.ACE)
            ), "a"
        )

        val sum = player.getCardRankSum(player.getCards())
        assertThat(sum).isEqualTo(Constant.WINNER_VALUE)
    }
}