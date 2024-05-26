package my.kotlinNodejsExample

fun main() {
    val count = 20
    val fibonacciInput = FibonacciInput(count)
    val fibonacciGenerator = FibonacciGenerator()
    val result = fibonacciGenerator.generate(fibonacciInput)
    println("Hello World!!")
    println("From Kotlin Native - Fib term at ${fibonacciInput.count} location is ${result}")

    /*
    // Trying JS library in Kotlin now
    const fibonacci = require ('fibonacci');
    const bigNumber = fibonacci.iterate (3000);
    console.log (bigNumber);
    */
    val result2 = fibonacci(count-1)
    println("From JS Library- Fib term at ${count} location is ${result2}")
}
