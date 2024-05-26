const FibFromKotlin = require('../../../build/js/packages/myModuleName/kotlin/myModuleName');

console.log(FibFromKotlin);

const {
    FibonacciGenerator,
    FibonacciInput,
} = FibFromKotlin.my.kotlinNodejsExample;

const { ExportedFibonacci } = FibFromKotlin;

console.log("=== output from Kotlin generated JS ===");

const count = 10;

const fibGen = new FibonacciGenerator();
const fibInput = new FibonacciInput(count);
const result = fibGen.generate(fibInput);
console.log(`Fib term at ${count} location is ${result}`)

const exportedFibGen = new ExportedFibonacci();
const result2 = exportedFibGen.runFibonacci(count-1);
console.log(`From ExportedFibonacci - Fib term at ${count} location is ${result2}`)
