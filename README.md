# BridgeLabz_2115000247
Java Access Modifiers - README
Introduction
In Java, access modifiers are used to define the visibility and accessibility of classes, methods, and variables. They control how other parts of a program can interact with different members of a class. The four main access modifiers in Java are:

public
protected
default (no modifier)
private
Each modifier defines different levels of access control.

1. public Access Modifier
The public modifier allows members to be accessible from anywhere in the program, whether it’s within the same package or from other packages.
It provides the highest level of accessibility.
When to Use:
When you want to allow global access to a variable or method.
2. protected Access Modifier
The protected modifier allows access to members within the same package and also to subclasses (even if they are in different packages).
It restricts access to only those classes that inherit from the class or are in the same package.
When to Use:
When you want members to be available within the same package or to subclasses, while limiting access from other classes.
3. default (Package-Private)
If no access modifier is specified, it is considered default (also known as package-private).
The member is only accessible within its own package.
Default access offers more restricted access than protected but less than private.
When to Use:
When you want a member to be accessible only within the same package and not from outside.
4. private Access Modifier
The private modifier restricts access to the class’s members, making them accessible only within the same class.
It provides the highest level of encapsulation, ensuring that no external code can access or modify these members directly.
When to Use:
When you want to encapsulate the internal workings of a class and prevent external interference.
Summary of Access Modifiers
Modifier	Same Class	Same Package	Subclass (Different Package)	Other Packages
public	Yes	Yes	Yes	Yes
protected	Yes	Yes	Yes	No
default	Yes	Yes	No	No
private	Yes	No	No	No
Best Practices
Use private for variables and methods that should not be accessed directly from outside the class, ensuring encapsulation.
Use public for methods that are part of the API and need to be accessed from outside the class.
Use protected when you want to allow subclasses or classes in the same package to access the member.
Avoid unnecessary exposure of class members; try to use the least permissive access level.
