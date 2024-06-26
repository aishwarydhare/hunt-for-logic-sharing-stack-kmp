package my.kotlinNodejsExample

@ExperimentalJsExport
@JsExport
class FibonacciGenerator {
    fun generate(input: FibonacciInput): Int? {
        if (input.count < 1) return null
        val sequence = mutableListOf(0, 1)
        while (sequence.size < input.count) {
            sequence.add(sequence[sequence.size - 1] + sequence[sequence.size - 2])
        }
        return sequence.take(input.count).last();
    }
}
