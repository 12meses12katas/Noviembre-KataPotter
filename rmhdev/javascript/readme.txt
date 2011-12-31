Kata: "Kata Potter"

12 Meses, 12 Katas (Nov-2011)

Developed in Javascript, tested with Google JS Test

http://code.google.com/p/google-js-test

* How to run the tests:
  gjstest --js_files=namespace.js,kataPotter.js,kataPotterTest.js

* Notes about the kata.

Before i started testing the edge cases, my solution was:

    "Find the FIRST correct group in the basket for this book"

The "Edge case" forced me to change it to:

    "Find the BEST correct group in the basket for this book"

I'l explain you my solution with the next example.

Situation:

 - Actual Basket:
    group(0): [0, 1, 2, 3]
    group(1): [0, 1, 2]
 - Next book to add: "4".

I need to add the book "4" to one of those groups. But, which one?
The solution is to add the book to every group, calculate the prices and then
select the basket with the lowest price.

In this example:

A) Basket:
    group(0): [0, 1, 2, 3, 4]   (8 * 5 * 0.75)
    group(1): [0, 1, 2]         (8 * 3 * 0.9)

The price is 51.6

B) Basket:
    group(0): [0, 1, 2, 3]      (8 * 4 * 0.8)
    group(1): [0, 1, 2, 4]      (8 * 4 * 0.8)

The price is 51.2

So the best situation is the "B".