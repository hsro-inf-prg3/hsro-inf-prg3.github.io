---
title: "Functional Programming in Java"
permalink: /13ln-fp2/
---

forEach: `Consumer`
filter: `Predicate`
map: `Function`

# Reduction

<https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html>

- forEach as special case
- reduce

## Left-Fold

- reduce as foldLeft

## Right-Fold

- append as foldRight


# Advanced Stream Operations in Java

Generators, where to get the streams?

## Intermediate and Terminal Operations

<https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps>

### Intermediate
filter, map, sorted, distinct

### Terminal
forEach, reduce, collect (groupingBy)


- reduce: erst konkret, dann mit [BinaryOperator](https://docs.oracle.com/javase/9/docs/api/java/util/function/BinaryOperator.html) bzw. [BiFunction](https://docs.oracle.com/javase/9/docs/api/java/util/function/BiFunction.html) [BiCombiner](https://docs.oracle.com/javase/9/docs/api/java/util/function/BiCombiner.html)
- `Optional`, `findAny()` findFirst
- `collect()`
- `flatMap()` (?)
- `groupingBy()`

# More Syntactic Sugar

## Parallel Processing

https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html
