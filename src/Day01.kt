import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val parts = input.map {
            val numbers = it.split("   ")
            listOf(numbers[0].toInt(), numbers[1].toInt())
        }
        val list1 = parts.map { it[0] }.sorted()
        val list2 = parts.map { it[1] }.sorted()
        return list1.foldIndexed(0) { i, v, c -> v+(c-list2[i]).absoluteValue }
    }

    fun part2(input: List<String>): Int {
        val parts = input.map {
            val numbers = it.split("   ")
            listOf(numbers[0].toInt(), numbers[1].toInt())
        }
        val list1 = parts.map { it[0] }.groupBy { it }
        val list2 = parts.map { it[1] }.groupBy { it }
        return list1.toList().fold(0) { acc, c -> acc + ((list2[c.first]?.size ?: 0) * c.second.size * c.first) }
    }

    // Test if implementation meets criteria from the description, like:
   // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput).also(::println) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
