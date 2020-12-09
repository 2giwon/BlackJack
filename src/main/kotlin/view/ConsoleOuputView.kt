package view

class ConsoleOuputView : OuputView {

    override fun outPutPlayerCardCount(count: Int, players: String) {
        println("${players}에게 ${count}장의 카드를 나누었습니다.")
    }

    override fun outputPlayerCards(player: String, cards: String) {
        println("${player}카드: $cards")
    }

    override fun resultGame(player: Map<String, Int>, cards: String) {

    }


}