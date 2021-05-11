# Dynamic Programming

In short, it's a method, which allows you to solve a problem by breaking it down into smaller sub-problems.

With dynamic programming you will try to identify a way to combine the answers for smaller versions of a problem to compute the answer for a bigger version. If you find such a recurrent dependency you would be able to start with some very trivial cases, which you know the answer to, and subsequently compute the answers of bigger and bigger versions of the problem until you reach the version that you were initially interested in. This method works well if you store the answers for smaller versions of the problem and reuse the computed values when computing for bigger versions of the problem. This technique is called "memoization".

There are usually different ways to implement the computations;

* One would be "bottom-up" where we start from the base cases and compute the values until we reach the desired value.
* Another would be "top-down" in which we recursively compute the answers for smaller problems, on demand, but try to store the computed valued in order not to compute them multiple times. This technique is usually called "memoization".

Sometimes, especially for "bottom-up" implementations it is possible to store only one part of the computed values at a time and free the memory for other parts once they have served their job in the computations.