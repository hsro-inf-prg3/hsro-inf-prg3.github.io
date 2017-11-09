# Programmieren 3


_Required class for [CS majors](https://www.fh-rosenheim.de/technik/informatik-mathematik/informatik-bachelor/) at the [University of Applied Sciences Rosenheim](https://www.fh-rosenheim.de). --- Pflichtmodul im [Bachelorstudiengang Informatik](https://www.fh-rosenheim.de/technik/informatik-mathematik/informatik-bachelor/) an der [Hochschule Rosenheim](https://www.fh-rosenheim.de)._


## Class Schedule

**Lecture**: Wednesdays at 8a

**Tutorials**: Wednesdays at 9.45a/11.45a/1.45p; adjunct lecturer: Peter Kurfer

**Comunication** via [Mattermost](https://inf-mattermost.fh-rosenheim.de/inf-prg3/channels/town-square) ([invite](https://inf-mattermost.fh-rosenheim.de/signup_user_complete/?id=c8n9474tq3dm8mjn7cse1xsesa)).

_Note: Materials will be in English, the lectures/tutorials will be taught in German; the written exam will be bilingual (use the language of your choice)._


## Class and Credits (_Leistungsnachweis_)
Lectures: Not your classic lecture--- we'll work together on concrete problems and their solution. The class will be taught in German, the materials are mostly in English.

Tutorials and assignments: Pairprogramming preferred, [_BYOD_](https://en.wikipedia.org/wiki/Bring_your_own_device) strongly recommended!

Credits: written exam (90') at the end of the semester.


## Recommended Textbooks
- Bloch: [Effective Java](https://www.amazon.de/Effective-Java-2nd-Programming-Language/dp/0321356683/)
- Oaks: [Java Performance](https://www.amazon.de/Java-Performance-The-Definitive-Guide/dp/1449358454/)
- Gamma _et al._: [Design Patterns](https://www.amazon.de/Patterns-Elements-Reusable-Object-Oriented-Software/dp/0201633612/)
- Subramaniam: [Functional Programming in Java](https://www.amazon.de/Functional-Programming-Java-Harnessing-Expressions/dp/1937785467/)
- Siedersleben: [Moderne Softwarearchitektur](https://www.amazon.de/Moderne-Software-Architektur-Umsichtig-planen-robust/dp/3898642925/)


## Syllabus
- **Introduction (Oct 4, [slides](/01s-intro/), [assignments](https://github.com/hsro-inf-prg3/01-tools/))**
	
	With a few examples we dig right into the necessary tools of a (Java) software engineer: Git, IntelliJ, and of course: [Google](https://www.google.com), [SO](https://www.stackoverflow.com) and the [Java docs](http://docs.oracle.com/javase/8/docs/).

- **Classes and Interfaces revisited (Oct 11, [slides](/02s-classes-interfaces/), [lecture notes](/02ln-classes-interfaces/), [assignments](https://github.com/hsro-inf-prg3/02-classes-interfaces/))**
	
	We look at different types of classes (inner, anonymous, local, static), when to use them, and which visibility for which purpose.
	Also: `@FunctionalInterface` and lambda expressions.

- **Inheritance revisited (Oct 18, [slides](/03s-inheritance/), [lecture notes](/03ln-inheritance/), [assignments](https://github.com/hsro-inf-prg3/03-inheritance))**
	
	We talk about abstract and final classes, (pure) virtual functions and defaults.
	Also, when (and how) to use abstract base classes, and how the Decorator pattern can be used to add functionality to existing classes.

- **Generics, pt. 1 (Oct 25, [slides](/04s-generics-1/), [lecture notes](/04ln-generics-1/), [assignments](https://github.com/hsro-inf-prg3/04-generics))**
	
	We dig into the details of how generics work in Java, and how to apply them to data structures and algorithms.

> No class and assignments on Nov 1 (All Saints/Allerheiligen).

- **Generics, pt. 2(Nov 8, [slides](/05s-generics-2/), [lecture notes](/05ln-generics-2/), [assignments](https://github.com/hsro-inf-prg3/05-generic-bounds))**
	
	Generics and inheritance need special attention, and will lead us to bounds and wildcards.

- **Annotations and Reflection (Nov 15)**
	
	Learn how annotations and reflection work using examples of serialization (with [gson](https://github.com/google/gson)) and networking ([retrofit](https://github.com/square/retrofit)).

- **Design patterns, pt. 1 (Nov 22)**

	We begin with a few basic patterns: composite, iterator and observer, and use that to dive into Android and MVC/MVVC.

- **Design patterns, pt. 2 (Nov 29)**

	We look at more every-day-patterns: singleton, factory, strategy and visitor.

- **Design patterns, pt. 3 (Dec 6)**
	
	We round up a few more useful patterns: proxy and adapter to make other peoples' modules fit your needs, and flyweight to save on precious memory in (mostly) graphical apps.

- **Parallel processing, pt. 1 (Dec 13)**

	Because sometimes, you need to work more than one thing at a time!
	We'll talk about threads and concurrency when it comes to resources.

- **Parallel proccessing, pt. 2 (Dec 20)**
	
	`Thread`s are clunky--- learn about a better `Future`, and what _promise chaining_ can do for you.

- **Introduction to functional programming (Jan 10)**
	
	Leave your imperative and objected oriented programming comfort zone and follow me down the rabbit hole of functional programming.

- **Functional programming in Java (Jan 17)**

	We talk about the specifics (and limits) of functional programming in Java.
	Learn about the basic `filter`-`map`-`reduce` and more sophisticated ones such as `collect` and `groupingBy`.

- **Review (Jan 24)**

	_TBA_.

## Additionals

- [UML/PlantUML guide](./plantuml-guide)

_Subscribe to [https://github.com/hsro-inf-prg3/hsro-inf-prg3.github.io](https://github.com/hsro-inf-prg3) repository to follow updates._
