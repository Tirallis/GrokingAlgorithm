package chapter_1

fun main() {

    val numbersList = (1..100).toList()
    val firstTest = binarySearch(numbersList, 3) ?: "Такого числа в списке нет"
    val secondTest = binarySearch(numbersList, -1) ?: "Такого числа в списке нет"
    val thirdTest = binarySearch(numbersList, 63) ?: "Такого числа в списке нет"


    println("Число находится в списке по индексу: $firstTest")
    println("Число находится в списке по индексу: $secondTest")
    println("Число находится в списке по индексу: $thirdTest")
}

fun binarySearch(sortedList: List<Int>, item: Int): Int? {
    var low = 0
    var high = sortedList.size - 1
    var stepCount = 0
    while (low <= high) {
        val mid = (low + high) / 2
        val guess = sortedList[mid]
        stepCount++
        println("Текущее значение: $mid, количество попыток: $stepCount")
        if (guess == item) {
            return mid
        } else if (guess > item) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return null
}
