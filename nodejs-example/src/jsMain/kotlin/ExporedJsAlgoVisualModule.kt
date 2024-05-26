import my.kotlinNodejsExample.fibonacci

@ExperimentalJsExport
@JsExport
class ExportedFibonacci {
    fun runFibonacci(n: Number) : Number {
        return fibonacci(n)
    } 
}
