# Calculator
A basic calculator

## Build
### Java
>mvn clean package

### Postgres
```bash
docker build -t opsdb -f src/main/db/Dockerfile
docker run --name opsdb -d --rm -p 5432:5432 opsdb
```

## Usage
### For CSV batch operations
>java -jar target/*.jar parse [path/to/file.csv]

### For single operations
>java -jar target/*.jar [subcommmand],"[operand] [operand]"

## Design
### Architecture
- Calc is a command line application
- The math package defines an Operation abstract class, Calculatable interface, and several math subtypes
- The io.FileParser class reads a csv file into a List of Operations
- The io.DataSource creates Connection objects for OperationRepository
- OperationRepository inserts and selects data from a sql database

### Main algorithm
- The main class parses args, and if they exist
    - If the first argument is "parse"
        - It opens the following argument as a file
        - FileParser loads the file into a List of Operations
        - Each Operation's result is calculated
        - The List is passed to a OperationRepository to insert all Operations to a sql database
        - OperationRepository queries the database for all Operations
        - The returned List of Operations is printed to the console
    - Else it parses the args as a single Operation
        - The Operation's result is printed to the console
- Else a usage guide is printed to the console
