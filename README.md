# Glossary

## Tools

* **Markdown**: The format of the source code for this glossary.
* **IDE**: Integrated Development Environment (VSCode, IntelliJ) -- a programming-language-aware text editor.
* **JavaDoc** -- Documentation for each Java class, defining the methods, their parameters, return types, and behavior.
  Adding comments of the form `/** Text describing the method */` just before each method will automatically be
  understood by IntelliJ and is most useful.
* **Git**
    * Setting better defaults:
        * `git config --global --add --bool push.autoSetupRemote true`
        * `git config --global core.editor "nano"`
    * `nano` is a super-tiny text editor within git bash. Type control-X to exit, control-G for help.

## Syntax

* **Code** -- instructions to a computer using the expected syntax.
* Java has a syntax -- `;` separate statements, etc.
    * IntelliJ does the parsing of your Java program, converting it into something that can run.
* Html has a syntax -- `<tagName>` at start and `</tagName>` at end, etc.
    * Chrome is *VERY* good at parsing HTML for you.
* Markdown (.md files like this one) has a syntax, for instance backquotes say that it should have a grey background.
* **Parsing** -- The act of taking text (e.g. a String) and splitting it up into meaning "words" according to the syntax
    * When Chrome receives an HTML document, it needs to parse into a tree of elements so it can display it.

## Java

* **object**: a thing encapsulating data (in "instance fields") and behavior (in "methods")
    * `this` -- the syntax to access **Instance fields**
    * `class`: The definition of the data and/or behavior of its instances.
    * `new`: Creates an object of the specified class. `new` can only be called on non-abstract classes. It cannot be
      called on abstract classes or interfaces themselves.
    * **constructor**: A method which runs when an object is created and sets its initial state.
    * `static`: Data and behavior (i.e. fields and methods) encapsulated by the class itself, rather than any particular
      instance. They are shared by all instances of the class. `System.in` and `System.out` are static fields
      of `System`. Static methods cannot access `this`.
    * `static` fields in a class are usually a code smell, unless the field is declares `final` and is also
      **immutable**.
    * **immutable** -- an object which never changes state. The most famous example is `String`, which is why we
      need `StringBuilder`, which is just something that can accept `.append("morestuff")` to build a long string
      easily -- and then convert to a string at the end with `.toString()`.
        * We need a word to distinguish between two different types of objects:
            * (Not safe for all the instances of a class to share) StringBuilder, Odometer, HashMap, Lists, .... -->
              These can change on the inside.
            * (Safe for all the instances of a class to share) String, Integer, ImmutableHashMap --> These cannot change
              on the inside and therefore can be shared by all of the objects of a class. But it's common for such
              classes to return new instances containing modified information.
    * The data and behavior contained in a Class can be other classes too. Normally, this is super-confusing, so don't
      do it. The exception is when a class has a "helper".
        * Another example is when the job of a class is complicated that it needs other classes to solve its problem,
          but that is a detail no other class should be able to see. Then you could use `private` nested classes.
