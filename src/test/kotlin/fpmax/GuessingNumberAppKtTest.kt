package fpmax

import org.junit.jupiter.api.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.Charset

internal class GuessingNumberAppKtTest {

    @Test
    fun failAndExit() {
        val charset = Charset.forName("utf-8")

        val bao = ByteArrayOutputStream()

        val inputs = listOf("Paolo", "4", "n")

        System.setIn(inputs.joinToString("\n").byteInputStream(charset))

        System.setOut(PrintStream(bao))

        main (arrayOf("2"))

        assertThat(
                bao.toString(charset),
                equalTo("What is your name?\nHello, Paolo, welcome to the game!\nDear Paolo, please guess a number from 1 to 5:\nYou guessed wrong, Paolo! The number was: 5\nDo you want to continue, Paolo?\n")
        )

    }

    @Test
    fun failAndContinue() {
        val charset = Charset.forName("utf-8")

        val bao = ByteArrayOutputStream()

        val inputs = listOf("Paolo", "4", "y", "3", "n")

        System.setIn(inputs.joinToString("\n").byteInputStream(charset))

        System.setOut(PrintStream(bao))

        main (arrayOf("2"))

        assertThat(
                bao.toString(charset),
                equalTo("What is your name?\n" +
                        "Hello, Paolo, welcome to the game!\n" +
                        "Dear Paolo, please guess a number from 1 to 5:\n" +
                        "You guessed wrong, Paolo! The number was: 5\n" +
                        "Do you want to continue, Paolo?\n" +
                        "Dear Paolo, please guess a number from 1 to 5:\n" +
                        "You guessed wrong, Paolo! The number was: 5\n" +
                        "Do you want to continue, Paolo?\n")
        )

    }

    @Test
    fun pass() {
        val charset = Charset.forName("utf-8")

        val bao = ByteArrayOutputStream()

        val inputs = listOf("Paolo", "5", "n")

        System.setIn(inputs.joinToString("\n").byteInputStream(charset))

        System.setOut(PrintStream(bao))

        main (arrayOf("2"))

        assertThat(
                bao.toString(charset),
                equalTo("What is your name?\n" +
                        "Hello, Paolo, welcome to the game!\n" +
                        "Dear Paolo, please guess a number from 1 to 5:\n" +
                        "You guessed right, Paolo!\n" +
                        "Do you want to continue, Paolo?\n")
        )
    }
}
