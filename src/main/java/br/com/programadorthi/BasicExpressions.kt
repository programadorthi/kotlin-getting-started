package br.com.programadorthi

fun literals(): Unit {
    // string literals only works with double quotes or raw string
    println("Double quotes string")
    println("""
        Raw string
    """)

    // number literals
    val byteType: Byte = 8
    val shortType: Short = 16
    val intType: Int = 32
    val longType: Long = 64L
    val floatType: Float = 32.0F
    val doubleType: Double = 64.0

    println("Byte value: " + byteType)
    println("Short value: " + shortType)
    println("Integer value: " + intType)
    println("Long value: " + longType)
    println("Float value: " + floatType)
    println("Double value: " + doubleType)

    println()
    println("-- Type inference --")

    // number literals with type inferred
    val intType2 = 32
    val longType2 = 64L
    val floatType2 = 32.0F
    val doubleType2 = 64.0

    println("Is 32 an Integer value? " + (intType2 is Int))
    println("Is 64L a Long value? " + (longType2 is Long))
    println("Is 32.0F a Float value? " + (floatType2 is Float))
    println("Is 64.0 a Double value? " + (doubleType2 is Double))

    println()
}

fun operators() {
    // type inferred
    var i = 5

    println("-- Operators --")

    // addition
    println("$i + 1 = ${i + 1}")

    // subtraction
    println("$i - 1 = ${i - 1}")

    // multiplication
    println("$i * 3 = ${i * 3}")

    // division
    println("$i / 5 = ${i / 5}")

    // remainder
    println("$i % 5 = ${i % 5}")

    // assignment
    val copy = i
    i *= 2
    println("$copy *= 2 = $i")

    // relational operators
    println("$copy < 10 = ${copy < 10}")

    // postfix operators
    println("i++ = ${i++}")
    println("++i = ${++i}")
    println("i-- = ${i--}")
    println("--i = ${--i}")

    println()
}

fun collections() {

    println("-- Collections --")

    val list = listOf("Item 1", "Item 2", "Item 3")
    println("List of items: $list")
    println("Get first item in UPPERCASE: ${list[0].toUpperCase()}")

    val set = setOf(1, 3, 5)
    println(set)
    println("We have ${set.filter { it >= 3 }.size} items greater than or equal to 3 in the Set")

    val map = mapOf(Pair(1, "Item 1"), Pair(2, "Item 2"), Pair(3, "Item 3"))
    println(map)
    println("Get second item from map: ${map[2]}")

    println()
}

fun flowControls() {

    println("-- Flow controls --")

    val ten = 10
    if (ten == 10) {
        println("It seems like Java")
    } else {
        print("I do not know what to write")
    }

    val max = if (ten < 100) {
        100
    } else {
        ten
    }
    println("Max value returned from a if: $max")

    when (ten) {
        10 -> println("When replaces C Switch operator with powers")
        else -> println("Kotlin keeping going been awesome")
    }

    println()

}

fun loops() {
    println("-- Loops --")

    print("Counting using for loop: ")
    for (i in 1..10) {
        print("$i ")
    }

    println()

    val iterator = (1..10).iterator()
    print("Counting using while: ")
    while (iterator.hasNext()) {
        print("${iterator.next()} ")
    }

    println()
}

fun main(args: Array<String>) {
    literals()
    operators()
    collections()
    flowControls()
    loops()
}