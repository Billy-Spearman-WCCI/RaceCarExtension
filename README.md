# Glossary

* **IDE**: Integrated Development Environment (VSCode, IntelliJ) -- a programming-language-aware text editor.
* **object**: a thing encapsulating data (in "instance fields") and behavior (in "methods")
  * `this` -- the syntax to access **Instance fields**
  * `class`: The definition of the data and/or behavior of its instances.
  * `new`: Creates an object of the specified class.
  * **constructor**: A method which runs when an object is created and sets its initial state.
  * `static`: Data and behavior (i.e. fields and methods) encapsulated by the class itself, rather than any particular instance. **Usually** a code smell.
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
  * **parameter** -- a value passed to a method when it is called
  * **variable** -- a placeholder defined within a method ... available within the block but not outside.
  * `return`: Exit the current method. If the method returns a value, specifies the value to return.
  * **signature**: The definition of the types of the parameters a method accepts and the type of the value the method returns.
  * `void`: Indicates that the call to a method does not result in a value.
  * **call stack**: The current method, the method from which it is called, the method from which that was called, and all the way up to the `main()` method.
* `interface`: a list of promised behaviors (i.e. a list of methods -- but without implementations)
  * `implements`: an assertion by a class that it implements all promised behaviors of an interface.
* **OO** -- An Object-Oriented programming style
  * **abstraction**: separating what's essential for a particular use from what isn't.
  * **polymorphism**: the Race class can call `contestant.turn()` and Java will ensure that the right method is called, depending upon the *actual* class of the object implementing Contestant.
  * **inheritance**: when one class extends another. 
  * **encapsulation**: when a RaceCar contains an Odometer rather than trying to do that behavior itself https://github.com/marshallfWCCI/RaceCarInterface/commit/92e8da66095290ebdb11e4e53e04cede7639f787
* **Imperative** -- A programming style in which the system is told what to do.
* **Declarative** -- A programming style in which the system is told the desired state and isn't micromanaged in the executed. `build.gradle` is declarative.
* **Structured** -- An imperative programming style in which statements are organized into nesting contexts.
 
* `@Override` is an example of an **annotation**. `@Override` identifies when a method is either required by an interface or redefines an existing method (this case we'll talk about tomorrow)
* **Instance variables** -- the fields you've seen belonging to object instances.  (There is also a concept of `class variable` which should only be used in very specific instances, which we might not even encounter this course.)
* `extends` -- A **subclass** `extend`s another `class`. If we tell Java that C extends B and B extends A, then C extends A (even if we don't explicitly say so).
* `abstract` -- A class which has incompletely-defined behavior and so cannot have instances. But it will have **concrete** subclasses which may create instances.
* Visibility (of data and behavior)
  * `final` -- Write-once.  May not be modified after it is set. 
  * `private` -- Only visible within the defining class.
  * `protected` -- Only visible within the defining class and its subclasses (and subsubclasses, etc)
  * `public` -- Visible everywhere
* `package` -- The directory where the class is defined. Code in `src/main/java/org/wcci/marshall/project1` and `src/test/java/org/wcci/marshall/project1/` lie in package `org.wcci.marshall.project1`. Many core classes lie in subpackages of `java`, e.g. `java.util`.
  * `import` -- Having `import java.util.ArrayList` or `import java.util.*` at the top of a source file allows one to type `new ArrayList()` rather than `new java.util.ArrayList()`. If no import applies and the full path of the class isn't specified, then Java defaults to only seeing classes in the current package.
  * **package visibility** -- If neither `private`, `protected`, nor `public` are specified, then the visibility extends to everything in the same package. Don't do this.
* `Exception` -- stop the execution of the code...something unexpected has happened. An instance of the `Exception` class (or its subclasses) is passed up the call stack.
  * `throws` -- A method signature may also specify that the method may throw one or more subclasses of `Exception`.