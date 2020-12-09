package view

interface OuputView {

    fun outPutPlayerCardCount(count: Int, players: String)

    fun outputPlayerCards(player: String, cards: String)

    fun resultGame(player: Map<String, Int>, cards: String)
}