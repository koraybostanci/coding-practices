# __Hashtable__

* a data structure that maps keys to values

_**put(key,value)**_

* compute the keys's hashcode with a hashfunction
* compute the index in the array from hashcode
* add the key-value to the linkedlist in that index of array

_**get(key)**_

* compute the keys's hashcode with a hashfunction
* compute the index in the array from hashcode (hashcode % arrayLength)
* search through the linked list for the value with the key

* if the number of collisions is very high, the worst case runtime is O(N).
* generally lookup time will be O(1) with a good implemantation that keeps collision minimum.
