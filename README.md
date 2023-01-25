# Glossary

## Tools
* **Markdown**: The format of the source code for this glossary.
* **IDE**: Integrated Development Environment (VSCode, IntelliJ) -- a programming-language-aware text editor.

## Java
* **object**: a thing encapsulating data (in "instance fields") and behavior (in "methods")
  * `this` -- the syntax to access **Instance fields**
  * `class`: The definition of the data and/or behavior of its instances.
  * `new`: Creates an object of the specified class. `new` can only be called on non-abstract classes. It cannot be called on abstract classes or interfaces themselves.
  * **constructor**: A method which runs when an object is created and sets its initial state.
  * `static`: Data and behavior (i.e. fields and methods) encapsulated by the class itself, rather than any particular instance. **Usually** a code smell. `System.in` and `System.out` are static fields of `System`. Static methods cannot access `this`.
* **Type**: what data may be stored in a variable or parameter. May be a primitive type, a `class`, or `interface`.
  * **Primitive Type** -- Non-objects in Java
    * `boolean` : `true` or `false`. Note that this is the only value allowed in `if ()`.
    * `byte` : In Java, this has values -128..127. In the sane world, it has values 0..255. Consists of 8 **bits**.
    * `char`: Two bytes in size, encodes the first 60000 or so **Unicode** characters. During American hegemony, ASCII used one byte (especially 0..127) to represent common characters.
    * `float`: A floating-point number. Rarely used, since memory is so cheap. Prefer `double`
    * `int`: Four bytes in size, so can go from -2Billion to 2Billion. Fine for indices and small numbers.
    * `long`: Eight bytes in size, so big enough for most purposes.
    * `short`: Two bytes in size, so useful when you *know* that you're dealing with values <30000 or so.
    * `double`. A more precise floating-point number. But floating-point is dark magic nobody understands. If you need exact decimals, use `BigDecimal`.
    * Most operators only act upon primitive values, though Java does special things behind-the-scenes for String values.
  * **Type safety** -- Java won't compile if you try to write an incompatible value to a variable.
* **method**: A function defined within a class. In java, all functions are defined within classes.
  * **code block** -- one or more statements surrounded by curly braces `{` ... `}`.
  * **nesting** -- when one code block has sub-code-blocks within it.
  * **parameters** -- the actual values passed to a method or constructor.
  * **variable** -- a placeholder defined within a method ... available within the block but not outside.
  * `return`: Exit the current method. If the method returns a value, specifies the value to return.
  * **signature**: The definition of the types of the parameters a method accepts and the type of the value the method returns. Also, what types of Exceptions it might throw.
  * `void`: Indicates that the call to a method does not result in a value.
  * **call stack**: The current method, the method from which it is called, the method from which that was called, and all the way up to the `main()` method.
* `interface`: a list of promised behaviors (i.e. a list of methods -- but without implementations)
  * `implements`: an assertion by a class that it implements all promised behaviors of an interface.

## Programming styles
* **OO** -- An Object-Oriented programming style
  * **abstraction**: separating what's essential for a particular use from what isn't.
  * **polymorphism**: the Race class can call `contestant.turn()` and Java will ensure that the right method is called, depending upon the *actual* class of the object implementing Contestant.
  * **inheritance**: when one class extends another. 
  * **encapsulation**: when a RaceCar contains an Odometer rather than trying to do that behavior itself https://github.com/marshallfWCCI/RaceCarInterface/commit/92e8da66095290ebdb11e4e53e04cede7639f787
* **Imperative** -- A programming style in which the system is told what to do step-by-step.
* **Declarative** -- A programming style in which the system is told the desired state and isn't micromanaged in the executed. `build.gradle` is declarative.
* **Structured** -- An imperative programming style in which statements are organized into nesting contexts.

## More Java keywords 
* `@Override` is an example of an **annotation**. `@Override` identifies when a method is either required by an interface or redefines an existing method (this case we'll talk about tomorrow)
* **Instance variables** -- the fields you've seen belonging to object instances.  (There is also a concept of **class variable** which should only be used in very specific instances, which we might not even encounter this course.)
* `extends` -- A **subclass** `extend`s another `class`. If we tell Java that C extends B and B extends A, then C extends A (even if we don't explicitly say so).
* `super()` -- The first line of most constructors will be to call the constructors of its parent class.
* `abstract` -- A class which has partially-defined behavior and so cannot have instances. But it will have **concrete** subclasses which may create instances.
* **Class Hierarchy** -- a diagram showing which classes extend and/or implement other classes and interfaces. For instance, https://en.wikipedia.org/wiki/Java_collections_framework#/media/File:Java.util.Collection_hierarchy.svg
* Visibility (of data and behavior)
  * `final` -- Write-once.  May not be modified after it is set. 
  * `private` -- Only visible within the defining class.
  * `protected` -- Only visible within the defining class and its subclasses.
  * `public` -- Visible everywhere
* `package` -- The directory where the class is defined. Code in `src/main/java/org/wcci/marshall/project1` and `src/test/java/org/wcci/marshall/project1/` lie in package `org.wcci.marshall.project1`. Many core classes lie in subpackages of `java`, e.g. `java.util`.
  * `import` -- Having `import java.util.ArrayList` or `import java.util.*` at the top of a source file allows one to type `new ArrayList()` rather than `new java.util.ArrayList()`. If no import applies and the full path of the class isn't specified, then Java defaults to only seeing classes in the current package.
  * **package visibility** -- If neither `private`, `protected`, nor `public` are specified, then the visibility extends to everything in the same package. Don't do this.
* `Exception` -- stop the execution of the code...something unexpected has happened. An instance of the `Exception` class (or its subclasses) is passed up the call stack.
  * `throws` -- A method signature may also specify that the method may throw one or more subclasses of `Exception`.
  * `try {} catch (Exception e) {}` block -- code that is prepared to handle a thrown exception and decide what should happen next.  (If the exception occurs while trying to read a number from input, perhaps issue a warning and try again.)

# Control flow
* `break` -- Immediately exit the current loop (or switch block)
* `continue` -- Immediately go to the top of the loop for the next iteration.
* `switch(val) {case val1: ... default: }` -- Jump to the first matching case statement.

# Containers
* **JavaDoc** -- Documentation for each Java class, defining the methods, their parameters, return types, and behavior.
* `Collection<V>` -- even more generic than a `List` or a `Set`.  https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
* `List<V>` -- a list to which elements of type V can be added. If you don't have a specific need, use `ArrayList`.
* `Map<K,V>` -- a map from keys (of type K) to values (of type V). The most common keys are Strings. Values could be anything. If you don't have a specific need, use `HashMap`.
* `Iterable<V>` -- Something which can be after the `:` in `for (V value : values) {}`.  All lists, `map.keySet()`, and `map.valueSet()` are all iterable.