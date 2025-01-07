# jlox - A Java Implementation of the Lox Language

This repository contains the `jlox` interpreter for the Lox programming language, built in Java as described in Robert Nystrom's book *Crafting Interpreters*. The project walks through the construction of a complete interpreter, chapter by chapter, starting with basic concepts and culminating in a working implementation of the Lox language.

---

## 📚 About the Project

Lox is a dynamically typed, garbage-collected, object-oriented programming language designed for simplicity and expressiveness. This repository implements the *tree-walk interpreter* described in the book.

The `jlox` interpreter handles the Lox syntax, including expressions, statements, and control flow, while supporting features like scoping, functions, and classes.

---

## 🛠️ Features

### Current Capabilities:
- Tokenization (Lexical Analysis)
- Recursive Descent Parsing
- Expression Evaluation
- Syntax Error Reporting
- Dynamic Typing with Runtime Value Evaluation

### Future Milestones:
- Variables and Scopes
- Functions (with Closures)
- Object-Oriented Programming Features (Classes, Methods)
- Advanced Error Handling and Recovery
- Optimizations for Tree-Walk Interpreters

---

## 🚀 Getting Started

### Prerequisites
- **Java Development Kit (JDK)** version 8 or later.
- A code editor or IDE (e.g., IntelliJ IDEA, VS Code).

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/jlox.git
   cd jlox
    ```
2. Navigate to the `src` and compile the code:
    ```bash
    javac com/ntsiris/lox/*.java
    ```
3. Run the interpreter:
   ```bash
    java com.ntsiris.lox.Lox
   ```
4. Optionally, execute Lox scripts:
   ```bash
    java com.ntsiris.lox.Lox path/to/your-script.lox
   ```


## 🛠️ Project Structure
```bash
    jlox/
    ├── src/                         # Source code for the interpreter
    │   ├── com/ntsiris/lox/
    │   │   ├── Lox.java             # Main entry point
    │   │   ├── Scanner.java         # Lexical analyzer
    │   │   ├── Token.java           # Token representation
    │   │   ├── TokenType.java       # Enum for token types
    │   │   ├── Expr.java            # Expression AST definitions
    │   │   ├── Parser.java          # Recursive descent parser
    │   │   └── AstPrinter.java      # Utility for printing ASTs (optional)
    ├── .gitignore                   # Ignored files
    └── README.md                    # Documentation
```
## 🔑 Usage
The jlox interpreter can be used in interactive mode or to execute .lox scripts.

### Interactive Mode
Run the interpreter without any arguments to enter a REPL (Read-Eval-Print Loop):
```bash
    java com.craftinginterpreters.lox.Lox
```
You can type and execute Lox code interactively.

### Running Lox Scripts
To execute a Lox script, pass the file path as an argument:
```bash
    java com.craftinginterpreters.lox.Lox examples/hello.lox
```

## Example Lox Code
Here’s a simple Lox script:
```shell
// Hello World
print "Hello, World!";

// Arithmetic operations
print 5 + 3 * (2 - 1);

// Comparison
print 10 > 5 and 5 <= 5;

// Grouping
print (3 + 5) / 2;

```
## 📜 Implementation Progress
This implementation follows the book's structure chapter by chapter:

## Completed Chapters:
- Introduction: Project setup and goals.
- A Tree-Walk Interpreter: Overview of tree-walk interpreters.
- Scanning: Implemented lexical analysis to tokenize input.
- Parsing Expressions: Built a recursive descent parser for expressions.
## Next Steps:
- Representing Code: Add AST (Abstract Syntax Tree) representation for statements.
- Evaluating Statements: Enable statement execution.
- Control Flow: Implement branching and looping constructs.
- Functions and Closures: Support first-class functions.
- Classes and Objects: Add OOP support with inheritance.

## 🔗 Resources
- [Crafting Interpreters Book](https://craftinginterpreters.com/)
- [Java Documentation](https://docs.oracle.com/javase/8/docs/)