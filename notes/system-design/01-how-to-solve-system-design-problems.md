# How to Solve System Design Problems

## __1. Outline use cases, constraints, and assumptions__

Just like algorithm design, system design questions will also most likely be weakly defined.
There are so many things that are unclear about it! Without knowing more, it will be impossible to design an appropriate solution.

The very first thing you should do with any system design question is to clarify the system's constraints and to identify what use cases the system needs to satisfy. Spend a few minutes questioning your interviewer and agreeing on the scope of the system.

Usually, part of what the interviewer wants to see is if you can gather the requirements about the problem at hand, and design a solution that covers them well. Never assume things that were not explicitly stated.

You will also have to think about the use cases that are expected to occur. Your system will be designed based on what it's expected to do. Don't forget to make sure you know all the requirements the interviewer didn't tell you about in the beginning.

Gather requirements and scope the problem. Ask questions to clarify use cases and constraints. Discuss assumptions.

Traffic?
Data size?
Write-Heavy or Read-Heavy?

* Who is going to use it?
* How are they going to use it?
* How many users are there?
* What does the system do?
* What are the inputs and outputs of the system?
* How much data do we expect to handle?
* How many requests per second do we expect?
* What is the expected read to write ratio?

## __2. Create a high level abtract design__

The goal of this is to outline all the important components that your architecture will need.
Sketch your main components and the connections between them.
Justify your ideas in front of the interviewer and try to address every constraint and use case.

Outline a high level design with all important components.

* Sketch the main components and connections
* Justify your ideas

Your high-level design will have one or more bottlenecks given the constraints of the problem. This is perfectly ok. You are not expected to design a system from the ground up, which immediately handles all the load in the world. It just needs to be scalable, in order for you to be able to improve it using some standard tools and techniques.

Usually each solution is a trade-off of some kind. Changing something will worsen something else. However, the important thing is to be able to talk about these trade-offs, and to measure their impact on the system given the constraints and use cases defined.

## __3. Design core components__

Dive into details for each core component. For example, if you were asked to design a url shortening service, discuss:

* Generating and storing a hash of the full url
* MD5 and Base62
* Hash collisions
* SQL or NoSQL
* Database schema
* Translating a hashed url to the full url
* Database lookup
* API and object-oriented design

## __4. Scale the design__

Identify and address bottlenecks, given the constraints. For example, do you need the following to address scalability issues?

* Load balancer
* Horizontal scaling
* Caching
* Database sharding
* Discuss potential solutions and trade-offs. Everything is a trade-off. Address bottlenecks using principles of scalable system design.

## __Summary__

1. __Scope the problem__: Don't make assumptions. Ask questions. Understand the constraints and use cases.
2. Sketch up an __abstract design__ that illustrates the basic components of the system and the relationships between them.
3. Think about the __bottlenecks__ these components face when the system scales.
4. Address these bottlenecks by using the fundamentals principles of __scalable system design__.