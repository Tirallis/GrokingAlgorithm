package chapter_3

fun main() {
    println(factorial(3))
    println(factorial(6))
}

fun factorial(number: Int): Int {
    return if (number == 1) {
        1
    } else {
        number * factorial(number - 1)
    }
}