<h1>Java Fundamentals Proyect</h1>

- A repository dedicated to demonstrating technical mastery of Java (SE) fundamentals,
focusing on best practices, clean code, and performance.

- In this proyect, my objetive is to learn while i code until i dominate all the fundamentals of Java.

- I have created milestones and issues for all the pending tasks in this repository 

- I would appreciate any advice or recommendations on how to expand both my knowledge and my portfolio in this area.

<h2>Thanks in advance! 😃❤️</h2>

<br>

# 01 | Basics

<h3>Essential concepts of Java</h3>

| File | Content |
|---|---|
| [`Variables.java`](src/main/java/basics/Variables.java) | Declaration, initialization, constants (`final`), casting, variable scope |
| [`DataTypes.java`](src/main/java/basics/DataTypes.java) | Primitive types (`byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`) and `String` |
| [`Operators.java`](src/main/java/basics/Operators.java) | Arithmetic, relational, logical, assignment, and ternary operators |
| [`ControlFlow.java`](src/main/java/basics/ControlFlow.java) | `if/else`, `switch` (classic and expression), `for`, `for-each`, `while`, `do-while`, `break`/`continue` |
| [`Arrays.java`](src/main/java/basics/Arrays.java) | One-dimensional arrays and matrices (2D), iteration, sorting, searching |
| [`Methods.java`](src/main/java/basics/Methods.java) | Methods, parameters, overloading, recursion, varargs |

<br>

# 02 | Object-Oriented Programming (OOP)

<h3>The pillars of OOP in Java, with independent and executable examples</h3>

| File | Concept | Content |
|---|---|---|
| [`Classes.java`](src/main/java/oop/Classes.java) | Classes and objects | Attributes, constructor, `this`, methods |
| [`Encapsulation.java`](src/main/java/oop/Encapsulation.java) | Encapsulation | Private attributes, getters/setters, internal state protection |
| [`Inheritance.java`](src/main/java/oop/Inheritance.java) | Inheritance | `extends`, `super`, code reusability, `@Override` |
| [`Polymorphism.java`](src/main/java/oop/Polymorphism.java) | Polymorphism | Dynamic dispatch, superclass references pointing to subclasses |
| [`Interfaces.java`](src/main/java/oop/Interfaces.java) | Interfaces | Contracts, multiple interfaces, `default` methods, lambdas |
| [`AbstractClasses.java`](src/main/java/oop/AbstractClasses.java) | Abstract classes | Abstract vs. concrete methods, non-instantiable |

<br>

# 03 | Collections (Java Collections Framework)

<h3>Standard data structures for storing and manipulating groups of objects</h3>

| File | Content |
|---|---|
| [`ListsExample.java`](src/main/java/collections/ListsExample.java) | `ArrayList` and `LinkedList`: add, insert, remove, iterate / traverse |
| [`SetsExample.java`](src/main/java/collections/SetsExample.java) | `HashSet` (no duplicates, unordered) and `TreeSet` (sorted) |
| [`MapsExample.java`](src/main/java/collections/MapsExample.java) | `HashMap` and `TreeMap`: key-value pairs, `getOrDefault`, iteration / traversal |
| [`ComparatorsExample.java`](src/main/java/collections/ComparatorsExample.java) | `Comparable` (natural ordering) vs. `Comparator` (external/custom ordering) |

<br>

# 04 | Exception Handling

<h3>Managing runtime errors in a controlled manner</h3>

| File | Content |
|---|---|
| [`ExceptionHandling.java`](src/main/java/exceptions/ExceptionHandling.java) | `try/catch/finally`, multiple `catch` blocks, common exceptions (`ArithmeticException`, `NullPointerException`, etc.) |
| [`CustomExceptions.java`](src/main/java/exceptions/CustomExceptions.java) | Custom exceptions: *checked* (`extends Exception`) vs. *unchecked* (`extends RuntimeException`) |
| [`TryWithResources.java`](src/main/java/exceptions/TryWithResources.java) | Automatic resource management using `try-with-resources` and `AutoCloseable` |

