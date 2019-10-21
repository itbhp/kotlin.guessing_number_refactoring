package fpmax

import kotlin.random.Random


fun main(args: Array<String>) {
        println("What is your name?")

        val name = readLine()

        println("Hello, $name, welcome to the game!")

        var exec = true

        while (exec) {
            val num = Random(seed(args)).nextInt(5) + 1

            println("Dear $name, please guess a number from 1 to 5:")

            val guess = readLine()?.toInt()

            if (guess == num) println("You guessed right, $name!")
            else println("You guessed wrong, $name! The number was: $num")

            println("Do you want to continue, $name?")

            when (readLine()) {
                "y" -> exec = true
                "n" -> exec = false
            }
        }
    }

private fun seed(args: Array<String>): Int {
    if(args.isNotEmpty()){
        return Integer.valueOf(args[0])
    }
    return 5
}
