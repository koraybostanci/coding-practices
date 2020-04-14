# __Stacks & Queues__

## __Stack__

* uses Last-In-First-Out ordering
* like a stack of dinner plates, the most recent one added to the stack will be the first to be removed

_**Operations**_

* push(item) : add item to the top of the stack
* pop()      : remove the top item from the stack
* peek()     : return the top of the stack
* isEmpty()  : return true if the stack is empty

_**Complexity**_

* add/remove O(1), does not require to shift any item

## __Queue__

* uses First-In-Last-Out ordering
* like a line or a queue in ticket stand, items are removed from the data structure that they are added
* can be implemented using a linkedlist
* often used in Bread-First-Search or in implementing a cache

_**Operations**_

* add(item)  : add item to the end of the queue
* remove()   : remove the first item in the queue
* peek()     : return the top of the queue
* isEmpty()  : return true if the queue is empty