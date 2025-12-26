package chapter_4

fun farmerPlace(x: Int, y: Int): Int {
    var sideSize = y
    if (x % y != 0) {
        sideSize = farmerPlace(y, x % y)
    }
    return sideSize
}


fun sumNumbers(numbersList: MutableList<Int>): Int {
    if (numbersList.isNotEmpty()) {
        return numbersList.removeAt(0) + sumNumbers(numbersList)
    }
    return 0
}

fun <T> countElements(elementsList: MutableList<T>): Int {
    if (elementsList.isEmpty()) {
        return 0
    } else {
        elementsList.removeFirst()
        return 1 + countElements(elementsList)
    }
}

fun maxNumbersOnList(numbersList: MutableList<Int>): Int {
    if (numbersList.size == 2) {
        return if (numbersList[0] > numbersList[1]) numbersList[0] else numbersList[1]
    }
    val subMax = maxNumbersOnList(numbersList.slice(1..<numbersList.size).toMutableList())
    return if (numbersList[0] > subMax) numbersList[0] else subMax
}

fun main() {
    val firstTest = farmerPlace(1680, 640)
    println(" У поля с размерами 1680х640 максимальный размер разделённого поля составляет: ${firstTest}x${firstTest}")

    val secondTest = farmerPlace(50, 2)
    println("У поля с размерами 50х25 максимальный размер разделённого поля составляет: ${secondTest}x${secondTest}")

    val thirdTest = farmerPlace(110, 3)
    println("У поля с размерами 110x30 максимальный размер разделённого поля составляет: ${thirdTest}x${thirdTest}")

    val foursTest = farmerPlace(121, 1)
    println("У поля с размерами 121х10 максимальный размер разделённого поля составляет: ${foursTest}x${foursTest}")

    val fivesTest = farmerPlace(125, 4)
    println("У поля с размерами 125х43 максимальный размер разделённого поля составляет: ${fivesTest}x${fivesTest}")

    val sixesTest = farmerPlace(129, 3)
    println("У поля с размерами 129х33 максимальный размер разделённого поля составляет: ${sixesTest}x${sixesTest}")


    println("Сумма чисел массива [2, 4, 6] равна ${sumNumbers(mutableListOf(2, 4, 6))}")
    println("Сумма чисел массива [7, 18, 47] равна ${sumNumbers(mutableListOf(7, 18, 47))}")


    println("Количество элементов массива [1, 45, 15] равна ${countElements(mutableListOf(1, 45, 15))}")
    println(
        "Количество элементов массива [Monster, Drawer, Hunter, Lazer, Pointer] равна ${
            countElements(
                mutableListOf(
                    "Monster",
                    "Drawer",
                    "Hunter",
                    "Lazer",
                    "Pointer"
                )
            )
        }"
    )


    println("Максимальное число равно: ${maxNumbersOnList(mutableListOf(1, 2, 12))}")
    println("Максимальное число равно: ${maxNumbersOnList(mutableListOf(78, 2, 1))}")
    println("Максимальное число равно: ${maxNumbersOnList(mutableListOf(1, 74, 2))}")
    println("Максимальное число равно: ${maxNumbersOnList(mutableListOf(1, 87, 9741))}")
}