package fpmax

import java.lang.Exception
import java.lang.NumberFormatException
import java.util.*
import kotlin.random.Random


fun main(args: Array<String>) {
    guess { randomNumber() }
}

fun guess(numberToGuess: () -> Int) {
    println("What is your name?")

    val name = readLine()

    println("Hello, " + name + ", welcome to the game!")

    var exec = true

    while (exec) {
        val num = numberToGuess()

        println("Dear $name, please guess a number from 1 to 5:")

        readGuess()
            .map { guess ->
                if (guess == num) println("You guessed right, $name!")
                else println("You guessed wrong, $name! The number was: $num")
            }.orElseGet {
                println("Dear $name, you have to insert a number")
            }


        println("Do you want to continue, $name?")

        val answer = readLine()
        exec = checkAnswer(answer)
    }
}

private fun readGuess() = Optional.ofNullable(
    try {
        readLine()?.toInt()
    } catch (e: Exception) {
        null
    }
)

private fun checkAnswer(answer: String?): Boolean =
    when (answer) {
        "y" -> true
        "n" -> false
        else -> false
    }

fun randomNumber() = Random.nextInt(5) + 1