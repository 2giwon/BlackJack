package controller

import model.Deck
import model.Game
import model.Player
import view.InputView
import view.OuputView

class BlackJackGame(private val inputView: InputView, private val outputView: OuputView) {

    fun startGame() {
        val deck: Deck = getDeck()
        val playerNames: List<String> = inputView.inputPlayer()
        val game = Game(makePlayers(playerNames, deck), deck)

        outputView.outPutPlayerCardCount(game.players.joinToString { it.name })
        game.players.forEach {
            outputView.outputPlayerCards(it.name, it.getCards())
        }

        game.players.forEachIndexed { index, _ -> giveCard(index, game) }

//        game.players.forEach {
//            outputView.resultGame(it, it.getCardRankSum(it.getCards()))
//        }
    }

    fun makePlayers(playerNames: List<String>, deck: Deck): List<Player> {
        return playerNames.map {
            Player(listOf(deck.popCard(), deck.popCard()), it)
        }
    }

    fun getDeck(): Deck = Deck().apply { createDeck() }

    private fun giveCard(playerIndex: Int, game: Game) {
        while (game.checkMoreCard(playerIndex)) {
            val player = game.players[playerIndex]
            if (inputView.inputMoreCard(player.name) == "n") break

            player.addCard(game.deck.popCard())
            outputView.outputPlayerCards(player.name, player.getCards())
        }
    }
}