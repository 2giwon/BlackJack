package model

abstract class User {

    protected abstract val cards: MutableList<Card>

    abstract fun makeUser(cards: List<Card>)
}