package view

import model.Card
import model.Player

class ConsoleOuputView : OuputView {

    override fun outPutPlayerCardCount(players: String) {
        println("${players}에게 2장의 카드를 나누었습니다.")
    }

    override fun outputPlayerCards(player: String, cards: List<Card>) {
        println("${player}카드: ${printCards(cards)}")
    }

    override fun resultGame(player: Player, total: Int) {
        println("${player.name}카드 : ${printCards(player.getCards())} - 결과: $total")
    }

    private fun printCards(cards: List<Card>): String {
        return cards.joinToString { "${it.rank.`val`}${it.suit.title}" }
    }
}