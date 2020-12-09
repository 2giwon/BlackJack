package view

class ConsoleInputView : InputView {

    override fun inputPlayer(): String {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        val input = readLine()
        return input ?: ""
    }

    override fun inputMoreCard(player: String): String {
        println("${player}는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)")
        val input = readLine()
        return input ?: "n"
    }

}