package view

import model.Card
import model.Player

interface OuputView {

    fun outPutPlayerCardCount(players: String)

    fun outputPlayerCards(player: String, cards: List<Card>)

    fun resultGame(player: Player, total: Int)
}