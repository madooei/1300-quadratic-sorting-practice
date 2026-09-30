# Quadratic Sorting — Practice

Two practice problems. `BinaryInsertionSort` finds each key's insertion point with binary search and then shifts to open a gap for it. `CocktailShakerSort` is bubble sort that alternates direction, so a small element near the end reaches the front in one backward pass.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      practice/
        BinaryInsertionSort.java        # insertion sort with a binary-search insertion point
        CocktailShakerSort.java         # bidirectional bubble sort with early termination
    test/
      practice/
        BinaryInsertionSortTest.java
        CocktailShakerSortTest.java
  scripts/
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.CocktailShakerSortTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the other is still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `practice.BinaryInsertionSort` — `insertionSort`, built from two private helpers: `insertionPosition` finds where the key belongs by binary search, placing an equal key after existing equals, and `shiftRight` opens a slot for it.
- `practice.CocktailShakerSort` — `cocktailShakerSort`, which alternates a forward pass that settles the largest remaining element at the end with a backward pass that settles the smallest at the front, and stops after a pass that swaps nothing.
- `practice.BinaryInsertionSortTest` — the scenarios for `insertionPosition` and `shiftRight`, then the scenarios for the sort. The two helpers are private, so the tests call them through reflection. The tests find each helper by its name and its `(int[], int, int)` parameters, so keep both as given.
- `practice.CocktailShakerSortTest` — the scenarios for the sort, including the two nearly sorted arrays from the chapter.
