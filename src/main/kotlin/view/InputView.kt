package view

interface InputView {

    fun inputPlayer(): List<String>

    fun inputMoreCard(player: String): String
}