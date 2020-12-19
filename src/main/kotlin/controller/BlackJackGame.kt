package controller

import model.Deck
import model.Game
import model.Player
import model.RankCalculator
import view.InputView
import view.OuputView

class BlackJackGame(private val inputView: InputView, private val outputView: OuputView) {

    fun startGame() {
        val deck = Deck().apply { createDeck() }
        val playerNames: List<String> = inputView.inputPlayer()
        val game = Game(makePlayers(playerNames, deck), deck)

        outputView.outPutPlayerCardCount(game.players.joinToString { it.name })
        game.players.forEach {
            outputView.outputPlayerCards(it.name, it.playerCards)
        }

        game.players.forEachIndexed { index, _ -> giveCard(index, game) }

        game.players.forEach {
            outputView.resultGame(it, RankCalculator.getPlayerTotalCardPoints(it))
        }
    }

    private fun makePlayers(playerNames: List<String>, deck: Deck): List<Player> {
        return playerNames.map {
            Player(it).apply {
                addCard(deck.popCard())
                addCard(deck.popCard())
            }
        }
    }

    private fun giveCard(playerIndex: Int, game: Game) {
        while (game.checkMoreCard(playerIndex)) {
            val player = game.players[playerIndex]
            if (inputView.inputMoreCard(player.name) == "n") break

            player.addCard(game.deck.popCard())
            outputView.outputPlayerCards(player.name, player.playerCards)
        }
    }
}