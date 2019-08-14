package fpmax

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.Charset

class GuessingNumberAppKtTest {

    @Test
    fun failAndExit() {
        val charset = Charset.forName("utf-8")

        val bao = ByteArrayOutputStream()

        val inputs = listOf("Paolo", "4", "n")

        System.setIn(inputs.joinToString("\n").byteInputStream(charset))

        System.setOut(PrintStream(bao))

        guess { 2 }

        assertThat(bao.toString(charset), equalTo("What is your name?\nHello, Paolo, welcome to the game!\nDear Paolo, please guess a number from 1 to 5:\nYou guessed wrong, Paolo! The number was: 2\nDo you want to continue, Paolo?\n"))

    }

    @Test
    fun failAndContinue() {
        val charset = Charset.forName("utf-8")

        val bao = ByteArrayOutputStream()

        val inputs = listOf("Paolo", "4", "y", "3", "n")

        System.setIn(inputs.joinToString("\n").byteInputStream(charset))

        System.setOut(PrintStream(bao))

        guess { 2 }

        assertThat(bao.toString(charset), equalTo("What is your name?\nHello, Paolo, welcome to the game!\nDear Paolo, please guess a number from 1 to 5:\nYou guessed wrong, Paolo! The number was: 2\nDo you want to continue, Paolo?\nDear Paolo, please guess a number from 1 to 5:\nYou guessed wrong, Paolo! The number was: 2\nDo you want to continue, Paolo?\n"))

    }

    @Test
    fun pass() {
        val charset = Charset.forName("utf-8")

        val bao = ByteArrayOutputStream()

        val inputs = listOf("Paolo", "2", "n")

        System.setIn(inputs.joinToString("\n").byteInputStream(charset))

        System.setOut(PrintStream(bao))

        guess { 2 }

        assertThat(bao.toString(charset), equalTo("What is your name?\nHello, Paolo, welcome to the game!\nDear Paolo, please guess a number from 1 to 5:\nYou guessed right, Paolo!\nDo you want to continue, Paolo?\n"))
    }
}