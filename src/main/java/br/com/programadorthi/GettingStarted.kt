package br.com.programadorthi

/**
 * A full of function definition
 *
 * @param a First number
 * @param b Second number
 * @return The sum of the first and second number
 */
fun fullFun(a: Int, b: Int): Int {
    return a + b
}

/**
 * The short version of full function definition
 */
fun shortFun(c: Int, d: Int) = c + d

fun main(args: Array<String>) {
    println("The sum of 1 + 2 is ${fullFun(1, 2)}")
    println("The sum of 3 + 4, using a short function version, is ${shortFun(3, 4)}")
}