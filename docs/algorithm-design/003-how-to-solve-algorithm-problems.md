# __How to solve algorithmic problems__

## __1. Clarify__

* Do not immediately dive into code.
* Ask clarifying questions in order to understand requirements, constraints and limitations.

  __Ex :__ Design an algorithm that sorts an array.

  __Ask :__
  * What's the size of the array? How large can it be?
  * What are the data types of items in the array?
  * If data type of items in the array is String, then what's the length of items in the array?
  * If data type of items in the array is Numeric, is there any min|max boundary?
  
## __2. Generate ideas__

* Simplify the task : Try to solve the problem as it's more simplified version.
* Try a few examples : Candidates rarely test with examples other than the one given by the interviewer. Sometimes, however, this helps a lot. You may start noticing patterns if you try to solve a few sample inputs that you create. It is ok to tell the interviewer that you would like to try writing down a few examples in order to try to find some pattern. Then do it quickly and see where it leads you.
* Think of suitable data structures : For some problems it is more or less apparent that some sort of data structure will do the job. If you start to get this feeling think about the data structures you know about and try to apply them and see if they fit.

## __3. Evaluate Computational Complexity__

* For every idea you have at an interview, it's super important to be able to evaluate its efficiency. Solving problems is not just about finding a way to compute the correct answer. The solution should work quickly enough and with reasonable memory usage.
* Solution should be good enough in terms of speed and memory.
* You need to be capable of evaluating the time and memory complexity of various algorithmic solutions.

## __4. Start Coding__

* Coding in your IDE is not the same as coding on a whiteboard / a shared document / using some online system (in short: “outside your IDE”) Being able to code on a sheet of paper will not only boost your interviewing skills - it will also make you a better coder overall.
* Think before you code. Especially if you’re coding on a sheet of paper (where there’s no “undo”), if you’re not careful everything could become very messy very quickly.
* Make sure you name your variables properly, indent nicely, write clean code, etc.
* It’s even more important to decompose your code into small logical pieces and NOT copy-paste
* Read your code multiple times before you claim it’s ready. You don’t have the luxury to compile, see if it compiles, run, see if it runs, and then debug for 4 hours. Your code needs to work off the bat.

## __5. Test your code__

* Writing test gives the interviewer confidence that once hired, you’re not going to start writing buggy code and ship it to production, and instead you’re going to write unit tests, review your code, work through example scenarios, etc.
* __"Sample" tests:__ small examples that you can feed to your code, and run through it line by line to make sure it works. The keyword here is "small": not "simple" or "trivial".
* __"Extensive" tests:__ where they ask you to come up with some good test cases for your solution.
* __Edge cases :__ Design cases that make sure the code works when the min and/or max values of the constraints are hit. This includes negative numbers, empty arrays, empty strings, etc.
* __No solution :__ To make sure the code does the right thing
* __Non-trivial functional tests :__ these tests depend very much on the problem. They would test the internal logic of the solution to make sure the algorithm works correctly.
* __Randomized tests:__ this makes sure your code works well in the "average" case, as opposed to only working well on human-generated tests (where there's inherent bias).
* __Load testing :__ Test your code with as much data as allowed by the constraints. These test your code against being very slow or taking up too much memory.

* Typically, we stay away from randomized tests and load tests during interviews, for obvious reasons. Instead, we like choosing a small-scale version of a non-trivial functional test, to make sure the code does the right thing. Then, we look at how the code would react to several edge cases, and finally think about whether the code would work well if no solution can be found.
