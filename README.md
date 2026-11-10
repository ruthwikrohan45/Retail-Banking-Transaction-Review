# Retail Banking Transaction Review System

## Project Overview

This project implements fundamental Data Structures and Algorithms (DSA) concepts using Java for a retail banking transaction review system.

The system demonstrates how banking operations can search transactions, sort customer statements, detect duplicate postings, manage review queues and find transaction amount limits efficiently.

## Technologies Used

- Programming Language: Java
- IDE: IntelliJ IDEA
- Data Format: CSV
- Version Control: Git and GitHub

## Project Structure

```text
Retail-Banking-Transaction-Review/
│
├── Data/
│   └── transactions.csv
│
├── src/
│   ├── Main.java
│   ├── Transaction.java
│   ├── Task1_Searching.java
│   ├── Task2_Sorting.java
│   ├── Task3_DuplicateDetection.java
│   ├── Task4_StackQueue.java
│   └── Task5_MinMax.java
│
└── README.md
```

## Tasks Implemented

### Task 1 – Searching Algorithms

Implemented:
- Linear Search
- Binary Search
- Comparison counting for best, average and worst cases
- Performance comparison using 100,000 transaction IDs

Binary Search requires sorted data and is more efficient for large datasets.

### Task 2 – Sorting Algorithms

Implemented:
- Insertion Sort
- Merge Sort
- Sorting transactions by posting date
- Stability demonstration
- Execution-time measurement

Both algorithms preserve the relative order of transactions having equal timestamps.

### Task 3 – Duplicate Transaction Detection

Implemented duplicate detection using HashMap.

Duplicate conditions:
- Same account ID
- Same transaction amount
- Same merchant
- Time difference within 60 seconds

### Task 4 – Stack and Queue

Implemented:
- Custom Queue using arrays
- Custom Stack using arrays
- Built-in Queue using ArrayDeque
- Built-in Stack using Deque

Applications:
- Queue: Manual transaction review backlog (FIFO).
- Stack: Reverse last adjustment (LIFO).

### Task 5 – Divide and Conquer

Implemented:
- Brute-force minimum and maximum search
- Divide-and-conquer minimum and maximum search
- Execution-time comparison

## Time and Space Complexity

| Algorithm | Best | Average | Worst | Auxiliary Space |
|---|---|---|---|---|
| Linear Search | O(1) | O(n) | O(n) | O(1) |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) |
| HashMap Duplicate Detection | Expected O(n) total | Expected O(n) total | O(n²) worst case | O(n) |
| Stack Operations | O(1) | O(1) | O(1) | O(n) capacity |
| Queue Operations | O(1) | O(1) | O(1) | O(n) capacity |
| Brute Force Min/Max | O(n) | O(n) | O(n) | O(1) |
| Divide and Conquer Min/Max | O(n) | O(n) | O(n) | O(log n) |

## How to Run

1. Install Java JDK.
2. Open the project in IntelliJ IDEA.
3. Open the `src` folder.
4. Run each task independently.

Run the programs:
- Task1_Searching.java
- Task2_Sorting.java
- Task3_DuplicateDetection.java
- Task4_StackQueue.java
- Task5_MinMax.java

Run `Main.java` to read the sample CSV transaction dataset.

## Dataset and Testing Notes

The supplied CSV contains 10 sample transaction records.

Task 1 generates 100,000 sorted transaction IDs programmatically for searching benchmarks.

The other task implementations currently use sample transaction objects or arrays directly in their demonstration code. They can be further integrated with the CSV reader for a fully shared dataset workflow.

The duplicate detection implementation is a basic demonstration using the latest stored matching transaction per key. A production implementation should maintain all relevant transactions within the 60-second window.

## Conclusion

This project demonstrates the practical application of searching, sorting, hashing, stacks, queues and divide-and-conquer algorithms in a retail banking scenario.

It also highlights the importance of algorithm efficiency, time complexity, space complexity and stable sorting in transaction processing.
