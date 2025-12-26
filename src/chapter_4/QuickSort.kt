package chapter_4

fun quickSort(numbersList: List<Int>): List<Int> {
    if (numbersList.size < 2) {
        return numbersList
    } else {
        val pivot = numbersList[0]
        val equals = numbersList.filter { it == pivot }
        val less = numbersList.drop(1).filter { it < pivot }
        val greater = numbersList.drop(1).filter { it > pivot }
        return quickSort(less) + equals + quickSort(greater)
    }
}

fun main() {
    println(quickSort(listOf(10, 5, 2, 3)))
}