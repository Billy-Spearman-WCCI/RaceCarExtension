# Glossary

## Tools

* **Markdown**: The format of the source code for this glossary.
* **IDE**: Integrated Development Environment (VSCode, IntelliJ) -- a programming-language-aware text editor.
* **JavaDoc** -- Documentation for each Java class, defining the methods, their parameters, return types, and behavior.
  Adding comments of the form `/** Text describing the method */` just before each method will automatically be
  understood by IntelliJ and is most useful.

## Java

* **object**: a thing encapsulating data (in "instance fields") and behavior (in "methods")
    * `this` -- the syntax to access **Instance fields**
    * `class`: The definition of the data and/or behavior of its instances.
    * `new`: Creates an object of the specified class. `new` can only be called on non-abstract classes. It cannot be
      called on abstract classes or interfaces themselves.
    * **constructor**: A method which runs when an object is created and sets its initial state.
    * `static`: Data and behavior (i.e. fields and methods) encapsulated by the class itself, rather than any particular
      instance. **Usually** a code smell. `System.in` and `System.out` are static fields of `System`. Static methods
      cannot access `this`.
* **Type**: what data may be stored in a variable or parameter. May be a primitive type, a `class`, or `interface`.
    * **Primitive Type** -- Non-objects in Java
        * `boolean` : `true` or `false`. Note that this is the only value allowed in `if ()`.
        * `byte` : In Java, this has values -128..127. In the sane world, it has values 0..255. Consists of 8 **bits**.
        * `char`: Two bytes in size, encodes the first 60000 or so **Unicode** characters. During American hegemony,
          ASCII used one byte (especially 0..127) to represent common characters.
        * `float`: A floating-point number. Rarely used, since memory is so cheap. Prefer `double`
        * `int`: Four bytes in size, so can go from -2Billion to 2Billion. Fine for indices and small numbers.
        * `long`: Eight bytes in size, so big enough for most purposes.
        * `short`: Two bytes in size, so useful when you *know* that you're dealing with values <30000 or so.
        * `double`. A more precise floating-point number. But floating-point is dark magic nobody understands. If you
          need exact decimals, use `BigDecimal`.
        * Most operators only act upon primitive values, though Java does special things behind-the-scenes for String
          values.
    * **Type safety** -- Java won't compile if you try to write an incompatible value to a variable.
* **method**: A function defined within a class. In java, all functions are defined within classes.
    * **code block** -- one or more statements surrounded by curly braces `{` ... `}`.
    * **nesting** -- when one code block has sub-code-blocks within it.
    * **parameters** -- the actual values passed to a method or constructor.
    * **variable** -- a placeholder defined within a method ... available within the block but not outside.
    * `return`: Exit the current method. If the method returns a value, specifies the value to return.
    * **signature**: The definition of the types of the parameters a method accepts and the type of the value the method
      returns. Also, what types of Exceptions it might throw.
    * `void`: Indicates that the call to a method does not result in a value.
    * **call stack**: The current method, the method from which it is called, the method from which that was called, and
      all the way up to the `main()` method.
* `interface`: a list of promised behaviors (i.e. a list of methods -- but without implementations)
    * `implements`: an assertion by a class that it implements all promised behaviors of an interface.

## Programming styles

* **OO** -- An Object-Oriented programming style
    * **abstraction**: separating what's essential for a particular use from what isn't.
    * **polymorphism**: the Race class can call `contestant.turn()` and Java will ensure that the right method is
      called, depending upon the *actual* class of the object implementing Contestant.
    * **inheritance**: when one class extends another.
    * **encapsulation**: when a RaceCar contains an Odometer rather than trying to do that behavior
      itself https://github.com/marshallfWCCI/RaceCarInterface/commit/92e8da66095290ebdb11e4e53e04cede7639f787
* **Imperative** -- A programming style in which the system is told what to do step-by-step.
* **Declarative** -- A programming style in which the system is told the desired state and isn't micromanaged in the
  executed. `build.gradle` is declarative.
* **Structured** -- An imperative programming style in which statements are organized into nesting contexts.

## More Java keywords

* `@Override` is an example of an **annotation**. `@Override` identifies when a method is either required by an
  interface or redefines an existing method (this case we'll talk about tomorrow)
* **Instance variables** -- the fields you've seen belonging to object instances.  (There is also a concept of **class
  variable** which should only be used in very specific instances, which we might not even encounter this course.)
