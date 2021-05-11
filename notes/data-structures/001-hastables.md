# __Hashtable__

* a data structure that maps keys to values

**put(key,value)**

* compute the key's hashcode with a hash function
* compute the index in the array from hashcode
* add the key-value to the linked-list in that index of array

**get(key)**

* compute the key's hashcode with a hash function
* compute the index in the array from hashcode (hashcode % arrayLength)
* search through the linked list for the value with the key

* if the number of collisions is very high, the worst case runtime is O(N).
* generally lookup time will be O(1) with a good implementation that keeps collision minimum.