<br>

# 05 | Lambdas and Streams (Modern Java)

<h3>Functional programming (introduced in Java 8+), lambda expressions and the Streams API</h3>

| File | Content |
|---|---|
| [`LambdasBasics.java`](src/main/java/functional/LambdasBasics.java) | Functional interfaces: `Function`, `BiFunction`, `Predicate`, `Supplier`, `Runnable`, method references |
| [`StreamsBasics.java`](src/main/java/functional/StreamsBasics.java) | `filter`, `map`, `forEach`, `collect`, `count`, `anyMatch`, `allMatch` |
| [`AdvancedStreams.java`](src/main/java/functional/AdvancedStreams.java) | `reduce`, `groupingBy`, `sorted` with `Comparator`, statistics, `IntStream` |

<br>

# 06 | Algorithms

<h3>Clear and fully commented implementations of the algorithms that appear most often in classic programming problems</h3>

## Sorting

| File | Algorithm | Complexity |
|---|---|---|
| [`BubbleSort.java`](src/main/java/algorithms/sorting/BubbleSort.java) | Bubble Sort | O(n²) |
| [`QuickSort.java`](src/main/java/algorithms/sorting/QuickSort.java) | Quick Sort (divide and conquer) | O(n log n) average |
| [`MergeSort.java`](src/main/java/algorithms/sorting/MergeSort.java) | Merge Sort (stable) | O(n log n) guaranteed |

## Search

| File | Algorithm | Complexity |
|---|---|---|
| [`BinarySearch.java`](src/main/java/algorithms/search/BinarySearch.java) | Binary Search (iterative and recursive) | O(log n) |

## Recursion

| File | Algorithm | Complexity |
|---|---|---|
| [`Fibonacci.java`](src/main/java/algorithms/recursion/Fibonacci.java) | Fibonacci: recursive, memoized, and iterative | O(2ⁿ) / O(n) / O(n) |
| [`Factorial.java`](src/main/java/algorithms/recursion/Factorial.java) | Factorial: recursive and iterative | O(n) |

## Dynamic Programming

| File | Algorithm | Complexity |
|---|---|---|
| [`Knapsack01.java`](src/main/java/algorithms/dynamic_programming/Knapsack01.java) | 0/1 Knapsack Problem | O(n × capacity) |
| [`LongestCommonSubsequence.java`](src/main/java/algorithms/dynamic_programming/LongestCommonSubsequence.java) | Longest Common Subsequence (LCS) | O(n × m) |

## Graphs

| File | Algorithm | Complexity |
|---|---|---|
| [`BFS.java`](src/main/java/algorithms/graphs/BFS.java) | Breadth-First Search (queue-based) | O(V + E) |
| [`DFS.java`](src/main/java/algorithms/graphs/DFS.java) | Depth-First Search (recursive and iterative) | O(V + E) |

## Classic Algorithms

| File | Algorithm | Description |
|---|---|---|
| [`FizzBuzz.java`](src/main/java/algorithms/classics/FizzBuzz.java) | FizzBuzz | The classic screening filter |
| [`PrimeNumbers.java`](src/main/java/algorithms/classics/PrimeNumbers.java) | Prime Verification + Sieve of Eratosthenes | O(√n) and O(n log log n) |
| [`Palindrome.java`](src/main/java/algorithms/classics/Palindrome.java) | Palindrome Check (two pointers approach) | O(n) |
| [`ReverseString.java`](src/main/java/algorithms/classics/ReverseString.java) | Reverse a String (manual and recursive) | O(n) |
| [`TwoSum.java`](src/main/java/algorithms/classics/TwoSum.java) | Two Sum: brute force vs. HashMap | O(n²) vs. O(n) |

<br>

# ꧁⎝ ON PROCESS 😄 ⎠꧂ 

<h3>If someone has more ideas to expand my project I will apreciate it! :p
I’ll keep adding more things and learning as I continue working on this repository ^^</h3>
