# Calculator
A basic calculator

## Build
### Java
>mvn clean compile

### Postgres
```bash
docker build -t opsdb .
docker run --name opsdb -d --rm -p 5432:5432 opsdb
```

## Usage
>java -jar target/*.jar [subcommmand],"[operand] [operand]"

## Design
### Architecture
- Calc is a command line application
- The math package defines an Operation abstract class, Outputtable interface, and several math subtypes
- The io package reads a hardcoded history.txt file, and currently appends fake data to that file

### Main algorithm
- The main class calls a OperationFactory singleton
- The singleton is passed the command line args for parsing, and returns some Operation of type Outputtable
    - A subcommand is parsed to determine the subtype of Operation to instantiate
    - The instantiated Operation performs its math function which is saved as part of its state
- The operation is printed to the console
- The FileParser writes to history.txt
- The FileParser reads history.txt into an ArrayList
    - FileParser read prints each line to console
    - FileParser read method adds dummy data to ArrayList