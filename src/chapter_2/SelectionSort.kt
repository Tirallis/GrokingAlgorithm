package chapter_2

import kotlin.random.Random

fun main() {
    println(selectionSort(mutableListOf(5, 3, 6, 2, 10)))
    println(selectionSort(mutableListOf<Int>().apply {
        repeat(15) {
            this.add(Random.nextInt(1, 1000))
        }
    }))
}

fun findSmaller(list: List<Int>): Int {
    var smallest = list[0]
    var smallestIndex = 0

    for (i in 0..<list.size) {
        if (list[i] < smallest) {
            smallest = list[i]
            smallestIndex = i
        }
    }
    return smallestIndex
}

fun selectionSort(list: MutableList<Int>): List<Int> {
    val newList = mutableListOf<Int>()
    for (i in 0..<list.size) {
        val smallest = findSmaller(list)
        newList.add(list.removeAt(smallest))
    }
    return newList
}