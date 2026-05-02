package fpmax

import java.lang.Exception
import java.util.*
import kotlin.random.Random


fun main(args: Array<String>) {
    guess { randomNumber(args) }
}

fun guess(numberToGuess: () -> Int) {
    println("What is your name?")

    val name = readLine()

    println("Hello, " + name + ", welcome to the game!")

    gameLoop(numberToGuess, name)
}

private fun gameLoop(numberToGuess: () -> Int, name: String?) {
    val num = numberToGuess()

    println("Dear $name, please guess a number from 1 to 5:")

    readGuess()
        .map { guess ->
            processGuess(guess, num, name)
        }.orElseGet {
            println("Dear $name, you have to insert a number")
        }


    println("Do you want to continue, $name?")

    val answer = readLine()
    if (checkAnswer(answer)) gameLoop(numberToGuess, name)

}

private fun processGuess(guess: Int?, num: Int, name: String?) {
    if (guess == num)
        println("You guessed right, $name!")
    else
        println("You guessed wrong, $name! The number was: $num")
}

private fun readGuess() = Optional.ofNullable(
    try {
        readLine()?.toInt()
    } catch (_: Exception) {
        null
    }
)

private fun checkAnswer(answer: String?): Boolean =
    when (answer) {
        "y" -> true
        "n" -> false
        else -> false
    }

fun randomNumber(args: Array<String>) = Random(getSeed(args)).nextInt(5) + 1

private fun getSeed(args: Array<String>): Int {
    if (args.isNotEmpty()) {
        return args[0].toIntOrNull() ?: 5
    }
    return 5
}
