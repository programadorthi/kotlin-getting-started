package br.com.programadorthi

import java.io.FileReader

data class Movie(
        val title: String,
        val year: Int,
        val rating: Float,
        val numberOfVotes: Long,
        val categories: Set<String>
)

fun main(args: Array<String>) {

    val fileLocation = "/media/thiago/home-hd/thiago/Desenvolvimento/Workspaces/intellij-workspace/kotlin-getting-started/src/main/resources/data.csv"

    val movies = FileReader(fileLocation).readLines().map {
        it.split("  ").iterator()
    }.map {
        Movie(
                it.next(),
                it.next().toInt(),
                it.next().toFloat(),
                it.next().toLong(),
                hashSetOf()
        )
    }

    // Number of Actions Movies
    val numbers = movies
            .filter { it.categories.contains("Action") } // Get moview with action categorie
            .size // The final size after filtering
    println("Is 828 the Number of Actions Movies: ${numbers == 828}")

    // The year of the best movie of 80's (1980-1989)
    val year = movies
            .filter { (1980..1989).contains(it.year) } // Get movies between the years
            .maxBy { it.rating } // Get max by rating
            ?.year // Get the year of the best movie
    println("Is 1989 the best? ${year == 1989}")

    // The sum of the number of votes of the two top rated movies
    val sum = movies
            .sortedBy { -it.rating } // Desc order
            .take(2) // Top two
            .map { it.numberOfVotes } // Transform to list of Long
            .reduce { a, b -> a + b } // Sum all items from List
    println("Is the sum 47_229? ${sum == 47229L}")

}