* **Type**: what data may be stored in a variable or parameter. May be a primitive type, a `class`, or `interface`.
    * **Primitive Type** -- Non-objects in Java. They cannot be null.
        * `boolean` : `true` or `false`. Note that this is the only value allowed in `if ()`. The boxed version is the
          class `Boolean`.
        * `byte` : In Java, this has values -128..127. In the sane world, it has values 0..255. Consists of 8 **bits**.
        * `char`: Two bytes in size, encodes the first 60000 or so **Unicode** characters. During American hegemony,
          ASCII used one byte (especially 0..127) to represent common characters. The boxed version is `Character`.
        * `float`: A floating-point number. Rarely used, since memory is so cheap. Prefer `double`
        * `int`: Four bytes in size, so can go from -2Billion to 2Billion. Fine for indices and small numbers. The boxed
          version is `Integer`.
        * `long`: Eight bytes in size, so big enough for most purposes. The boxed version is `Long`.
        * `short`: Two bytes in size, so useful when you *know* that you're dealing with values <30000 or so. (Actually
          -32768 to 32767.) The boxed version is `Short`.
        * `double`. A more precise floating-point number. But floating-point is dark magic nobody understands. If you
          need exact decimals, use `BigDecimal`.
        * Most operators only act upon primitive values, though Java does special things behind-the-scenes for String
          values.
            * Java allows you to type `String s = "Hello";` rather than writing `String s = new String(....)` like for
              every other type actual class.
            * In many cases (e.g. System.out.println()) Java will automatically call `.toString()` when the method
              expects a String and you give it a random object.
            * So when you type System.out.println("" + 2), behind the scenes something like `new Integer(2).toString()`
              is happening.
        * Programmers are lazy, and don't want to type `Integer val = new Integer(2);` when they just want to
          type `Integer val = 2;` ... so Java does the work automatically for you in such cases so you can be lazy. This
          laziness is called **autoboxing**.
        * But why do we need types like `Integer`? Can't we always just use `int`??? Because Maps, Lists, etc, cannot
          contain primitives. This is just a limitation of Java, and occurs because primitive values don't have methods.
        * The process of encapsulating primitive values is called "Boxing". And the process of getting a primitive back
          is called "Unboxing". The box is a legitimate object, while primitives are the only things in Java which
          aren't objects at all. When unboxing, you must be sure that the object isn't null, or deal with the
          consequences (e.g. by running the code in a try/catch block), or be ok with the program crashing.
    * **Type safety** -- Java won't compile if you try to write an incompatible value to a variable.
    * **Casting** or **TypeCasting** -- Telling Java to manually convert one type to another,
      e.g. `double x = (double) 0`;
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
    * `implements`
        * Easy definition: an assertion by a class that it implements all promised behaviors of an interface.
        * True definition:
            * If it's a concrete class, then the class implements the interface.
            * If it's an abstract (partial), then all concrete subclasses implement the interface.
        * Java's syntax is that one "extends a class" and "implements an interface", but both basically say that you're
          basing yourself on something else.
        * Class and interface are actually different.
            * `class` defines objects with data and behavior.
            * `interface` lists required behavior.
            * (We haven't done this yet...might never do so) an `abstract` class *can* say that it requires certain
              behavior to be implemented by its children.

## Programming styles

* **OO** -- An Object-Oriented programming style
    * **abstraction**: separating what's essential for a particular use from what isn't. Code to interfaces whenever
      possible.
    * **polymorphism**: the Race class can call `contestant.turn()` and Java will ensure that the right method is
      called, depending upon the *actual* class of the object implementing Contestant.
    * **inheritance**: when one class extends another.
    * **encapsulation**: when a RaceCar contains an Odometer rather than trying to do that behavior
      itself https://github.com/marshallfWCCI/RaceCarInterface/commit/92e8da66095290ebdb11e4e53e04cede7639f787
    * Note: you will see the acronym "A PIE" to remember the above, but I dislike it because abstraction (programming to
      interfaces), polymorphism (the magic which allows abstraction to work), and encapsulation are essential to OO
      programming, but inheritance is usually a way to reduce duplicate code when classes don't encapsulate well.
* **Imperative** -- A programming style in which the system is told what to do step-by-step.
* **Declarative** -- A programming style in which the system is told the desired state and isn't micromanaged in the
  executed.
    * `build.gradle` is declarative.
    * SQL is probably the most famous declarative language. You tell the database which tables to merge together and it
      decides the best strategy for doing so.
* **Structured** -- An imperative programming style in which statements are organized into nesting contexts.
* **TDD (Test-driven development)**
    * To the extent TDD is utilized, all code is justified by some test.
    * The best time to use TDD is when you don't know how to otherwise begin.
    * The best time to use TDD is when you're still trying to think through what a new method should do, and what it
      should return.
    * The best time to use TDD is when you discover a bug. Don't fix the bug until you first write a test which detects
      it.
    * Always run **all** tests for the class, not just the one you're working on. Success should be a "ratchet".
    * Occasionally run all tests for all classes. IntelliJ can do this with control-shift-F10, or you can do it in Git
      Bash with `gradle test`.
    * Name tests usefully. There's no reason to have lots of verbiage duplicating the name of the class, etc. But you
      should get at least a hint of what the class was testing from the name. The same rule as `git commit -m""`
      applies ... write comments useful to you in the future.
    * To the extent possible, tests should be simple, so that when it fails you have a good idea where to look in your
      code. Use nice round numbers when possible. Avoid unintentional coincidences. Adding $1 to an account containing
      $1 might not detect all failure scenarios. Subtracting $1 from an account containing $100 is quite
      straightforward.
    * There's no reason not to commit to git after *every* successful addition of a test. When all tests pass you may:
        * Celebrate
        * See that your class is still missing some desired behavior, and add another test.
        * See that some other class is missing some desired behavior, and switch to working on that class for a while.
        * Look at the class's implementation and see ways it could be clearer or faster or better in some other way.
          Assuming you have submitted and pushed the working code, you can experiment with refactoring your code. If the
          experiment succeeds, congratulations ... otherwise you can just rollback to the last-committed code.
        * Imagine that a chaos monkey will occasionally go and change your class's code. Do your tests cover all of the
          bugs they might try to introduce? (Sometimes called **Adversarial TDD**.)
        * See that the class is good-enough, and get on to the next class -- or even be done with the project.
    * Tests are perfect to understand using the debugger, because you can run the same code paths many times until you
      find out what isn't behaving as expected.
    * It's often entirely reasonable to use TDD at the start of a project, when you're defining your business objects
      and how they should behave and interact -- but not for the final user-interacting stuff (if the user-interacting
      stuff contains little business logic itself).
    * TDD forces you to think of the *uses* of your objects, because every test:
        * Starts with the creation of an instance of the class which is being tested;
        * Usually calls one or more methods on that object; and then
        * Ends with an expectation about the information returned by a method on that object.
    * TDD should never be a micro-manager. It's not the test's business whether the class being tested uses a Map or a
      List internally. All that should be tested is the external *behavior* of its objects. Of course, if you want to "
      encourage" a class to be a List, you could have tests verifying a "returnPetsInTheOrderTheyWereAdded()". But if
      the class still decided to use a `LinkedHashMap<K,V>`, that's the class's business.
* **Design Patterns** -- Standard solution to design problems
    * **Builder Pattern** -- Standard solution to the problem of constructors getting too complex. Uses the "Fluent"
      pattern to accumulate parameters one-by-one -- rather than having complicated constructors with
      difficult-to-remember parameters.
        * Builders can be super-fancy. You could allow .withInterestRate() if .withSavings() was called before but not
          if .withChecking() was called.
        * But normally, one of the nice things about builders is they can be called in any order.
    * **Fluent Pattern** -- Methods which end with `return this;` so that multiple methods can be called on a single
      object in a single statement.

```
// Error-prone
new Account("string1", "string2", 0.0);

// this is "fluent"
openNewAccount(new Account.Builder()
              .withAccountNumber(TEST_ACCOUNT_NUMBER1)
              .withType(TEST_ACCOUNT_TYPE1)
              .withBalance(TEST_ACCOUNT_BALANCE1)
              .build());
             
// Is identical to 
openNewAccount(((((new Account.Builder())
                  ).withAccountNumber(TEST_ACCOUNT_NUMBER1)
                 ).withType(TEST_ACCOUNT_TYPE1)
                ).withBalance(TEST_ACCOUNT_BALANCE1)
               ).build());
              
// is easier to read then
// Builder b = new Builder();
// b.setAccountNumber("");
// b.setType();
// b.setBalance();
// Account a = b.build();
```

* **Convention over Configuration** -- Put things where the framework expects and you don't to tell it explicitly. So
  IntelliJ *expects* that code will be in src/main/java and src/test/java. If you that, your configuration is *much*
  easier.

## More Java keywords

* `@Override` is an example of an **annotation**. `@Override` identifies when a method is either required by an
  interface or redefines an existing method (this case we'll talk about tomorrow)
* **Instance variables** -- the fields you've seen belonging to object instances.  (There is also a concept of **class
  variable** which should only be used in very specific instances, which we might not even encounter this course.)
* `extends` -- A **subclass** `extend`s another `class`. If we tell Java that C extends B and B extends A, then C
  extends A (even if we don't explicitly say so).
* `super()` -- The first line of most constructor will be to call the constructor of its parent class.
* `abstract` -- A class which has partially-defined behavior and so cannot have instances. But it will have **concrete**
  subclasses which may create instances as long as they implement all of the missing methods.
* **Class Hierarchy** -- a diagram showing which classes extend and/or implement other classes and interfaces. For
  instance, https://en.wikipedia.org/wiki/Java_collections_framework#/media/File:Java.util.Collection_hierarchy.svg
* Visibility (of data and behavior)
    * `final` -- Write-once. May not be modified after it is set.
    * `private` -- Only visible within the defining class. (Most restrictive, and there easiest for the reader.)
    * `protected` -- Only visible within:
        * (1) the defining class
        * (2) children (really, descendants) of the defining class
        * (3) classes in the same package as the defining class (this is the one I forget).
    * `public` -- Visible everywhere. (Unrestricted)
    * Rule: use `private` when you can, otherwise `protected`, otherwise `public`
* `package` -- The directory where the class is defined. Code in `src/main/java/org/wcci/marshall/project1`
  and `src/test/java/org/wcci/marshall/project1/` lie in package `org.wcci.marshall.project1`. Many core classes lie in
  subpackages of `java`, e.g. `java.util`.
    * `import` -- Having `import java.util.ArrayList` or `import java.util.*` at the top of a source file allows one to
      type `new ArrayList()` rather than `new java.util.ArrayList()`. If no import applies and the full path of the
      class isn't specified, then Java defaults to only seeing classes in the current package.
    * **package visibility** -- If neither `private`, `protected`, nor `public` are specified, then the visibility
      extends to everything in the same package. Don't do this.
    * `protected` is visible to everything in the same
      package. https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
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
    * **Increment** -- to add 1 to something.
    * **Decrement** -- to subtract 1 to something.
* `for (Contestant contestant : contestants) {statements;}` -- the modern way to iterate through any collection.
* `break` -- Immediately exit the current loop (or switch block)
* `continue` -- Immediately go to the top of the loop for the next iteration.
* `switch(val) {case val1: ... default: }` -- Java finds the first case that matches and starts running code at that
  point.
    * In a switch statement, either: (1) every statement has a `break;` or (2) none do -- be consistent.

# Containers

* `Collection<V>` -- even more generic than a `List` or
  a `Set`.  https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
* `List<V>` -- a list to which elements of type V can be added. If you don't have a specific need, use `ArrayList`.
    * Good for adding to the end of a list.
    * Good for doing the same thing to everything on a list.
    * Good if you want to do things in exactly the order in which they were added to the list.
    * Not good if you want to do things in a different order.
    * Not good if you want to act on a specific item
    * Only use arrays when speed is super super super important, or when you're given an array.
* `Map<K,V>` -- a map from keys (of type K) to values (of type V). The most common keys are Strings. Values could be
  anything. If you don't have a specific need, use `HashMap`.
    * Good when you want to access a specific item with a key.
    * Good when you have a natural key. (Social Number for people, or address for houses).
    * Not good when you want to act on all things in a specific order.
    * HashMaps operate by allocating all its elements into many rooms, so that each room contains only a handful of
      entries. And given the key, it is super-fast to find the right room. And once you know the room, there are only a
      handful of entries to check one-by-one.
    * .equals() and .hashCode() need to make sense (and be consistent with each other) for `K`'s and there really should
      only be one `V` for any given `K`.
    * `V`'s can be anything, even other Lists or Maps.  `Map<String, List<Integers>>` is perfectly fine.
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
* 80 and 443 -- The server locations ("port number") for http and
  https.  https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers
* 8000, 8080, 8088 -- common port numbers for test http servers. (There are multiple numbers because sometimes you want
  multiple test servers on a single machine for different uses)
* 3306 -- the default port number for MySQL
* **HTTP Response Codes**. https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
    * 1xx --> Informational
    * 2xx --> Success
    * 3xx --> Redirection
    * 4xx --> Client did something wrong
    * 5xx --> Server did something wrong. Web servers usually run all client requests in a outer try/catch and if
      something truly horrible happens, will return a 500 because of that.
* **HTTP Verbs** https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol#Request_methods
    * Retrieve a single item (GET)
        * Should not change the state of any resource.
    * Retrieve a list of items (GET)
        * Should not change the state of any resource.
    * Update an item (PUT) "Hey, item #23 should contain this data"
        * Should be **idempotent** (which is a fancy word for a requirement that calling PUT twice with the same
          information should be the same as just calling it once).
        * Real-life examples of idempotent operations:
            * Converting a color picture to black-and-white.
            * Washing a plate. (Once-washed plates and twice-washed plates are the same.)
            * Tuning to a radio station.
        * Question: is map.put(key, value) "idempotent"?
        * Question: is list.add(value) "not idempotent"
    * Create an item (POST)
        * Typically returns the created resource. Not "idempotent", which is why sometimes your browser will ask say
          something like "reloading this page will resubmit the data".
    * Delete an item (DELETE)
        * Typically returns the deleted resource.
    * Partially modify an item (PATCH)
        * (Less commonly used.)

# **Spring Boot**

* **Spring** -- a widely-used and powerful framework for creating Java servers. Spring scans your code for annotated
  Java entities (classes, interfaces, methods, fields, etc) and connects them altogether into a production-ready
  application.
* `@Controller` -- An annotation for linking endpoints (e.g. `/fancyHello`) to templated web pages (e.g,
  in `src/main/resources/templates`). The templates are using a library called Thymeleaf and has special tags
  like `th:each` which can iterate lists, etc.
* `@RestController` -- An annotation for linking endpoints (e.g. `/courses/{course_id}/`) to API responses.
* `@GetMapping`, `@PutMapping`, `@PostMapping`, `@PatchMapping`, and `@DeleteMapping` -- annotations for the five HTTP
  verb endpoints.
* `@SpringBootApplication` -- An annotation that Spring should run the `main()` in the class.
* `@Bean` -- An annotation that Spring should wire in the entity into its framework. Controllers, RestControllers, and
  everything else that Spring knows about are all subclasses of bean.
* `Logger logger = LoggerFactory.getLogger(ThisClass.class);` -- standard phrasing to create a logger to which you can
  write interesting information. Used in all Java programs, Spring and non-Spring. We use the `org.slf4j` loggers.
* **Reflection** -- The ability for Java code to see the structure of Classes programmatically. You should never use
  reflection directly, but it's what allows Spring to work. Every object has a `.class` field which contains a `Class`
  object which you can ask for annotations, method names, etc.
* **Gradle** -- a system for defining the configuration of a Java project in a `build.gradle` file, written in the
  "Groovy" language. Defines what version of Java is required, which libraries to download and use, etc. Is a modern
  replacement for the "Maven" system (which used a `pom.xml` file instead).

# **Model-View-Controller" style of web server programming ("MVC")

* **Model** interfaces with the database
    * Spring provides an "Object-Relational Mapping" (called Hibernate) which allows you to *annotate* your classes and
      fields with information about the tables and columns they map into the database and then Spring will take care of
      the plumbing.
* **View** takes data and converts it to a form suitable for use (HTML, or JSON, ...)
* **Controller** contains logic for what data is written to the database and how the information is presented to users.

# **Databases

* Database contain tables of information. Tables contain rows of information. Different tables in a database contain
  different types of information. So one table might contain student and their addresses. Another table might contain
  the list of courses. Another table might contain class lists.
* A database row can contain many columns (or fields). Each column has a type (String, number, etc).
* All of the rows in a table have the same columns.
* It works really nicely if each object in a class has its own row in the same table. However, inheritance makes things
  hard, unless each concrete class has its own table.
* Consistency within a table is key -- a given field must have the same meaning in each row in that table.
* Tables can refer to other tables. So "student_id" might be the key to one table, and just a field in another.
* Databases don't handle lists or maps well within a row ... instead you have lots of rows.
* Databases can ("CRUD")
    * Create rows
    * Read rows
    * Update rows
    * Delete rows
* You can also ask databases to do fancy things like search records, and combine records from multiple tables into a
  single result, using a language called SQL.

```
SELECT * FROM dept_manager dm, departments d, employees e
 WHERE d.dept_no = dm.dept_no 
   AND e.emp_no = dm.emp_no
   AND TO_DATE < SYSDATE()
```

A database might have something like:

* A Pet table, indexed by PetID and containing other columns like name and birthdate.
* A Shelter table, indexed by ShelterID and containing information like address.
* A Admission table, which says PetID and ShelterID occurred on a an admission_date.
    * This table does not contain addresses or birthdays. Instead, you take the ShelterID or PetID and look in their
      tables to find that information.

* Databases are good at two hard things:
    * Not losing your data. Allowing multiple people to write to a database without conflicting with each other. ("
      CRUD", transactions).
    * Efficiently combining data from multiple tables into useful results. ("SQL" is language for these queries.)
* **Query** -- a request to a database for data from one or more tables, usually phrased in SQL ("Structured Query
  Language"), e.g., "SELECT * FROM students WHERE last_name='Smith'". keywords are usually uppercase. SQL has it own
  keywords entirely different from Java keywords.
* **Transactions**:
    * Suppose I tell the bank's database: "Pay electric company $100" "Take $100 out of bank account".
    * Most (not all) databases can be told: "begin transaction", "pay $100", "debit my account $100", "end transaction".
      And the database will do all or nothing, and tell us.
* It's common for our Java code to stop at writing to the database, and other teams read from it.
* Common databases include Oracle, SQL Server, MySQL, Postgres. There's also "H2", which is a fake database that only
  lasts while your program is running.
    * `choco install mysql -y` installs an MySQL server listening on port 3306 with an empty password for the `root`
      user.

* **JSON** a concise way for computers to pass information to other computers. A Json message is a Map whose keys are
  strings and whose values are numbers, booleans, strings, lists, or other maps. It is the standard for sending
  information to and from REST endpoints, and to and from browsers. A map is surrounded with curly braces `{}` and a
  list is surrounded with square brackets `[]`. In maps, the key and value are separated by a colon `:`. Java has
  libraries to convert JSON to useful formats. Sample endpoints and possible responses:

```
GET /api/v1/pets/23
{"id": 23, "name": "fluffy", "age": 4.5, "status": { "hunger": 10, "sleepiness" : 5, }, "is_ready_for_adoption": true }

GET /api/v1/pets
[{ "id": 23, "name": "fluffy", "species": "bunny", "age": 4.5, "status": { "dietary_requirements": { "will_eat_grass": true, "will_eat_insects": false }, "hunger": 10, "sleepiness" : 5, }, "is_ready_for_adoption": true },
 { "id": 24, "name": "astro", "species": "cat", "age": 1.5, "status": { "hunger": 11, "sleepiness" : 5, }, "is_ready_for_adoption": true }
 ] 
```

* `curl` -- a command in the Git Bash shell which will send data to an endpoint and display the response.

```
curl -X POST http://localhost:8080/process_form -d fname=John -d lname=Doe
```

# **Algorithms**

* **State diagram** -- A diagram showing the different states an object can be in, and how it transitions from one state
  to another. https://us02web.zoom.us/wb/doc/gglGbp9mSjWaXQ7Yn5-Ygg
* **Scaling** -- How the resources required and work done by a process increases as the size of a problem increases.
  When searching for items in a collection, HashMap scales better than Lists.

# Git Scenarios

* You want to clone a GitHub repository so you can make changes on your own machine (
  e.g. https://github.com/marshallfWCCI/SpringBootExample1.git)
* You want to your own copy on GitHub of a repository so you can make changes and push
  them (https://github.com/2023-Spring-Cohort/virtualpet-YOUR_NAME_HERE).
* You want to see (or want others to see) the development of your code, step-by-step, and including short `-m` comments.
* You want to revert to a prior version of your code.

## Release Branches

* You want to take a snapshot of the current state of your "main" code, so we know exactly what code is running in
  production -- even if you're continuing to push changes to the "main" branch. Hopefully, that snapshot will be tested
  before it goes to production. And you need to be able to answer questions like
    * "did that change make it into this week's release?"
    * "what are all the differences between this week's release and last week's release?"
* We also need to, on Wednesday, make one tiny change to Monday's release (because our QA department found something)
  without pulling in all of the development which happened on Tuesday.

## Feature Branches

* We also want to be able to continue adding functionality to VirtualPetApp, while experimenting on the side with
  changing between ArrayList and HashMap.
* We want the advantage of creating a detailed `commit -m` log, but not bother anyone else on our team until we've
  completed a coherent body of work.

## Branching

* When you switch to a different branch, or if you think a teammate might have pushed something to GitHub,
  run `git pull`. In general, it's always a good time to run `git pull`.
* It's always a good time to run `git status`.
* It's a very good idea to have a standard naming convention for branches.
    * RELEASE_YYYY_MM_DD_HH_MM for candidates for QA and perhaps deployment.
    * FEATURE_INITIALS_FEATURENAME for new coding, e.g. `FEATURE_MGF_BETTERCOLLECTIONS`
* git bash is smart and will do "Tab completion" on branch names.
* `git status` and `git diff` are very useful and `less README.md` will show that file (`q` to exit, space to show
  more).
* `git checkout -b NEW_BRANCH_NAME` creates a new branch based on the current state of whatever branch you're in when
  you run the command (normally this will be "main" or "master")
* If you don't run the "push.autoSetupRemote" command at the top of this file, then first time you run `git push` after
  creating a new branch, it will fail and just do what it says.
* `git checkout EXISTING_BRANCH_NAME` will switch your **workspace** (i.e. files on your laptop) to contain state the
  new branch.
* It's **far** less confusing if `git status` is clean before you run either type `git checkout`.
* `git branch` shows all branches and the "current" one is starred and hopefully on your bash prompt in blue.

## Git commands

* `git status` -- run this early and often.
* `git pull` -- run this early and often. Pulls commits from the corresponding branch on GitHub, and attempts to merge
  them in (if necessary). The more frequently you pull, the smaller the merges, and the more likely that any merges will
  be painless.
* `git add .` -- Add changes in the current directory (and subdirectories thereof) to the be included in the
  next `git commit`. This is called "staging" the changes.
* `git commit -m "Useful message"` -- stores the staged changes into your repository. The message should be useful most
  of all to you. Smaller commits are far easier to summarize -- which is yet another reason to commit frequently.
* `git reset HEAD~1` -- Undos the most recent commit -- *but* should only be used if that change is not yet pushed.
* `git push`
* `git checkout -b FEATURE_SOMEFEATURE` -- Creates a new branch, allowing for experimentation independent of maintenance
  which is occurring on the primary branch. I suggest that you only run this command when `git status` is clean.
* `git checkout FEATURE_SOMEFEATURE`, `git checkout main` -- Switches your workspace (e.g. the files in your project) to
  an existing branch. I suggest that you only run this command when `git status` is clean.

# Too-advanced to discuss now

* End-point **Pagination**, e.g. https://www.baeldung.com/rest-api-pagination-in-spring.
* JPA Laziness, e.g. https://www.baeldung.com/hibernate-lazy-eager-loading

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
