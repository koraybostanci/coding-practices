package com.coding.practicemakesperfect.crackingthecodinginterview.chapter3_stacksandqueues;

import com.coding.practicemakesperfect.practice.datastructures.queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest"(based on arrival time) of
 * all animals at the shelter, or they can select whether they would prefer a dog or a cat
 * (and will receive the oldest animal of that type). They cannot select which specific animal
 * they would like.
 *
 * Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
 *
 * You may use the built-in LinkedList data structure.
 */
public class P06_AnimalShelter {

    abstract class Animal implements Comparable<Animal> {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Animal o) {
            return o.getId() - this.id;
        }
    }

    class Dog extends Animal {
    }

    class Cat extends Animal {
    }

    class AnimalShelter {
        private final Queue<Animal> dogQueue;
        private final Queue<Animal> catQueue;
        private int id = 0;

        public AnimalShelter() {
            dogQueue = new Queue<>();
            catQueue = new Queue<>();
        }

        public void enqueue(Animal animal) {
            if (animal == null) {
                return;
            }

            animal.setId(id);
            id++;

            if (animal instanceof Dog) {
                dogQueue.add(animal);
            } else if (animal instanceof Cat) {
                catQueue.add(animal);
            }
        }

        public Animal dequeueAny() {
            if (dogQueue.isEmpty()) {
                return dequeueCat();
            } else if (catQueue.isEmpty()) {
                return dequeueDog();
            }

            Animal dog = dogQueue.peek();
            Animal cat = catQueue.peek();
            return dog.compareTo(cat) > 0 ? dequeueDog() : dequeueCat();
        }

        public Animal dequeueDog() {
            return dogQueue.remove();
        }

        public Animal dequeueCat() {
            return catQueue.remove();
        }

    }

    @Test
    public void test() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Dog());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());

        Animal animal = shelter.dequeueAny();
        Assertions.assertTrue((animal instanceof Dog));

        animal = shelter.dequeueCat();
        Assertions.assertTrue((animal instanceof Cat));

        animal = shelter.dequeueDog();
        Assertions.assertTrue((animal instanceof Dog));

        animal = shelter.dequeueAny();
        Assertions.assertTrue((animal instanceof Dog));
    }
}