* `extends` -- A **subclass** `extend`s another `class`. If we tell Java that C extends B and B extends A, then C
  extends A (even if we don't explicitly say so).
* `super()` -- The first line of most constructor will be to call the constructor of its parent class.
* `abstract` -- A class which has partially-defined behavior and so cannot have instances. But it will have **concrete**
  subclasses which may create instances.
* **Class Hierarchy** -- a diagram showing which classes extend and/or implement other classes and interfaces. For
  instance, https://en.wikipedia.org/wiki/Java_collections_framework#/media/File:Java.util.Collection_hierarchy.svg
* Visibility (of data and behavior)
    * `final` -- Write-once. May not be modified after it is set.
    * `private` -- Only visible within the defining class.
    * `protected` -- Only visible within the defining class and its subclasses.
    * `public` -- Visible everywhere
* `package` -- The directory where the class is defined. Code in `src/main/java/org/wcci/marshall/project1`
  and `src/test/java/org/wcci/marshall/project1/` lie in package `org.wcci.marshall.project1`. Many core classes lie in
  subpackages of `java`, e.g. `java.util`.
    * `import` -- Having `import java.util.ArrayList` or `import java.util.*` at the top of a source file allows one to
      type `new ArrayList()` rather than `new java.util.ArrayList()`. If no import applies and the full path of the
      class isn't specified, then Java defaults to only seeing classes in the current package.
    * **package visibility** -- If neither `private`, `protected`, nor `public` are specified, then the visibility
      extends to everything in the same package. Don't do this.
* `Exception` -- stop the execution of the code...something unexpected has happened. An instance of the `Exception`
  class (or its subclasses) is passed up the call stack.
    * `throws` -- A method signature may also specify that the method may throw one or more subclasses of `Exception`.
    * `try {} catch (Exception e) {}` block -- code that is prepared to handle a thrown exception and decide what should
      happen next.  (If the exception occurs while trying to read a number from input, perhaps issue a warning and try
      again.)
* `enum` -- Defines a small set of possibilities. Can do many of the things a `short` can do (e.g. be part of a `switch`
  statement).

# Control flow

* `while(condition) {statements;}` -- the simplest loop.
* `do {statements;} while (condition)` -- only use when you can't check the condition before the loop runs.
* `for (int i = 0; i < n; i++) {statements;}` -- the classic way to index into an array of size `n`.
* `for (Contestant contestant : contestants) {statements;}` -- the modern way to iterate through any collection.
* `break` -- Immediately exit the current loop (or switch block)
* `continue` -- Immediately go to the top of the loop for the next iteration.
* `switch(val) {case val1: ... default: }` -- Jump to the first matching case statement.

# Containers

* `Collection<V>` -- even more generic than a `List` or
  a `Set`.  https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
* `List<V>` -- a list to which elements of type V can be added. If you don't have a specific need, use `ArrayList`.
    * Good for adding to the end of a list.
    * Good for doing the same thing to everything on a list.
    * Good if you want to do things in exactly the order in which they were added to the list.
    * Not good if you want to do things in a different order.
    * Not good if you want to act on a specific item
* `Map<K,V>` -- a map from keys (of type K) to values (of type V). The most common keys are Strings. Values could be
  anything. If you don't have a specific need, use `HashMap`.
    * Good when you want to access a specific item with a key.
    * Good when you have a natural key. (Social Number for people, or address for houses).
    * Not good when you want to act on all things in a specific order.
* `Iterable<V>` -- Something which can be after the `:` in `for (V value : values) {}`. All lists, `map.keySet()`,
  and `map.valueSet()` are all iterables.

# Why do we write unit tests?

* To better understand what our classes are supposed to do
* To make sure that our classes do what we think they do
* To make sure that our code keeps on working.

# The (Almost) Truth about Java

* Variables in Java contain either "primitive values" (`float`, `int`, `char`, etc.) or *references* to objects. The
  address of a house is not the house itself. A single human can have two nicknames.
* In Java one *never* has direct access to an object ... it is always via some reference. The most famous reference
  is `this`.
* As a shorthand, we say that we pass objects as parameters to methods. This is not technically true. We actually pass
  references to objects as parameters to methods. But that's too many words, so we oversimplify. As long as you know the
  truth, talking in shorthand is fine.

# The Billion-Dollar Mistake -- NPE

* In `Odometer huh = new HashMap<String, Odometer>().get("B");`, `huh` is *not* a reference to any actual object.
  Instead, it has the value `null`.
* `huh.getCurrentMileage()` results in an Exception, `NullPointerException`. How could it not throw some sort of
  exception? This is such a common source of pain that `NullPointerException` is known as "NPE".

# The Internet

* **server** -- A process which is running continuously on machine, accepting connections from clients and interacting
  with them.
* **client** -- A process (like Chrome) which connects to a server process.
* `netstat -n` -- A bash command showing your current connections between clients and servers.
* **DNS** -- Maps from human-readable domains (e.g. wecancodeit.org) to actual computer IP addresses (e.g.
  159.65.180.149).  https://dns.google/query?name=wecancodeit.org&rr_type=ALL&ecs=&show_dnssec=true
* **IP Address** an address on the internet. https://whatismyipaddress.com/ip/159.65.180.149
* 80 and 443 -- The server locations for http and https.  https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers
* **HTTP Response Codes**. https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
    * 1xx --> Informational
    * 2xx --> Success
    * 3xx --> Redirection
    * 4xx --> Client did something wrong
    * 5xx --> Server did something wrong

# **Spring Boot**

* **Spring** -- a widely-used and powerful framework for creating Java servers. Spring scans your code for annotated
  Java entities (classes, interfaces, methods, fields, etc) and connects them altogether into a production-ready
  application.
* `@Controller` -- An annotation for linking endpoints (e.g. `/fancyHello`) to templated web pages (e.g,
  in `src/main/resources/templates`).
* `@RestController` -- An annotation for linking endpoints (e.g. `/courses/{course_id}/`) to API responses.
* `@GetMapping`, `@PutMapping`, `@PostMapping`, `@PatchMapping`, and `@DeleteMapping` -- annotations for the five HTTP
  verb endpoints.
* `@SpringBootApplication` -- An annotation that Spring should run the `main()` in the class.
* `@Bean` -- An annotation that Spring should wire in the entity into its framework.
* `Logger logger = LoggerFactory.getLogger(ThisClass.class);` -- standard phrasing to create a logger to which you can
  write interesting information. Used in all Java programs, Spring and non-Spring. We use the `org.slf4j` loggers.
* **Reflection** -- The ability for Java code to see the structure of Classes programmatically. You should never use
  reflection directly, but it's what allows Spring to work.
* **Gradle** -- a system for defining the configuration of a Java project in a `build.gradle` file, written in the
  "Groovy" language. Defines what version of Java is required, which libraries to download and use, etc. Is a modern
  replacement for the "Maven" system (which used a `pom.xml` file instead).

# **Algorithms**

* **State diagram** -- A diagram showing the different states an object can be in, and how it transitions from one state
  to another. https://us02web.zoom.us/wb/doc/gglGbp9mSjWaXQ7Yn5-Ygg
* **Scaling** -- How the resources required and work done by a process increases as the size of a problem increases.

# My opinions

* Make everything possible `private`. If it really can't be private, make it `protected`. If it can't even be protected,
  then make it `public`.
* Make everything possible `final`.
* When in doubt, ask yourself: what would be easier to test?
* When in doubt, having more smaller components is better than having fewer complex ones.
* If you're not sure if something will work, try it!
* Name variables, methods, classes, and interfaces so that you can understand what they are without having to actually
  look at their definitions.
* Let IntelliJ reformat your code so the formatting reflects the actual structure.
* Put useful information in the README.md in the root of your project.
* Segregate code smells

# Principles

* **Fail quickly and cheaply**
    * It's better to catch errors in the editor than the compiler. It's better to catch errors in the compiler than
      while running unit tests. It's better to catch errors while running unit tests than while running integration
      tests. It's better to catch errors while running integration tests than in production.
    * Start with a proof-of-concept. Iterate with new versions as necessary.
    * Reduce the effort required to get good feedback.
    * Tighten feedback loops.
    * Prefer a rapid sequence of tiny lessons, each introducing just one new concept at a time.
    * This is the essence of agility.
* **Ratchet success**
    * Technically, we use Git to store our code. This allows us to always revert to the last good version, so we can
      experiment with complete safety.
    * Educationally, we continue to build on material learned previously, so we don't forget what we learned before.
      However, you should still periodically review all that you've covered so far in the course.
    * Continuously ensure that prior successes aren't lost. This allows us to reduce friction.
* **Reduce cognitive load**
    * A well-structured complex system contains multiple programs, each of which should do a clearly-defined thing. A
      well-structured program is structured into components, each of which should a clearly-defined role. The
      alternative is incomprehensible chaos.
    * Many of the decisions made by the creators of Java are overkill for tiny programs. But the structure they provide
      is essential for large programs developed by large teams. Have sympathy for the structure.
    * Modern programming languages are designed for collaboration with IDEs.
    * Always write code with your readers in mind. Obey idioms. Include parenthesis whenever there's a doubt.
    * Have as few development tasks in progress at a time as possible.
    * Have as few instructional concepts in progress at a time as possible. "Done" is good ... "almost done" is not.
    * Have as few as possible outstanding homework assignments projects at any time.
* **A person wearing two watches doesn't know what time it is.**
    * Get into the habit of thinking: "for this type of data, what is the single-source-of-truth". For some course info,
      the Canvas syllabus is authoritative.
    * In most complex systems, authoritative data isn't directly presented to end-users ... instead, it propagates to
      downstream systems for display.
    * "Don't Repeat Yourself" makes this easier. Code is expensive to write, and even more expensive to maintain. The
      less code we write, the better. Modern programming languages allow us to reuse code (ours and others') rather than
      repeating ourselves with similar code.
    * Distinguish consistency from cargo-cult logic.[^1] Don't copy-and-paste without understanding -- but do accept
      black-boxes. [^2] Practice https://en.wikipedia.org/wiki/Rubber_duck_debugging.
* **Expand empathy**
    * Empathy for the user
        * This is why Scrum stories start with `As a ____, I ...`.
    * Empathy for the computer.
        * Computers aren't magical, they obey physical laws. They cannot guess your intention.
    * Empathy for the future you.
        * Write comments useful to anyone reading your code, especially yourself a year from now.
    * Empathy for disability.
        * Separate data and presentation, so people can access your data in ways best suited to their abilities.
        * Use standard frameworks, so experts can integrate them with accessability tools.
    * Empathy for history
        * `git config --global init.defaultBranch main` (rather than "master")
* **Be Resilient**
    * You will encounter bugs in the tools you use but which you don't control. Sometimes you will need to use ugly
      workarounds while the root cause is being addressed. Sometimes it will never be addressed.
* **Iterate**
    * Iterate Upon Yourself
        * Reflect on what takes time and effort, and see how it can be made
          easier. https://wiki.c2.com/?LazinessImpatienceHubris
        * Reduce friction. Increase transparency, which in turn is utterly dependent upon psychological safety.
          PostMortems *must* be blameless.
        * Avoid anti-patterns. Embrace science as "a collection of techniques architected to minimize self-deception".
        * Collaborate with your tools (e.g., IDEs). Let your tools guide you.
        * Learn keyboard shortcuts. https://xkcd.com/1205/. Instead of the usual 80/20 rule, expect a 95/5 rule ... a
          handful of shortcuts can save a huge amount of effort.
            * (META: we should strongly encourage students to learn touch-typing before they begin the cohort.)
        * Observe your ergonomics and posture. Allow your upper body to balance on your lower body. Relax those
          shoulders. Remember to breathe.
    * Iterate as a team
        * Reflect on what takes time and effort, and see how it can be made
          easier. https://wiki.c2.com/?LazinessImpatienceHubris
        * Reduce friction. Increase transparency. The bedrock of any team is psychological safety. PostMortems *must* be
          blameless.
        * Avoid anti-patterns.
        * Collaborate with your tools (e.g., Git and GitHub). Let your tools guide you.
        * Beware of https://en.wikipedia.org/wiki/Conway%27s_law

[^1]: If you're working in a system in which each component is named after an animal species, then you should continue
that pattern (to reduce the cognitive load on others). Or if your organization has a specific code formatting style, you
should continue to use it. But don't just copy stuff without understanding.

[^2]: The whole point of encapsulation is that we don't have to understand details if they're hidden behind
abstractions. So we can tell students: "The `Console` object knows how to write stuff to the screen. We can trust that
it does so and not worry about how it does so."
