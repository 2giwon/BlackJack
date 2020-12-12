import controller.BlackJackGame
import view.ConsoleInputView
import view.ConsoleOuputView

fun main() {
    BlackJackGame(ConsoleInputView(), ConsoleOuputView())
        .startGame()
}