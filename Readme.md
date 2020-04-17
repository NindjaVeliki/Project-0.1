# Calculator
A basic calculator

## Build
>mvn clean compile

## Usage
>mvn exec:java -Dexec.args="[subcommmand] [operand] [operand]"

## Examples
```
// Addition
$ mvn exec:java -Dexec.args="add 2 2"
4.0

// Subtraction
$ mvn exec:java -Dexec.args="sub 4 2"
2.0

// Multiplication
$ mvn exec:java -Dexec.args="mul 2 3"
6.0

// Division
$ mvn exec:java -Dexec.args="div 6 2"
3.0
```