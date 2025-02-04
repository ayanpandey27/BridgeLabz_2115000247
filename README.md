# BridgeLabz_2115000247


Java OOP Concepts - README
Introduction
This project explores essential Java Object-Oriented Programming (OOP) concepts, including the use of:

this keyword
static keyword
final keyword
instanceof operator
These concepts are fundamental in managing object behavior, memory usage, and inheritance.

1. this Keyword
The this keyword refers to the current object within a class.
It resolves ambiguity when method parameters have the same name as instance variables.
It's used to call other constructors (constructor chaining) and methods from within the class.
2. static Keyword
Static variables are shared across all instances of a class, meaning they hold a single value for all objects of that class.
Static methods belong to the class itself, not individual instances, and can be called without creating an object.
Static blocks are used to initialize static variables when the class is loaded.
Static nested classes do not require an instance of the outer class to be created.
3. final Keyword
Final variables cannot be reassigned once initialized.
Final methods cannot be overridden by subclasses.
Final classes cannot be subclassed, ensuring they remain unchanged.
4. instanceof Operator
The instanceof operator is used to check if an object is an instance of a particular class or subclass.
It helps avoid casting errors and is useful in polymorphism scenarios to validate the object's type.
