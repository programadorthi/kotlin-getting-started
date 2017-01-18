package br.com.programadorthi

/**
 * A class definition
 * <p/>
 * The extension functions in that context is not required.
 * I have used to only describe how the extension functions works
 */
class BottleSong {

    /**
     * An extension function that check how many items exists
     * and return a description.
     *
     * @param i The quantity
     */
    fun Int.bottles(i: Int): String {
        return when(i) {
            0 -> "no more bottles"
            1 -> "one bottle"
            else -> "$i bottles"
        }
    }

    /**
     * An extension function that capitalize the bottle description
     *
     * @param i The quantity
     */
    fun Int.Bottles(i: Int): String {
        return bottles(i).capitalize()
    }

    /**
     * Sing the song with the quantity informed.
     * <p/>
     * You will see the extension functions does not make sense in the context.
     * <p/>
     * I only used its to show how extension functions works
     */
    fun singTheSong(all: Int): String {
        val build = StringBuilder()
        for (i in all downTo 1) {
            build.append("""
${all.Bottles(i)} of beer on the wall, ${all.bottles(i)} of beer.
Take one down and pass it around, ${all.bottles(i - 1)} of beer on the wall.
""")
        }
        build.append("""
No more bottles of beer on the wall, no more bottles of beer.
Go to the store and buy some more, ${all.bottles(all)} of beer on the wall.
""")
        return build.toString()
    }
}

/**
 * Main function
 */
fun main(args: Array<String>) {
    val song = BottleSong()
    println(song.singTheSong(99))
}