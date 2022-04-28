import kotlin.random.Random

fun main(){
    startGame()
}

fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal argument" }
    val rand = Random(System.nanoTime())
    return (start..end).random(rand)
}

fun startGame(){
    var guessCount = 0
    val secretNumber: Int = rand(0,100)
    val failLimit = 3

    for (i in 0..failLimit) {
        if(failLimit==guessCount) {
            println("You lost! The number was $secretNumber")
            startGame()
        }

        print("$secretNumber Take a guess son: ")
        val guess = try {
            readln().toInt()
        } catch (e: Exception) {
            0
        }

        if (guess < secretNumber) {
            guessCount++
            println("Too cold! Attempts: $guessCount/3")
        }
        else if (guess > secretNumber){
            guessCount++
            println("Too hot! Attempts: $guessCount/3")
        }
        else
        {
            guessCount++
            println("You won in $guessCount tries!")
            startGame()
        }
    }
}