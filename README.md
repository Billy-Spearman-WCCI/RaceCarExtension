# Projects containing useful code

* https://github.com/marshallfWCCI/RaceCarInterface
    * Step-by-step refactoring

* https://github.com/2023-Spring-Cohort/RaceCarExtension/
    * This Structured Glossary
    * Example of subclasses, interfaces, abstract classes, etc.

* https://github.com/2023-Spring-Cohort/atm-project-marshallfWCCI
    * A fully TDD project, including I/O

* https://github.com/marshallfWCCI/SpringBootExample1/tree/main/src/main/java/com/example/springboot
    * Spring boot: REST endpoints, Thymeleaf HTML templates. Entities for the Employees mySQL database.

* https://github.com/marshallfWCCI/SpringBootExample2/tree/main/src/main/java/com/example/springboot
    * Spring boot: Just Thymeleaf templates ... no REST or JPA.

* https://github.com/marshallfWCCI/MarshallCampusExample
    * My fork of https://github.com/2022-Fall-Cohort/CampusExample, with comments and examples.

* https://github.com/marshallfWCCI/p134022/blob/main/src/main/java/org/wecancodeit/LinearIn.java
    * My solution to https://codingbat.com/prob/p134022

* https://github.com/marshallfWCCI/ReviewAPI
    * My solution for the Reviews API project

* https://github.com/marshallfWCCI/gradleReact
    * An IntelliJ project which contains React code (.js) and styleSheets (.css) in `src/main/webapp` and serves the
      transcoded results from `src/main/resources/static/dist` (which of course is in the `.gitignore`).
      Transcoding is automatically performed by gradle before `:bootRun` or `:test`.

# Glossary

## Tools

* **Markdown**: The format of the source code for this glossary.
    * The name is a play on **Markup**, which describes the addition of structural elements to plain text.  
      **HTML** ("Hypertext Markup Language") is the most famous markup syntax.
* **IDE**: Integrated Development Environment (VSCode, IntelliJ) -- a programming-language-aware text editor.
* **JavaDoc** -- Documentation for each Java class, defining the methods, their parameters, return types, and behavior.
  Adding comments of the form `/** Text describing the method */` just before each method will automatically be
  understood by IntelliJ and is most useful.
* **Git**
    * Setting better defaults:
        * `git config --global --add --bool push.autoSetupRemote true`
        * `git config --global core.editor "nano"`
    * `nano` is a super-tiny text editor within git bash. Type control-X to exit, control-G for help.
* **Chrome** extensions
    * JSON Formatter -- https://chrome.google.com/webstore/detail/json-formatter/bcjindcccaagfpapjjmafapmmgkkhgoa
* **IntelliJ**
    * Setting better defaults:
        * `ctrl-alt-s` `Inspections` --> select "Inspections settings"
        * (TODO -- enforcing capitalization requirements, etc.)

## Syntax

* **Code** -- instructions to a computer using the expected syntax.
* Java has a syntax -- `;` separate statements, etc.
    * IntelliJ does the parsing of your Java program, converting it into something that can run.
* Html has a syntax -- `<tagName>` at start and `</tagName>` at end, etc.
  `<!-- HTML comments start with an angle bracket, exclaimation, and two hyphens -->`
    * Chrome is *VERY* good at parsing HTML for you.
* Markdown (.md files like this one) has a syntax, for instance backquotes say that it should have a grey background.
* **Parsing** -- The act of taking text (e.g. a String) and splitting it up into meaning "words" according to the syntax
    * When Chrome receives an HTML document, it needs to parse into a tree of elements so it can display it.

## Java

* **JRE** -- Java Runtime Environment -- the thing that actually runs compiled Java code.
    * Originally created by Sun Microsystems, which was then bought by Oracle. Now there are several free alternatives:
    * OpenJDK (Oracle's "free" version)
    * Amazon Corretto (based on Oracle's OpenJDK)
    * Azul Zulu (Microsoft)
* **JDK** -- Java Development Kit -- includes the built-in libraries which makes Java usable. Necessary for development.
    * https://en.wikipedia.org/wiki/Java_version_history
* **JVM** -- Java Virtual Machine -- an imaginary computer that all Java code is compiled for. The JVM implements this
  imaginary computer on your real computer so your Java code can run.

* **object**: a thing encapsulating data (in "instance fields") and behavior (in "methods")
    * `this` -- the syntax to access **Instance fields**
    * `class` -- Defines the structure of an object (i.e. what data is contains and what behavior it provides).
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
        * A "mutation" is when your DNA changes.
        * A good hint that an object is immutable is that all of its fields are `final` (though technically all of its
          fields also need to be immutable).
        * Normally, a `void` method doesn't make sense for an immutable object.
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
        * But why do we need types like `Integer`? Can't we always just use `int`???
          Maps, Lists, etc, cannot contain primitives.
          This is just a limitation of Java, and occurs because primitive values don't have methods.
        * The process of encapsulating primitive values is called "Boxing". And the process of getting a primitive back
          is called "Unboxing".
          The box is an object, while primitives are the only things in Java which aren't objects at all.
          When unboxing, you must be sure that the object isn't null, or deal with the consequences (e.g. by running
          the code in a try/catch block), or be OK with the program crashing.
    * **Type safety** -- Java simply won't compile if you try to write an incompatible value to a variable.
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
        * Java allows for a single class to have multiple methods with the same name, as long as the parameters are
          different enough that it can always tell which to call. When trying to figure out which method to call, Java
          does not look at the return type.
        * Don't do this unless you have a good reason.
        * Java also allows a special `...` syntax to say that the last parameter to a method can be repeated any number
          of times (including zero) and then be presented as an array. https://www.baeldung.com/java-varargs
    * `void`: Indicates that the call to a method does not result in a value.
    * **call stack**: The current method, the method from which it is called, the method from which that was called, and
      all the way up to the `main()` method.
* Anonymous methods: `public static void something(int a, int b) {}` is a *named* function. You need a class to own that
  method.
    * `(int a, int b) -> {return a > b;}` is a special syntax when you want to create a function just for a single
      purpose.
    * This is used when you want to pass *behavior* as a parameter to an actual method.
    * The simplest example is `() -> {do_something();}`, which is a method with no parameters that does something.
    * This is a relatively new addition to Java, but Spring does use it.
    * These are sometimes called **lambda expressions**.
* `interface`: a set of promised behaviors (i.e. a list of methods -- but without implementations)
    * `implements`
        * Easy definition: an assertion by a class that it implements all promised behaviors of an interface.
        * True definition:
            * If it's a concrete class, then the class implements the interface.
            * If it's an abstract (partial), then all concrete subclasses implement the interface.
        * Java's syntax is that one "extends a class" and "implements an interface", but both basically say that you're
          basing yourself on something else.
            * I usually put grandparents at the top and grandchildren at the bottom. As you go towards the bottom of the
              page, more and more information and behavior is added -- but *never* subtracted.
        * Class and interface are actually different.
            * `class` defines objects with data and behavior.
            * `interface` lists required behavior.
            * (We haven't done this yet...might never do so) an `abstract` class *can* say that it requires certain
              behavior to be implemented by its children.
        * Every time you can replace a reference to a class with a reference to an interface, your code becomes easier
          to read. So if `Race.java` can have a `List<Contestant>` rather than `List<GenericRacer>`, that's a win.
            * This is called "programming to interfaces" rather than "programming to classes", and is a "best practice".

## HTML

* **Hyper Text Markup Language** -- We are using Markdown Language to write this document here, but HTML is the
  unified language of the internet. If you're looking at a web page, you're looking at HTML.
* **tags**: A way to reference HTML elements within the documents most (not all) tags will have an
  opening and closing tag with the syntax `<tag>...</tag>`, though some are more like `<tag/>`.
  We usually call `<` and `>` angle brackets because they look like angles.
  We also say "surrounded" or "wrapped" by angle brackets, e.g. "we wrap the `p` tag in angle brackets".
* **useful tags and what they do**:
* Division `<div></div>` -- A commonly used wrapper, used to contain elements for reference in CSS.
* Style `<style></style>` -- Used for internal styling with CSS. It is not best practice to use internal styling.
* Title `<title></title>` -- This is the title of the HTML document, it will not show-up on the webpage, but the tab of
  the browser.
* Span `<span></span> `-- Inline div, used to select elements within text.
* Tables `<table></table>` -- Table
    * Table header `<th></th>`
    * Table rows `<tr></tr>`
    * Table cell `<td></td>` -- also known as "table data"
* Code `<code></code>` -- Used to define a piece of computer code. The content inside is displayed in the browser's
  default monospace font.
* Break `<br>` -- Akin to "break;" in Java. Will not have an end tag.
* Body `<body></body>` -- A container that wraps most of the webpage, most HTML will exist in the body.
* Header `<h1></h1>` -- Header 1-6 Where 1 being the largest and 6 being the smallest, used for heading individual
  sections.
  Think Headlines on a newspaper
* List -- There are two types of commonly used list:
    * Ordered `<ol></ol>` (Numbered 1-X)
    * Un-ordered`<ul></ul>` (appears on the webpage as they load)
* Paragraph `<p></p>`-- Normally used for the vast majority of text that appears on a web page; A small text element.
* Anchor `<a></a>` -- Used, in combination with "href="link destination"" to link pages together.
* Footer `<footer></footer>` Exists at the very bottom of the page.

# Browser

* Browser sends a request to a server, and gets some HTML back. (I.e. text with things like `<div>`).
* Browser then "parses" that text into elements it understands (i.e. a different subclass for each HTML tag).
* Browser create a "tree" of these elements. So everything within a `<div>` is a "child" of that div, etc, etc.,etc
* Browser then takes that tree of objects and draws it on the screen.
* Browser allows javascript code to access -- and even modify -- this tree of objects, which it
  calls `document.documentElement`, which is a truly lousy name. We call the "DOM" (Document Object Model).
    * We can add element, change them, delete them ... create entire new subtrees.
      We call this "manipulating the DOM" and the entire web is based on this.
    * We can do this because the user pressed a button, or because we issued a REST-like request to a webserver and got
      more info, using something called `fetch` and `promise`s.
* Javascript can update that tree and then Chrome will automatically redraw the screen accordingly.
* We think of the "outline" of elements as a tree, with the outermost tag (`<html>`) being the trunk, and then we keep
  on branching and branching. This tree is the "Document Object Model" because it's all of the objects in the html
  document.
* Javascript allows for *dynamic* web pages. If you want new messages to appear at the bottom of your screen, then
  you're adding additionals `div` or whatever, and that requires JS.
* Javascript updates the DOM in response to user actions.
* Javascript talks to webservers to get information so that they can update the DOM.

# JavaScript

## JavaScript vs Java, an opinionated comparison.

* Language name
    * *Java* is named after the Indonesian coffee-growing island.
    * *JavaScript* is named after the programming language.
* Strategy
    * *Java*: What's left of C++ if you pull out everything not necessary for IntelliJ to be an awesome development
      environment.
    * *JavaScript*: Quite nice if you add everything necessary for IntelliJ to be an awesome development environment and
      thereby get TypeScript.
* Reason for living
    * *Java*: Large corporate codebases, with moderate speed requirements but lots of business logic. Web servers with
      database backends is a typical use.
    * *JavaScript*: For dynamically updating the structure or data of webpages within the browser, including responding
      locally to user input, I'm the only game in town.
* Expressiveness
    * *Java*: Can express coding styles which lie somewhere on the spectrum between "rather ugly" and "rather clean".
    * *JavaScript*: Can express coding styles which lie somewhere on the spectrum between "unimaginably ugly"
      and "beautifully clean".
* Runtime
    * *Java* runs on machines which has the Java Runtime Environment or Java Software Development Kit downloaded.
    * *JavaScript* runs in nearly every browser worldwide. Can also run outside of browsers (e.g. "node.js").
* Hello, World!
    * *Java*: `public class Main {public static void main(String[] args){System.out.println("Hello, World");}}`
    * *JavaScript*: `console.log("Hello, world!")`
* Object-orientation
    * *Java* claims to be OO, but actually is class-centric. Plus, primitive values aren't objects at all.
    * *JavaScript* is actually object-centric. Even functions are objects which can contain fields!
* Classes
    * *Java*: requires all code and data to belong to a class or object.
    * *JavaScript*: sure, if you want classes we can do that without much fuss.
      But it's *objects* which are central.
* Threading
    * *Java*: Multiple lines of Java can be executing *simultaneously*, each in its own "thread".
      Doing this correctly is difficult, and hard.
      We will give you some rules-of-thumb to keep you out of trouble, but much of threading is beyond the scope of this
      bootcamp.
    * *JavaScript*: Only one line of JavaScript will run at a time (though the browser will be doing multiple things
      simultaneously on your code's behalf, like downloading multiple URLs simultaneously. `fetch` and `promise` are
      JavaScript's answer to waiting for external events, and `eventListener` is its answer to defining UIs.
* Arrays
    * *Java*: indexed from 0, retrieved using `[]` syntax. But want to change the size ... congratulations, you can't
      unless you just make a new array with the new size.
    * *JavaScript*: indexed from 0, retrieved using `[]` syntax. They function like very much `ArrayList`, except
      you `.push` and `.pop` rather than `.add` and `.remove(o.length() - 1)`
* Arrays
    * *Java*: `myArray[-1]` and `myArray[-2]` crash
    * *JavaScript*: `myArray[-1]` and `myArray[-2]` yield the last or second-to-last values in the array. Quite nice.
* Array length
    * *Java* `(new int[]{"a", "b", "c"}).length == 3`
    * *JavaScript*: `["a", "b", "c"].length == 3`
* Reading/writing structured data
    * *Java*: Spring offers some magic to read/write JSON-formatted data.
    * *JavaScript*: Um, JSON stands for "JavaScript Object Notation". Json is valid JavaScript code as-is.
* Fields
    * *Java* Accessed through `o.fieldName`.
    * *JavaScript* Accessed through `o.fieldName` or `o['fieldName']`, so you can have *computed* field names.
* Variable declaration
    * *Java* Variable declarations must specify the type of the variable, e.g. `final VirtualPet myPet;`.
    * *JavaScript* Variable declarations don't specify the type of the variable, e.g. `myPet = {"name": "astro"}`.
* `var` keyword
    * *Java*: `var` is the new hotness which allows you to avoid explicitly specifying variable types when Java can
      figure it out on its own.
    * *JavaScript*: `var` is an abomination which needs to be buried at least ten feet underground. Use `const` to
      declare "final" variables and `let` for variables which can't be final.
* Anonymous functions
    * *Java* uses `->`, e.g. `(s) -> s+1` or `s -> {System.out.println(s); return s+1;}`
    * *JavaScript* has *two* ways to define an anonymous function
        * uses `function`, e.g. `function (s) {Console.log(s)}`
            * This is the older syntax, which hearkens back to the 1950's.
        * uses `=>`, e.g. `(s) => s+1` or `s => {Console.log("Hello world"); return s+1}`
            * This happened when JavaScript got jealous of Java's `->` syntax. (I'm making this up.)
* Error-handling
    * *Java*: "a".substring(0,2) will crash the program unless the resulting exception is caught
    * *JavaScript*: "a".substring(0,2) will return "a" without complaint. (
      e.g. https://the-winter.github.io/codingjs/exercise.html?name=front22&title=Warmup-1)
* Equality
    * *Java*: For non-primitives be sure to use `.equals` ... and the owner of the class gets to define what that means.
    * *JavaScript*: Congratulations, you get to choose between `==` (i.e. mostly equal) and `===` (i.e., really equal --
      but rather similar to Java's `==`). Here, `5 == "5"`.
* Comments
    * *Java*: `//` for single lines and `/* ... */` for blocks.
    * *JavaScript*: `//` for single lines and `/* ... */` for blocks.
* Imports
    * *Java*: `import` is just a way to save typing when accessing classes in other packages
    * *JavaScript*: `import` loads and executes the specified library
* Modern for loops
    * *Java*: `for (var s : someList)`
    * *JavaScript*: `for s of someList` [^JSIn]
* Ease of use
    * *Java*: easier to write programs that work correctly
    * *JavaScript*: easier to write programs

[^JSIn]: JavaScript also offers `for i in someList`, but that causes `i` to take on the values of the *indexes*
to the list (0, 1, ...) rather than the values in the list.

## Useful Javascript idioms

* Iterate character-by-character along a string: `for (c of thisString) {}`
* Larger of two values: `Math.max(a,b)`
* https://the-winter.github.io/codingjs/exercise.html?name=arrayFront9 `return nums.slice(0,4).findIndex(n => n==9) >= 0`
* https://the-winter.github.io/codingjs/exercise.html?name=hasTee `return [a,b,c].some((n) => n>=13 && n <= 19)`
* https://the-winter.github.io/codingjs/exercise.html?name=atFirst `return ((str.substring(0,2)) + "@@").substring(0,2)`

## Dynamic Javascript Pages and synchronous vs. asynchronous

* We have a HTML page, and it's probably loading in .css and .js resources.
  It probably has some literal HTML text, which the browser will interpret and create an initial DOM tree, containing
  one element per HTML tag in the initial download.
  Some of these html elements, like "button", can have javascript associated with them, and this JavaScript can do just
  about anything you could imagine in response to user actions.
  So you could have a button that adds a row to a table, or a button that causes part of the display to disappear
  temporarily.
* BUT ... everything above occurs essentially instantanously ... if you press a button and it adds a row to the table,
  all of that can occur before Chrome does the next thing.
    * You press button; JS executes and adds elements to the existing DOM, or modifies the existing DOM; Chrome redraws
      the screen.
    * But the world isn't instantaneous. If I have a button that says "go to http://localhost:8080/categories", my web
      server does not respond instantaneously. And things are even worse if the server is in Australia.
    * So how we handle this?
    * But functions just return values, so we need JavaScript to do something magical.
* Answer: `fetch` and `promise`.
* Vocabulary:
    * Asynchronous --> Not happening at the same time ... if I ask a web server, I don't get an instantaneous response
        * Email is asynchronous
        * Special features are necessary to handle async easily,
          e.g. https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
          And https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
        * 99% of the time, a simple `fetch().then().then()` or perhaps `fetch().then().then().else()` will suffice.
    * Synchronous --> Occurring without waiting.
        * A telephone call is synchronous
    * In-between
        * Slack can be either.
    * Programming is *MUCH* easier when everything is synchronous. When you've been coding PetShelter, you never have to
      deal with the shelter saying "i'll you that list later today" ... you've been getting immediate responses.
    * It would be nice if we could program everything without having to worry about delays in getting responses.
    * But we can't avoid this when writing client-side javascript code, because web servers always have delays.

## Events

* To play around with the various event listeners:

```
  function createDiagnosticListeners(thisElement) {
   const listOfEventNames = ['abort', 'afterprint', 'animationend', 'animationiteration', 'animationstart', 'beforeprint', 'beforeunload', 'blur', 'canplay', 'canplaythrough', 'change', 'click', 'contextmenu', 'copy', 'cut', 'dblclick', 'drag', 'dragend', 'dragenter', 'dragleave', 'dragover', 'dragstart', 'drop', 'durationchange', 'ended', 'error', 'focus', 'focusin', 'focusout', 'fullscreenchange', 'fullscreenerror', 'hashchange', 'input', 'invalid', 'keydown', 'keypress', 'keyup', 'load', 'loadeddata', 'loadedmetadata', 'loadstart', 'message', 'mousedown', 'mouseenter', 'mouseleave', 'mousemove', 'mouseover', 'mouseout', 'mouseup', 'mousewheel', 'offline', 'online', 'open', 'pagehide', 'pageshow', 'paste', 'pause', 'play', 'playing', 'popstate', 'progress', 'ratechange', 'resize', 'reset', 'scroll', 'search', 'seeked', 'seeking', 'select', 'show', 'stalled', 'storage', 'submit', 'suspend', 'timeupdate', 'toggle', 'touchcancel', 'touchend', 'touchmove', 'touchstart', 'transitionend', 'unload', 'volumechange', 'waiting', 'wheel']

   if (thisElement.id) {
     for (const eventName of listOfEventNames) {
       thisElement.addEventListener(eventName,
                                    (event) => {console.log("Id: " + thisElement.id + "; event: " + eventName + "; value: " + event.target.value);
                                                event.stopPropagation()
                                               })
     }
   }

   // Recursively do the same for each child
   for (childElement of thisElement.children) {createDiagnosticListeners(childElement)}
  }
```

## Other JavaScript Thoughts

* Yes, JavaScript does classes (https://www.w3schools.com/js/js_classes.asp), but hopefully your JavaScript won't be so
  fancy as to need to create your own.
* The world is switching to JavaScript Modules (https://www.w3schools.com/js/js_modules.asp), so use them rather than
  oldstyle code importing.
* `document.getElementById("unique_id")` is horribly verbose. JQuery allows you to type `$(#unique_id)`, and offers
  *many* other shortcuts. However, JavaScript is improving over time, and so needs jQuery less. But more importantly,
  higher-level frameworks (e.g. React) allow an entirely different
  approach. https://www.w3schools.com/js/js_jquery_selectors.asp
* A JavaScript clock can be as simple
  as `window.setInterval(() => document.getElementById("clock").innerText = Date(), 1000)`.

## overview

* JS really good at event-driven behavior (at least when the event occurs locally) ... when ___ happens, so _____.
* JS really good at GETing and POSTing to REST APIs which return JSON.
* JS really good at constructing HTML dynamically based on what it gets from REST APIs.
* JS really good at adding/removing .css "class" to elements, so it works well with CSS (though there is very little
  overlap).
* JS is ok at doing things every "_ seconds".
* JQuery really good at making JS easier to use. To be fair, modern JS is much easier to use than it was 10 years ago.
* CSS really good at making well-designed and pretty.
* Thymeleaf really good at service-side merging data and templates.

### Virtual Pet shop requirements

* Login and see current pets available ==> Hit an REST endpoint and get a JSON list, create DOM table with JSON, and add
  appropriate styles.
* Have an adopt button on each row, and hit a POST endpoint if it is clicked ==> Pretty straightforward as well.
    * And then have the new list of pets show on the screen.
* Walk all pets button --> and that first walk the pets and then ask for all of their status and display them.
* Missing behavior ==> we won't have a good solution for this until we do React. Raw JavaScript *can* do this, but it's
  a bit ugly.
    * I login and see the list of pets, and then take my hand off the mouse and keyboard
    * Somebody logins, sees the list, adopts one.
    * Missing behavior is updating my screen automatically.

## CSS

* **Cascading Style Sheets** -- The style layer of the front end. Linked to the HTML document and with the use of
  selectors a CSS can transform individual, or groups of elements within an HTML doc.
* **types of selectors**:
    * **Elements Selectors** -- The least specific of the selectors use to select all elements wrapped in a
      tag `element{css-goes-here;}`
    * **Pseudo Selectors** -- Used to select elements by the attributes they have `input[type="text"]{css-goes-here;}`
    * **Class Selectors** -- Classes must be applied to HTML elements first to be referenced by CSS. Referenced
      by `.CLASS-NAME`
      Multiple HTML elements can be defined by the same class
      HTML:`<div class="my-class"></div>` CSS: `.my-class{css-goes: here;}`
    * **ID Selectors** -- Just like classes, ID's must be applied to HTML elements first to be referenced by CSS.
      Referenced by `#class-name`
      Unlike classes, ID's can only be applied to on HTML element at a time. Duplicate ID's will have conflicting
      results in your HTML, leading to undesired styling. HTML:`<div id="my-id"></div>` CSS: `#my-id{css-goes: here;}`
    * **Chain Selectors** -- With CSS you are able to chain together selectors to reference multiple elements
      `element another-element .class-name one-more-element{css-goes: here;}`
* **Default Styles** -- Each browser has default style rules, some CSS stylings can conflict with the default browser
  stylings.
  It's a good rule to disable any default stylings through the browser dev tools `ctrl + alt + i`
* **Colors** -- There are 4 ways to declare colors within CSS.
    * **Hexadecimal** -- # followed by 6 characters with any configuration of `0-9` and `A-F`. The first two digits
      specify red on a scale from `00` to `FF`, then green, then blue, e.g. `#0000FF` is blue.
    * **Hue, Saturation, Lightness, Alpha**
        * h: degrees on a color circle 0-360
        * s: saturation 0%-100%
        * l: lightness 0%-100%
        * a: alpha 0.0 is entirely transparent, and 1.0 is entirely opaque.
    * **Color Name** -- There are currently 140 defined colors in CSS refer to:
      https://www.w3schools.com/cssref/css_colors.php for the list. `MediumOrchid`,`GoldenRood`, or just `Blue` are
      examples.
    * **Red, Green, Blue, Alpha** -- RGB have values of 0-255, while alpha is opacity ranging from 0.0 to
      1.0. `0,255,0,1` is opaque green.
    * **Units** -- There are multiple units of measurements in CSS: some dynamic and some static.
        * **`px`** -- Refers to pixels on a screen. Screen sizes are not universal so be careful in using this.
        * **`rem`** -- Root em. Refers to the default font size of the root element HTML in most cases.
        * **`em`** -- Relative to the font size in containing elements.
        * **Percentage** -- Relative to the size of the parent element `element{300px}` `element h1{width: 50%}` = 150px
        * **Viewport Height`vh` & Width`vw`** -- This is measured based on the X (0 would be the left most area of the
          Viewport 100 is the right most.)
          and the Y (0 would be the top of the Viewport. 100 is the bottom) axes. `
          img{height: 50vh; width: 50vw;}` would put something directly in the middle of the Viewport.
        * **Font Stack** -- Font stacks are used for applying fonts for elements. CSS will pick the first declared font
          and continue down the stack
          based on what is available to the user. `h1{font-family: Cambria, Utopia, Times-New-Roman}` Cambria will be
          displayed if available, if not Utopia... etc.
        * **CSS Variables** -- Just like Java you can declare Variables in CSS. These must be declared in the `:root{}`
          element in your CSS.
          `:root{--my-variable-color: blue;} p{background-color: var(--my-variable-color);}`

## Programming styles

### Programming Overview

* Software development is not graded like a high-school or college course. You'll be working on a team, and you will be
  doing your work in a git branch, and when you say you're ready your work will be reviewed *before* it will be merged
  into the main development branch. Your work will *not* be merged until is is _acceptable_ (i.e. it has passed all
  requirements for code to be accepted). Acceptance criteria include:
    * Compliance with coding standards, including stylistic things like formatting and comments.
        * Java offers **JavaDoc** syntax.
          `/** Documentation */`.
          I would strongly suggest that code is not "done" until it has JavaDoc for each class describing what that
          class's single purpose in life is. (And each class should have a single purpose.)
          I have less-strong feelings about requiring that every method (and parameter thereof) have JavaDoc
          documentation ... if the methods and parameters are well-named, it really should not be necessary -- but you
          very well be hired by a team which requires that level of documentation before a Pull Request will be
          accepted.
    * The code is *clean*, and consistent with the practices of already-existing code in your organization.
    * The use (e.g. public interface) of your new code is clearly documented.
    * You can answer the question: "how do you *know* that the code functions as desired?"
    * You can answer the question: "how do you *know* that adding this code doesn't break other parts of the system?"
* Code will go through as many review cycles as are necessary, until the review(s) judge the code acceptable.

### Approaches for organizing software development

* **Agile** -- depending on the context, either a buzzword used by micromanagers or a radical restructuring of the
  workplace.
    * A set of values -- https://agilemanifesto.org/
        * "Individuals and interactions over processes and tools"
        * "Working software over comprehensive documentation"
        * "Customer collaboration over contract negotiation"
        * "Responding to change over following a plan"
    * A set of principles -- https://agilemanifesto.org/principles.html
        * "Our highest priority is to satisfy the customer through early and continuous delivery of valuable software."
            * This means that code only be merged into the primary Git branch once it is *done*.
            * This means that each function we add has value.
        * "Welcome changing requirements, even late in development. Agile processes harness change for the customer's
          competitive advantage."
            * With a weekly Scrum cycle (see below), the product owner can have radically-different priorities for next
              week's sprint.
        * "Deliver working software frequently, from a couple of weeks to a couple of months, with a preference to the
          shorter timescale."
            * With internet delivery, delivery cycles of just a week (or even shorter) are common now.
        * "Business people and developers must work together daily throughout the project."
            * This is vital. The team needs ready access to a *decisionmaker* ... not just a liaison to the
              decisionmaker.
        * "Build projects around motivated individuals. Give them the environment and support they need, and trust them
          to get the job done."
            * Note that there's no "manager" mentioned anywhere here!!!
        * "The most efficient and effective method of conveying information to and within a development team is
          face-to-face conversation."
            * Fortunately, Zoom is also face-to-face.
        * "Working software is the primary measure of progress."
            * (And the definition of working is the User Story.)
        * "Agile processes promote sustainable development. The sponsors, developers, and users should be able to
          maintain a constant pace indefinitely."
            * If the team completes the Sprint Backlog early, it can always pull another story from the Product Backlog.
        * "Continuous attention to technical excellence and good design enhances agility."
            * 100%.
        * "Simplicity--the art of maximizing the amount of work not done--is essential."
            * One important part of the Sprint Retrospective is to see how automation can reduce menial work done by the
              team.
        * "The best architectures, requirements, and designs emerge from self-organizing teams."
            * https://en.wikipedia.org/wiki/Conway%27s_law
        * "At regular intervals, the team reflects on how to become more effective, then tunes and adjusts its behavior
          accordingly."
            * Again, this is the team self-organizing.
* **Scrum** -- A set of practices which *implement* the agile values and principles.
    * **Scrum Team** -- A self-organizing and cohesive group of developers
        * The **Scrum Master** is an advisor to the team, helping it function more collaborative and efficiently, but is
          not part of the team.
        * The team itself is responsible for the code generated by the team -- not any individual. While individuals on
          the team may have specific expertises, every team member should understand everything created by the team.
    * **Product backlog** -- A ranked list of user stories
        * The team and the Product Owner collaborate on adding and defining the stories.
          The Product Owner ranks them in priority order (or at least ranks the most-important stories ... stuff far
          back in the backlog can be dealt with later).
        * Stories are defined using user-centric language, "as a _____, I need to _____, so that _____".
            * (Hardcoded examples) "As salesperson, I need to be able to display two stylesheets with the same structure
              but different colors, so I can do demos and sell this to investors."
                * Development team: "oh, thats medium-to-small"
            * (READONLY User) "As a website developer, I need to be able to download CSS based on styleNumber, so my
              site is pretty."
                * Dev team: "oh, that's medium if there's just one color knob to turn, but super-hard if one knob
                  determines how many other knobs there are"
            * (WRITING User) "As a graphic designer, I need to be able to modify the colors for a given styleNumber, so
              my stylesheets are purchased by developers."
        * The team assigns a "size" to each story for planning purposes.
        * Smaller stories are much better. At the end of the week, the question is: "which stories are *done*?". There
          is no partial credit.
    * **Sprint** -- The cadence at which the team works, typically one or two weeks in length (though it could be
      larger).
        * **Sprint Planning** -- The team takes as many items from the highest-priority end of the product backlog as
          they believe they can sustainably complete during the sprint. They verify with the Product Owner the plan for
          the sprint, and then move these user stories into the "Sprint Backlog".
        * Each user story will progress from "Sprint Backlog" to "In Progress" to "To Be Verified" to "Done". You can
          imagine post-it notes moving to the right on the wall.
            * A healthy sprint board has only a handful of items "In Progress" or "To Be Verified" at any given time. In
              particular, moving items from "To Be Verified" to "Done" should be higher priority than other tasks.
            * Perhaps the most important decision the team will make is to create their definition of "Done" -- and it
              should be a strong definition. If the task is "sort of working" but will require additional work next
              cycle, most teams would not consider that "Done". I would not consider a task "Done" until it has
              automated tests verifying its core functionality.
        * Throughout the Sprint
            * The day begins with a very short **standup**, with each team member telling the team of their plans for
              the
              day and identifying any blockers. If the team can resolve the blockers internally (e.g., others on the
              team assist), that is perfect. If the blockage is external, the Scrum Master may assist.
            * The Product Owner (i.e., someone with decision-making power) is readily accessible to the team. This is
              vital.
            * Anyone can throw new items onto the Product Backlog. A good Product Owner will reorganize the Product
              Backlog so the highest-priority items are identified.
        * At the end of the Sprint:
            * **Sprint Review** -- The team presents completed tasks to the Product Owner (and perhaps a wider
              audience).
            * **Sprint Retrospective** -- Guided by the Scrum Master, the team reflects on how it performed during the
              sprint and how it can incrementally improve itself.

### Approaches for writing acceptable code.

* **OO** -- An Object-Oriented programming style
    * **abstraction**: separating what's essential for a particular use from what isn't. Code to interfaces whenever
      possible.
        * "Thin interfaces" better than "fat interfaces".
    * **polymorphism**: the Race class can call `contestant.turn()` and Java will ensure that the right method is
      called, depending upon the *actual* class of the object implementing Contestant.
        * Polymorphism is easiest to explain if one considers the case of an interface implemented by two concrete
          classes, and a variable whose type is that of the interface.
        * Consider the following code:
          ```
          // This example is *NOT* polymorphism
          final RaceCar raceCar = new RaceCar();          // We're *remembering* the exact class
          final RaceTruck raceTruck = new RaceTruck();
          raceCar.turn();
          raceTruck.turn();

          // This example *is* polymorphism
          final Contestant contestant1 = new RaceCar();   // We're *forgetting* the exact class
          final Contestant contestant2 = new RaceTruck();
          contestant1.turn();    // Without us doing anything, Java on its own will look to see the actual type and call the right method
          contestant2.turn();
          turnSomething(contestant1);
          turnSomething(contestant2);
          
          public void turnSomething(final Contestant c) {c.turn();}
          ```
    * **inheritance**: when one class extends another.
        * When one class extends another, the subclass has some methods defined in itself and other methods defined in
          its parent or grandparent, etc.
        * When a class implements an interface, it gets obligations from interface. (I.e. a set of methods it promises
          to implement.)
        * When a class extends another class, it gets implementations from its parent. Sometimes it will override that
          behavior, and other times it won't.
    * **encapsulation**: when a RaceCar contains an Odometer rather than trying to do that behavior
      itself https://github.com/marshallfWCCI/RaceCarInterface/commit/92e8da66095290ebdb11e4e53e04cede7639f787
        * You should think of this as one object containing another object, rather than a class containing another
          class. The latter is for "inner classes", which is an advanced topic we try to avoid.
    * Note: you will see the acronym "A PIE" to remember the above, but I dislike it because abstraction (programming to
      interfaces), polymorphism (the magic which allows abstraction to work), and encapsulation are essential to OO
      programming, but inheritance is usually a way to reduce duplicate code when classes don't encapsulate well.
    * In general, classes should know about other interfaces, not other classes.
        * When designing OO programs, the primary question is: who needs to know what?
    * SOLID
        * Single responsibility principle -- each class should have one job.
        * Open/closed principle -- parent classes should not know about the existence of subclasses, and certainly
          should not need modification for new children to be added.
        * Liskov substitution principle -- if you can do something with an instance of the parent class, then you also
          should be able to do the same thing with an instance of the child class.
        * Interface segregation principle -- more smaller interfaces better than fewer larger interfaces.
        * Dependency inversion principle -- Spring is Magic.
* **Imperative** -- A programming style in which the system is told what to do step-by-step.
* **Declarative** -- A programming style in which the system is told the desired state and isn't micromanaged in the
  executed.
    * `build.gradle` is declarative.
    * SQL is probably the most famous declarative language. You tell the database which tables to merge together and it
      decides the best strategy for doing so.
* **Structured** -- An imperative programming style in which statements are organized into nesting contexts.
* **Inversion of Control** or **Dependency Injection** -- a style of programming in which classes can do two things:
    * Define how to create instances of classes, and trust the framework to call those constructors when necessary.
    * Define what instances one expects and trust the framework to provide them as necessary.
    * In other words, Spring is *magic*.
    * Another example:
        * Most code has zero idea which database it's using. Instead, it provides constructors which are passed the
          information they need.
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
    * **Fluent Pattern** -- Methods which end with `return this;` (or returning a related object) so that multiple
      methods can be called on a single object in a single statement. Highly related to "functional programming".
        * Note that the methods don't actually have to end with "return this" ... they just need to return some object
          upon which further method calls can be made.
        * The most commonly-used fluent pattern is streams
            * `list.stream().filter((x) -> (x > 0)).map((x) -> (2*x)).collect(Collectors.toList());`
            * But what do you do if you're starting with a `[]` array.
              The problem is that arrays aren't really objects, and so they don't have methods, so we can't just
              say `.stream()` on the array.
                * The answer is to call a *static* method on the `Arrays` class, e.g. `Arrays.stream(myArr)`.
                * And we need to do this static nonsense because not everything in Java is an object.
* **Refactoring** -- Simplifying your code without changing its behavior.
    * If you're doing TDD, refactoring can occur anytime: (1) all tests are currently passing, and (2) you've already
      committed to git.
    * Refactor in as small steps as humanly possible.
        * Rename a single method or field, and then run your tests again.
        * If you're introducing an interface to a class which currently doesn't implement any interface, start with an
          empty interface, and add one method at a time.
        * Refactor early and often.
    * Refactoring should not be done just because you think the code will be faster ... that's an entirely separate
      discussion. Refactoring should be to make the code cleaner.

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

* **Convention over Configuration** -- Put things where the framework expects and you don't to tell it explicitly.
    * IntelliJ *expects* that code will be in src/main/java and src/test/java.
      If you that, your configuration is *much* easier.
    * Spring *expects* that all components you wish for it to discover are in either:
      (1) in the same package as the class annotated with `@SpringBootApplication`, or
      (2) in a subpackage thereof.
    * Spring will automatically serve static resources such as an index.html in `src/main/resources/static`,
      e.g. `src/main/resources/static/index.html`.
    * Spring expects to find Thymeleaf templates in `src/main/resources/templates`

## Code exploration styles

* Make fields and methods `final` and `private`, and see if IntelliJ complains. Remove apparently-unused constructors
  and see if IntelliJ complains. Add `@Override` annotations if you think a method might be overriding something in the
  inheritance tree...if you're wrong IntelliJ will tell you and you'll learn something.
* Create a minimal example and then step through with the debugger.
* Checks for conditions which you believe are impossible, and then log them.
* For Spring applications, https://en.wikipedia.org/wiki/Gene_knockout works well for understanding how the components
  fit together ... temporarily remove an annotation and see what happens. (In the real world, if you're using Spring
  then you'll have IntelliJ Ultimate Edition rather than IntelliJ Community Edition, and there are more tools to
  visualize how Spring wires beans together.)

## More Java keywords

* `@Override` is an example of an **annotation**.
    * `@Override` identifies when a method is either required by an interface or redefines an existing method (this case
      we'll talk about tomorrow). `@Override` is put on the method in the subclass.
    * The parent class should either:
        1. Not know or care if the method is overridden or not, or
        2. Explicitly prohibit overriding by putting the `final` keyword on the method, or
        3. *Force* the child classes to implement the method by not providing an implementation at all. (Such parent
           classes will be abstract, of course.)
* `@Deprecated` is an annotation which merely tells other coders not to use this method, and is likely to be removed in
  future releases. Also sometimes used if a given method should *only* be used in very special cases.
* **Instance variables** -- the fields you've seen belonging to object instances.  (There is also a concept of **class
  variable** which should only be used in very specific instances, which we might not even encounter this course.)
* `extends` -- A **subclass** `extend`s another `class`. If we tell Java that C extends B and B extends A, then C
  extends A (even if we don't explicitly say so).
* `super()` -- The first line of most constructor will be to call the constructor of its parent class. `super` is the
  same as `this` except that it refers to the fields and methods of the parent class.
* `abstract` -- A class which has partially-defined behavior and so cannot have instances. But it will have **concrete**
  subclasses which may create instances as long as they implement all of the missing methods.
    * `abstract` is the opposite of "concrete".
    * Suppose that `Food` is the parent class, `Apple` is the child class. Food can have properties, like
      .getCalorieCount(). But you can't get a can of "Food". You can get an apple.
    * Classes which can't be instantiated (fancy word for creating instances) because they don't implement all of the
      behavior they promise are called "abstract".
    * The only reason to have an abstract class is when you want to create subclasses which share some behavior.
* **Class Hierarchy** -- a diagram showing which classes extend and/or implement other classes and interfaces. For
  instance, https://en.wikipedia.org/wiki/Java_collections_framework#/media/File:Java.util.Collection_hierarchy.svg
* **Visibility** (of data and behavior)
    * `final` -- Write-once. May not be modified after it is set.
    * `private` -- Only visible within the defining class. (Most restrictive, and there easiest for the reader.)
    * `protected` -- Only visible within:
        * (1) the defining class
        * (2) children (really, descendants) of the defining class
        * (3) classes in the same package as the defining class (this is the one I forget).
    * `public` -- Visible everywhere. (Unrestricted)
    * Rule: use `private` when you can, otherwise `protected`, otherwise `public`
* `package` -- The directory where the class is defined. Code in `src/main/java/org/wcci/marshall/project1`
  and `src/test/java/org/wcci/marshall/project1/` lie in package `org.wcci.marshall.project1`.
  Many core classes lie in subpackages of `java`, e.g. `java.util`.
  The first letter of each component should be lowercase.
  The first part of the package should be designed to not overlap with projects created in other organizations, hence
  the `org.wecancodeit.` prefix.
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
    * Exceptions are great, because they allow you to *immediately* exit the current program flow when you encounter a
      problem. Exceptions are confusing, because they exit the current program flow from the middle. Only use Exceptions
      when there is a problem -- not just as a way to exit out of a loop; changing the return type to something
      like `Optional<T>` is preferable when your logic allows it.
    * As shorthand, we say that a method is "throwing an Exception" ... but the truth is that we're actually throwing a
      object which is an instance of the `Exception` class (or one of its subclasses). As whenever you define a
      subclass, you can add whatever fields you wish and add parameters to constructors to populate those fields. It is
      often quite useful to include useful diagnostic information (e.g., what was the name of the file you couldn't
      open) when throwing exceptions. At the very least, nearly all Exception constructors allow you specify a `String`
      message.
    * Many constructors also allow you to include *another* exception in the constructor. (E.g., I could write code
      which catches a standard exception like `NullPointerException` and makes it a parameter to another throw.
      in `try {} catch (NullPointerException e) {throw new PetNotFoundException("Pet " + petName + " not found", e);}`)
    * If you are writing a large application and are creating multiple subclasses of Exception (e.g., one for each
      unexpected condition), it is quite convenient to have them all descend from a parent class (
      e.g. `class PetNotFoundException extends MyApplicationException`).
    * Other than Exceptions descending
      from `RuntimeException` (https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html), every method
      which *might* throw an exception *must* declare so in its signature. Exceptions which must be declared are
      called "checked exceptions" and descendants of `RunTimeException` are called "unchecked exceptions".
    * Instead of having to write `public void doIt() throws PetNotFoundException, ShelterNotFoundException`, having a
      common parent allows us to write `public void doIt() throws MyApplicationException`.
    * It's easy to get into a pattern in which every method is declared to possibly throw MyApplicationException, but
      methods which don't throw exceptions are easier to reason about and put less burden upon those who call them.
    * Suppose you're a method which receives a filename and is supposed to read from the file and do something with it.
      And you ask `System` to open that file and it refuses. You will receive an exception which not only says "unable
      to open file", but is likely to give a reason why (e.g., "file doesn't exist", or "you don't rights to read the
      file", etc.) And the exception will contain both the name of the file and perhaps the reason.
    * In addition, Exceptions contain the entire stack trace of where they occurred (e.g. A() called B() called C()
      called D() and the exception occurred in D()).
* `enum` -- Defines a small set of possibilities. Can do many of the things a `short` can do (e.g. be part of a `switch`
  statement).

# Control flow

* `while(condition) {statements;}` -- the simplest loop.
* `do {statements;} while (condition)` -- only use when you can't check the condition before the loop runs.
* `for (int i = 0; i < n; i++) {statements;}` -- the classic way to index into an array of size `n`.
    * **Increment** -- to add 1 to something.
    * **Decrement** -- to subtract 1 to something.
* `for (Contestant contestant : contestants) {statements;}` -- the modern way to iterate through any collection.
    * The thing to the right of the `:` can be *anything* which can supply values one-by-one. It can be an `array`,
      or `List<T>`, or `Set<T>` or `map.getValues()` or `map.getKeys()` or anything which is "Iterable".
    * The thing to the left of the `:` is just the type and name of each such value. Basically, every collection-like
      thing in Java is
      Iterable -- https://en.wikipedia.org/wiki/Java_collections_framework#/media/File:Java.util.Collection_hierarchy.svg
* `break` -- Immediately exit the current loop (or switch block)
* `continue` -- Immediately go to the top of the loop for the next iteration.
* `switch(val) {case val1: ... default: }` -- Java finds the first case that matches and starts running code at that
  point.
    * In a switch statement, either: (1) every statement has a `break;` or (2) none do -- be consistent.

# Containers

* `Collection<V>` -- even more generic than a `List` or
  a `Set`.  https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
    * Technically, it's a "bag" of stuff.
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
    * Good when you only care about the last value for a given key, because multiple `.put()` on the same key will
      overwrite.
    * HashMaps operate by allocating all its elements into many rooms, so that each room contains only a handful of
      entries. And given the key, it is super-fast to find the right room. And once you know the room, there are only a
      handful of entries to check one-by-one.
    * .equals() and .hashCode() need to make sense (and be consistent with each other) for `K`'s and there really should
      only be one `V` for any given `K`.
    * `V`'s can be anything, even other Lists or Maps.  `Map<String, List<Integers>>` is perfectly fine.
    * Technically, `Map` is not a container because you can't iterate it. But Map exposes three methods which return
      containers:
        * `.getKeys()`
        * `.getValues()`
        * `.getEntries()`
* `Iterable<V>` -- Something which can be after the `:` in `for (V value : values) {}`. All lists, `map.keySet()`,
  and `map.valueSet()` are all iterables.
* `Stack<V>` -- A list with easy access to the last element. Think a spring-powered plate dispenser in a cafeteria.
    * `.pop()` -- removes the last element and returns it if you care about its value.
    * `.push()` -- adds to the end of the list.
    * `.shift()` -- like `.pop()` but removes the *first* element.
    * `.unshift()` -- like .push()` but inserts at the first location and everything else slides to the right.
* `Set<V>` (e.g. `HashSet<V>`) -- like a list but forgetting the order in which elements were inserted.
    * If the "same" element is added twice to a Set, it is only stored once. ("Same" is of course defined
      by `.equals()`.)

# Why do we write unit tests?

* To better understand what our classes are supposed to do
* To make sure that our classes do what we think they do
* To make sure that our code keeps on working.

# The Truth about Java

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
* Variables in Java are not objects -- they are references to objects. And that reference can be `null`. And if you try
  to call a method on a variable whose value is `null`, you get a `NullPointerException` and if you catch it, your
  program will crash.
* So, `map.get("Nonexistent Key")` returns null, but that's lousy design.
* A better design is for our methods to return something like `Optional<Odometer>`, and this means that the return is
  *either* an Odometer or nothing.
* It is almost exactly the same as a list which can have exactly 0 or 1 elements.
* It should be used when you're not guaranteed to actually return an object.
* When you get an `Optional<T>`, you *have* to check whether it is populated before you use its actual value.
* Without Optional, you could just "tell" your callers to check to see if the returned value `==null`, but people don't
  listen.
* If you need to work with an Optional:
    * You just want to *do* something, `ifPresentOrElse` works wonderfully:

    ```
    final Optional<Category> perhapsCategory = categoryRepository.findById(category_id);
    perhapsCategory.ifPresentOrElse(
       // what to do if category was found
       (category) -> {
           categoryRepository.delete(category)
       }, 
       // what to do if category is not found
       () -> {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot delete nonexistent category " + category_id)
       });
    ```

    * If you need to return data, then `.map()` and perhaps `.orElseGet()`

    ```
    return categoryRepository.findById(category_id)
                .map((category) -> category.getReviews())
                .orElseThrow(() -> {
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find category " + category_id);
                });
    ```

# The Internet

* **URL** -- Universal Resource Locator, e.g., `http://google.com`, `https://wecancodeit.org/about-us/`,
  or `mailto:Admissions@WeCanCodeIT.org`.
* **server** -- A process which is running continuously on machine, accepting connections from clients and interacting
  with them.
* **client** -- A process (like Chrome) which connects to a server process.
* `netstat -n` -- A bash command showing your current connections between clients and servers.
* **DNS** -- Maps from human-readable domains (e.g. wecancodeit.org) to actual computer IP addresses (e.g.
  159.65.180.149).  https://dns.google/query?name=wecancodeit.org&rr_type=ALL&ecs=&show_dnssec=true
* **IP Address** an address on the internet. https://whatismyipaddress.com/ip/159.65.180.149
* **Port Number** -- Each server process on a machine listens on a different port number.
    * 80 and 443 -- The server locations ("port number") for http and
      https.  https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers
    * 8000, 8080, 8088 -- common port numbers for test http servers. (There are multiple numbers because sometimes you
      want multiple test servers on a single machine for different uses)
    * 3306 -- the default port number for MySQL
    * `netstat -an | grep LISTEN` -- A bash command to see the current ports your machine has processes listening on.
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
        * Chrome does this all day every day.
    * Retrieve a list of items (GET)
        * Should not change the state of any resource.
    * Update an item (PUT) "Hey, item #23 should contain this data"
        * Should be **idempotent** (which is a fancy word for a requirement that calling PUT twice with the same
          information should be the same as just calling it once).
        * Chrome does this when you have a form and click "submit"
        * Real-life examples of idempotent operations:
            * Converting a color picture to black-and-white.
            * Washing a plate. (Once-washed plates and twice-washed plates are the same.)
            * Tuning to a radio station.
        * Question: is map.put(key, value) "idempotent"?
        * Question: is list.add(value) "not idempotent"
    * Create an item (POST)
        * Typically returns the created resource. Not "idempotent", which is why sometimes your browser will ask say
          something like "reloading this page will resubmit the data".
        * Chrome does this when you have a form and click "submit"
    * Delete an item (DELETE)
        * Typically returns the deleted resource.
        * Chrome does this when you have a form and click "submit"
    * Partially modify an item (PATCH)
        * (Less commonly used.)
        * Chrome does this when you have a form and click "submit"

# **Spring Boot**

* **Spring** -- a widely-used and powerful framework for creating Java servers. Spring scans your code for annotated
  Java entities (classes, interfaces, methods, fields, etc) and connects them altogether into a production-ready
  application``.
    * This pattern of: (1) components identifying what resources they require (e.g. with `@AutoWired`),
      (2) components identifying what resources they could make available, and
      (3) a framework detangling these dependencies and passing to each component the
      dependencies it requires is called **Dependency Injection**
      e.g., https://en.wikipedia.org/wiki/Dependency_injection.  
      The process of linking everything together is sometimes called "wiring it together".
        * So, our RestController says that it needs a Repository. But we can't make a repository yet because the
          repository needs an entity first. What Spring does is figure out, hey, I could could first make an entity, and
          then make a repository, and then make a controller.
    * `@AutoWired` is sort of the core of understanding Spring.
    * Spring only exists for Java and related languages.
* **JPA** -- Java Persistence API ... a standard way of marking Java objects which should be stored in databases.
  Hibernate is by far the most common *implementation* of JPA (and predates it). In most cases, they're
  interchangeable in ordinary speech. This also called an ORM (Object-RelationalDatabase Mapping).
* **Constructor dependency injection** -- the preferred pattern for injecting dependencies. For example,
  a `@RestController`-annotated class might
  have `final MyEntityRepository myEntityRepo; public MyRestController(final @Autowired MyEntityRepository repo){this.myEntityRepo = repo;}`.
  https://www.youtube.com/watch?v=aX-bgylmprA.
* Controllers
    * Non-dynamic files (e.g. an index.html or a stylesheet) don't need an explicit controller ... instead just place
      them in `/src/main/resources/static` (or subdirectories thereof).
      So `/src/main/resources/static/images/smiley.jpg` would be delivered to `http://localhost:8080/images/smiley.jpg`
      without any coding.
    * Remember: the exact pathComponent in the `GetMapping("/styles/{styleNum}.css")` must match the exact name of the
      parameter marked with @PathVariable.
    * `@Controller` -- An annotation for linking endpoints (e.g. `/fancyHello`) to templated web pages (e.g,
      in `src/main/resources/templates`). The templates are using a library called Thymeleaf and has special tags
      like `th:each` which can iterate lists, etc.
        * Useful references for normal Thymeleaf expressions -- https://www.baeldung.com/spring-thymeleaf-3-expressions
          and https://github.com/engma/thymeleaf-cheat-sheet/blob/master/README.md
        * But non-HTML files (e.g. CSS) have a different
          syntax -- https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#textual-syntax
        * The attribute names in calls to `model.addAttribute()` must match exactly the variables referenced within the
          templates themselves.
        * Instead of having your controller do stuff
          like `model.addAttribute("bgColor", something); model.addAttribute("fgColor", somethingElse);`, it's cleaner
          to have some class, perhaps `FormatInfo` with `bgColor` and `fgColor` as fields.
          Then your controller can do a single `model.addAttribute("format", formatInfo)`.
          Of course you'd have to change your css template from `[(${bgColor})]` to `[(${format.bgColor})]`, but it's
          ultimately cleaner and more readable code.
          (And eventually `FormatInfo` will probably get JPA annotations.)
        * The return value for these methods is the the name of the template.
    * `@RestController` -- An annotation for linking endpoints (e.g. `/courses/{course_id}/`) to API responses.
        * Here, you're explicitly stating *what* to return. You can return a String, or you can return an object and
          have Spring convert to a string for you. But either way, *you* are deciding the details of what is being
          returned.
        * `@CrossOrigin` -- An annotation stating that REST will accept requests from JavaScript running in any webpage,
          as opposed to the default where only requests from scripts loaded from the same site will be
          allowed. https://www.baeldung.com/spring-cors
* Endpoints
    * `@GetMapping`, `@PutMapping`, `@PostMapping`, `@PatchMapping`, and `@DeleteMapping` -- annotations for the five
      most common HTTP verb endpoint types.
        * In addition to GET, POST, PUT, DELETE, PATCH, there's also HEAD, and what does is a GET without actually
          getting the data. Suppose there's a *large* endpoint that changes every-so-often. The browser can do a HEAD
          first to see if it has changes, and only GET when necessary.
        * A `@GetMapping` can be in either a RestController or a templated Controller, depending on what you want to
          return to the user. If it is JSON, you probably want a RestController. If it's HTML, it's probably a templated
          Controller.
        * But suppose you have an HTML and it a submit button and you want that button to be *doing* something, and so
          issuing a POST or PUT is better. But do you sent it to a RestController or a templated Controller?
            * Scenario 1 (server-side rendering, older): When the user clicks OK, they want to see a new page with the
              result of their action.
                * This is a good case for a templated Controller because you want to return HTML to them.
            * Scenario 2: (client-side rendering, newer) You have a Javascript-heavy page where the end result of most
              activity is that JS code calls JSON endpoints and the JS code then modifies the DOM to reflect the JSON
              that comes back. In this case, a RestController endpoint is better.
                * An example of client-side rendering is experiment2
                  at https://github.com/2023-Spring-Cohort/RaceCarExtension/blob/main/src/main/resources/static/js1.html
    * `@RequestBody` -- A parameter to endpoint extracted from the body of a POST or PUT and deserialized from JSON to
      the appropriate entity type.
    * `@PathVariable` -- A parameter to an endpoint method extracted from a `{some_id}` component of the endpoint path.
    * `@RequestParam` -- A parameter to an endpoint method passed in from a `<form>`, usually.
    * `@ResponseBody` -- An annotation on an endpoint that it's returning json-encoded data. Not needed
      for `@RestController`-annotated classes.
* `@SpringBootApplication` -- An annotation that Spring should run the `main()` in the class.
* `@Bean` -- An annotation that Spring should wire the entity into its framework. Controllers, RestControllers, and
  everything else that Spring knows about are all subclasses of bean.
  Note that you rarely will actually type `@Bean` ... instead you'll declare something as a component that Spring knows,
  like a `CrudRepository` or `@Controller`.
    * `@Autowired` -- Annotation that Spring should automatically populate this parameter. This is sort of the partner
      to `@Bean`, in that it *uses* beans, whereas `@Bean` *provides* beans.
    * `@Qualifier` -- Allows Spring to manage two beans of the same type. Used when declaring them, to "name" them. Used
      when autowiring them, to choose one.
        * `@Primary` -- An alternative to `@Qualifier`, when one of the beans should be used unless the consuming
          component specified otherwise with a `@Qualifier` as part of its `@Autowired`.
* `@Service`
    * Today, we have web-facing components (`@Controller` and `@RestController`) which talk Thymeleaf and REST and which
      depend upon one or more CrudRepositories (and they indicate with stuff like `@Autowired`).
    * But suppose there were fancier logic between the Controller and the Repository. (Or suppose I just wanted to
      divide up my program even more cleanly.) Then we could make a new component.
        * This new component would depend upon one or more CrudRepositories, and the Controllers would in turn depend
          upon it.
        * In such a case, we need to allow Spring to find it. We could probably give it a plain `@Bean` annotation or a
          plain `@Component` annotation, but the general term for such things that sit between components and
          repositories is a "Service" and Spring offers a `@Service` annotation.
* Java programs using Spring don't have to have everything annotated for Spring. You can just plain classes that do
  stuff. You need Spring annotations when Dependency Injection needs to occur.
    * But a class with only static methods (e.g. returning a fixed list of strings) doesn't need such things.
    * We need spring annotations for classes which should have exactly one instance.
* `@Entity` -- Marks a class as an "entity" which should be persisted in a Relational Database.
    * `@Table` -- the database table for the entity. Optional unless you wish to specify the name of the table or if you
      wish to specify secondary key(s) using the `@Index` annotation.
    * `@Id` -- Identifies the field primary key for the table. Every table needs to identify its key, so this field is
      required.  (Note: JPA also allows for "composite" keys comprising more than one column, but that's beyond the
      scope of this course.)
        * `@GeneratedValue` -- When inserting records into the table, automatically compute a new unique value for the
          field (typically used for primary keys).
        * `@EmbeddedId` -- (Beyond the scope of this course) Identifies the multiple fields which together form the
          primary key for the table.
        * `@Embeddable` -- (Beyond the scope of this course) Identifies the class wrapping all of the columns of a
          composite primary key. primary key field.
    * `@Column` -- Specifies the database column for the specified field in the class. By default all fields in
      an `@Entity`-annotated class are persisted to the database, so this annotation is optional unless you need to
      specify the actual database column name.
    * `@JsonIgnore` -- Not actually a JPA annotation, but marks a field which should not be converted to/from JSON,
      especially for `@RequestBody`. Useful when you wish to store data in the database but not return it from GET or
      require it in POST.
    * `@Lob` -- identifies a field containing large data (e.g. images, etc.)  Useful when you want to store a longer
      string (e.g. longer than 255 characters).
    * Two-sided: ManyToMany. Let's suppose that "Primary" is the "owning" class (i.e. insertions and deletions are done
      via that class) and that "Secondary" is the "owned" class.
        * Then the Primary class
          contains `@ManyToMany() @JoinTable() private Collection<Secondary> secondaries = new HashSet<>();`
        * And the Secondary class
          contains `@ManyToMany(mappedBy = "secondaries") private Collection<Primary> primaries;`
    * Two-sided: OneToMany. Let's suppose that the "Many" is the "owning" class (i.e. insertions and deletions are done
      via that class)
        * Then the Primary class contains `@ManyToOne() @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
          private Secondary secondary;`
            * The cascade is so we can add new Secondaries as implied when we are creating new Primaries.
        * And the Secondary class contains something
          like `@OneToMany(mappedBy="secondaries") @JsonIgnore private Collection<Primary> primaries = new HashSet<>();`.
    * Reminder: classes which are stored in Sets should have explicit `.equals()` and `.hashCode()` methods looking at
      the fields which should matter for saying that two objects are essentially the same. If two tags have the same
      name, then we want only one in the database -- so `.equals()` for tags should only look at important fields.
    * NOTE: JPA offers multiple strategies for mapping when you have *inheritance* between classes.
      For small projects like ours, the first choice at https://www.baeldung.com/hibernate-inheritance probably
      suffices.
      HOWEVER, if you're trying to do a one-to-many mapping to an abstract class, then you need to use another option,
      perhaps `TABLE_PER_CLASS`.
* `final private Logger logger = LoggerFactory.getLogger(ThisClass.class);` -- standard phrasing to create a logger to
  which you can write interesting information. Used in all Java programs, Spring and non-Spring. We use the `org.slf4j`
  loggers.  `logger.error("Somehow the .name is null here");`
* **Reflection** -- The ability for Java code to see the structure of Classes programmatically. You should never use
  reflection directly, but it's what allows Spring to work. Every object has a `.class` field which contains a `Class`
  object which you can ask for annotations, method names, etc.
* **Gradle** -- a system for defining the configuration of a Java project in a `build.gradle` file, written in the
  "Groovy" language. Defines what version of Java is required, which libraries to download and use, etc. Is a modern
  replacement for the "Maven" system (which used a `pom.xml` file instead).
    * Since we are using Spring Boot, you can download a `build.gradle` from https://start.spring.io/ ... just specify
      the features you want, including perhaps:
        * Spring Web
        * Spring Boot Actuator (so you can get useful information at http://localhost:8080/actuator)
        * Thymeleaf
        * Spring Data JPA
        * Spring Security (we haven't used this, but any real application should)
        * Quartz Scheduler (we haven't used this, but excellent if you need jobs to run periodically)

## Spring *integration* tests

* **Unit Test** -- cheap to run and tests single classes in isolation. So other than calling the constructors of other
  classes, really should be for the class being tested.
    * It's poor form to have a single unit test verify multiple things in general.
* **Integration Test** -- more expensive to run, and are frequently end-to-end.
    * More common for them to complex and fewer.
* The truth is, any test is far better than no test.

```
// Using automated testing is far easier than manually pasting commands into the bash shell, e.g.
// curl -X POST http://localhost:8080/categories -H 'Content-Type: application/json' -d '{"name": "nonfiction", "description": "Purports to correspond to reality"}'
// curl -X GET http://localhost:8080/categories -H 'Content-Type: application/json'

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)   // Startup a real webserver, but not on port 8080
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)   // Wipe out the existing tables and start from scratch
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // And reset the database between each test
@AutoConfigureMockMvc                                                         // And populate a MockMvc framework below.
public class CategoryControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void addCategories() throws Exception {
        final Category category1 = new Category("Romance", "Happily-ever-after");
        final Category category2 = new Category("Climatology", "*Not* Happily-ever-after");
        
        // If I do an http POST to /categories and pass in {"name": "Romance", "description": "Happily-ever-after"}
        // then I expect to get an "OK" back. Oh, and just to be clear, I'm sending JSON and expect to get JSON back
        // (rather than, say, HTML).
        
        // Yes, the ".accept(...).contentType(...).content(...)" style coding is the same Builder pattern we've seen 
        // before, except that there's a `.perform()` rather than a `.build()`.
        mvc.perform(MockMvcRequestBuilders.post("/categories")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(category1)))
                .andExpect(status().isOk());
                
        // If I do an http POST to /categories and pass in {"name": "Climatology", "description": "Not Happily-ever-after"}
        // then I expect to get an "OK" back.
        mvc.perform(MockMvcRequestBuilders.post("/categories")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(category2)))
                .andExpect(status().isOk());

        // At this point, we have two records in MySQL (or something similar) 
        // If I do an http GET to /categories, and pass in nothing else, I expect to get
        // [{"name": "Romance", "description": "Happily-ever-after"},
        //  {"name": "Climatology", "description": "Not Happily-ever-after"}]
        mvc.perform(MockMvcRequestBuilders.get("/categories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(new Category[]{category1, category2})));

        // And then if I do an http DELETE to /categories/Romance, I expect to get an OK back
        mvc.perform(MockMvcRequestBuilders.delete("/categories/" + category1.getName()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // If I then do an http GET to /categories, and pass in nothing else, I expect to get
        // [{"name": "Climatology", "description": "Not Happily-ever-after"}]
        mvc.perform(MockMvcRequestBuilders.get("/categories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(new Category[]{category2})));
    }
   
    // Utility to convert objects to their JSON representation 
    private static String getJsonContent(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}
```

## Getting started with a Spring Boot Project

* Option A.
    * http://start.spring.io, and specify which features of Spring you want (and has *many*), and then download a
      settings.gradle, and start that way.
* Option B.
    * Find a sample program which does much of what we want, and tweak it. For
      example, https://github.com/spring-guides/gs-spring-boot.git
* Option C.
    * To start with a project you already know and tweak it.
    * https://github.com/marshallfWCCI/SpringBootExample1/ --> REST, Thymeleaf, and Database access.
    * https://github.com/marshallfWCCI/SpringBootExample2/ --> Only Thymeleaf
* Also:
    * The `build.gradle` file is small and so fairly straightforward to make sure you got right.

# **Model-View-Controller" style of web server programming ("MVC")

* **Model** interfaces with the database
    * Spring provides an "Object-Relational Mapping" (called Hibernate) which allows you to *annotate* your classes and
      fields with information about the tables and columns they map into the database and then Spring will take care of
      the plumbing.
    * src/main/java/..../entities -- Java objects annotated with their database mapping.
    * src/main/java/..../repositories -- Any special SQL goes here ... otherwise Spring creates all the boilerplate
      automatically.
        * `CrudRepository<TableClass, PrimaryKeyClass>` automatically knows how to create/read/update/delete.
* **View** takes data and converts it to a form suitable for use (HTML, or JSON, ...)
* **Controller** contains logic for what data is written to the database and how the information is presented to users.
    * src/main/java/..../restController -- endpoints accepting and consuming JSON.
    * src/main/java/..../templateControllers -- endpoints populating data for the Thymeleaf HTML templates.

# **Databases

* Java servers lose their memory when they restart, so we write data we care about to databases. Some might argue that
  the primary job of most servers is to feed data to databases, and present data already in databases.
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
* Databases can ("CRUD"), so we have `@CrudRepository` in Spring.
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

## Bash commands

* `cd` -- Navigate to your home directory.
* `cd ..` -- Navigate to the parent directory.
* `pwd` -- Display the actual current directory.
* `ls -l` -- list files in current directory. Shows the size (in bytes) of each file and when they were last modified.
* `explorer .` -- Opens Windows File Explorer in the current directory.
* `code .` -- Opens VSCode in the current directory.

### Dangerous Bash commands

* `rm` -- Delete a file
* `mv` -- Rename a file
* `touch` -- Create a file
* `>` and `>>` -- To write to (or append to) a file.

## Git commands

* `git help` -- When you forget the name of a subcommand.
* `git status -h` -- When you forget the details of a subcommand, like `status`.
* `git status` -- run this early and often.
* `git pull` -- run this early and often. Pulls commits from the corresponding branch on GitHub, and attempts to merge
  them in (if necessary). The more frequently you pull, the smaller the merges, and the more likely that any merges will
  be painless.
* `git add .` -- Add changes in the current directory (and subdirectories thereof) to the be included in the
  next `git commit`. This is called "staging" the changes.
* `git add README.md` -- Stages only the one file. Useful when you're working on multiple changes and want to commit
  them separately. (Perhaps one file you're working on has lots of additional System.out.println() for debugging that
  you don't want to confuse things in the repository.)
* `git commit -m "Useful message"` -- stores the staged changes into your repository. The message should be useful most
  of all to you. Smaller commits are far easier to summarize -- which is yet another reason to commit frequently.
* `git reset HEAD~1` -- Undos the most recent commit -- *but* should only be used if that change is not yet pushed.
* `git push` -- Sends changes on the current branch to GitHub. Works best if you first did a `git pull`.
* `git checkout -b FEATURE_SOMEFEATURE` -- Creates a new branch, allowing for experimentation independent of maintenance
  which is occurring on the primary branch. I suggest that you only run this command when `git status` is clean.
* `git checkout FEATURE_SOMEFEATURE`, `git checkout main` -- Switches your workspace (e.g. the files in your project) to
  an existing branch. I suggest that you only run this command when `git status` is clean.
* `git remote -v` -- Shows the remote repositories your local repository is aware of.
  You will at least have an `origin` repository, and that's the default.
  So `git pull` and `git pull origin` are identical...same for `git push` and `git push origin`.
* `git remote add personal <your-new-repo-url>` -- tells your local git repo about *another* remote repository
  (in this case, called "personal", though you could call it anything).  
  Then you can do `git push personal` to send a copy of your work to your *personal* GitHub account, and `git push` will
  continue to push to your WCCI-controlled repository.

# Too-advanced to discuss now

* Regular Expressions
* End-point **Pagination**, e.g. https://www.baeldung.com/rest-api-pagination-in-spring.
* JPA Laziness, e.g. https://www.baeldung.com/hibernate-lazy-eager-loading
* Default methods in interfaces, e.g. https://www.baeldung.com/java-static-default-methods

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
* To write a Spring Boot REST/JPA application:
    * Define the core concepts of your application as plain (and unannotated) classes within a "model" or "entities"
      package. Try out their constructors and methods using classic JUnit tests. Make sure that the order in which
      complex structures are constructed make sense to you. Make sure that the business logic (if any) in the entities
      also works. Mark collections containing Sets of other objects as `@JsonIgnore` so they aren't sent over REST
      unintentionally.
    * Write out the REST endpoints you're planning on providing. For each: what's the endpoint, what's the HTTP verb,
      what data is expected and what data will be returned. Put all of this data in your README.md file. Verify that the
      classes you defined above allow you to actually support these endpoints. Also include in the README.md
      human-readable descriptions of each class and the relationships (e.g. one-to-many or many-to-many) between them.
    * Annotate your classes with JPA annotations (`@Entity`, etc.) Create a super-simple `CrudRepository` per class.
      Create the standard `main()` with the usual `@SpringBootAppplication`. Run the program. See if Spring is able to
      create the database tables, or whether you have missed something in your annotations. Perhaps Spring requires
      zero-argument constructors, etc. (If it doesn't even try to create tables, perhaps annotations
      like `spring.jpa.hibernate.ddl-auto=create-drop` are missing.) Verify that the tables exist (and look roughly like
      what you expect) by using a tool like the VSCode MySQL plugin.
    * Add some sample records to your database by using a Populator-style component. Run the process again and verify
      that the data is written to MySQL. Verify again using the plugin or similar tool.
    * *Now* you can start working on the `@RestController` endpoints. Do this
      using [Integration-test TDD](#spring-integration-tests).

# Interview tips

* Ask clarifying questions that also show off your knowledge.
    * "What is HTML?"
        * "Would you like me to talk about the various tags, or would you like me to talk about how it populates the
          DOM, or talk about what a markup language is?"
    * "What is polymorphism?"
        * "Would you like a textbook definition, or would you like a concrete example with an interface and implementing
          classes?"
    * "What is Spring?"
        * "Do you want to know about the Dependency Injection of the underlying framework, or about typical uses such as
          for REST endpoints and database interactions?"
* Don't be afraid to give your opinions
    * "What are the three main type of CSS selectors"?
        * "At end of the spectrum we have selectors which are based purely on HTML tags, in the middle we have per 'CSS
          Class' selectors, and there are even per-ID selectors which apply to individual elements. But we don't want to
          repeat ourselves, so I prefer to have as much styling common to all elements of a given tag, and have as
          little styling done per-individual-element."
    * "What type of visibility modifiers does Java offer?"
        * "The primary ones are private, protected, and public. Code is cleaner when as many things as possible are
          private and as few things as possible are public. There's also a "default" modified, but modern code rarely
          uses it."
* When talking out-loud during a CodingBat style problem, feel free to also say what you're *not* doing.
    * "I'm iterating the characters in this String using the modern `for (char c : str.toCharArray())` syntax.
      I could be using an old-style "for" loop with the two semicolons and the `i++`, but I prefer this approach
      because ..."

# Advanced topics

* `var` in Java
* What is a JAR file
* Java inner classes
* Java reflection
* Java Garbage Collection
* Java Just-in-time JVM optimizations
* What is Gradle
* Where does Grade download libraries

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
    * Distinguish consistency from cargo-cult logic.[^Cargo] Don't copy-and-paste without understanding -- but do accept
      black-boxes. [^BlackBox] Practice https://en.wikipedia.org/wiki/Rubber_duck_debugging.
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

[^Cargo]: If you're working in a system in which each component is named after an animal species, then you should
continue that pattern (to reduce the cognitive load on others).
Or if your organization has a specific code formatting style, you should continue to use it. But don't just copy stuff
without understanding.

[^BlackBox]: The whole point of encapsulation is that we don't have to understand details if they're hidden behind
abstractions.
So we can tell students: "The `Console` object knows how to write stuff to the screen.
We can trust that it does so and not worry about how it does so."
********

# Virtual Pet API Requirements

* Your team needs to decide on a name, which will determine the GitHub account containing your code.
* Your team should have a Slack channel.
  Your team is self-organizing, so you get to decide whether I and Billy should be on the channel.
  (Or create two, one with us and one without us.)
* You must be clear about which individual (or group of individuals) is working on a given story, so you don't
  duplicate work.
  Messages in Slack or face-to-face are fine at first.
* While you will be doing division-of-labor for the coding, you must not do division-of-labor for the understanding of
  the code.
  Every team member must understand how the entire system works.
* You may copy classes from the personal projects of one or more team members, or you may start from scratch.
* All functionality must be available from via a REST-style API:
    * List all shelters,
      Create a new shelter,
      Create a pet of a given type/name/age/etc,
      List all pets at a given shelter,
      Add a pet to a given shelter,
      Adopt a pet from a given shelter,
      Perform actions upon or see the status of a single pet who is a guest of a particular shelter,
      Perform actions upon or see the status of all pets who are guests of a particular shelter,
* All of the above functionality should also be available through user-friendly webpages, styled with CSS.
  You get to decide on the mix of server-side or client-side rendering which works best for you.
* The state of the system must survive the server restarting, so you will need a database backend, e.g. MySQL.
* You must write the stories you're implementing into the project's README.md *before* implementing them.
  I strongly suggest thinking carefully about the order in which you do the stories, so your team can work efficiently
  (e.g., what the least bit of Java work so that someone can start working on the CSS and layout part).
* Project is currently due at 5PM on Thursday 2023-03-09, though I may give you more time as conditions demand.
* I *strongly* urge you to periodically slack me and ask for comments on what you've pushed to your shared repository.

# Quick-and-dirty branches for teams

* Rules: Never actually write *any* code in the `main` branch.
  Really, there's no need to ever do a `git checkout main` on your laptop, except immediately before making a new
  branch.
* Suggestion: don't ever have two people edit the same file at the same time. If you do need to, make it a super-small
  change.
* Completely safe -- your branch is separate from everything else
    * Every story should have its own "feature branch"
        * Branches can be called anything, but it's kinda nice to have a consistent naming convention, like "
          FEATURE_story"
        * To create a branch `git checkout main; git pull; git status; git checkout -b feature_list_shelters`
        * If you happen to need to switch branches (rare) `git checkout feature_list_shelters`
            * (Only time really to switch between branches is if you're working on multiple stories at once, which is
              usually not a good idea.)
        * Notice that the bash shell prompt is super-useful (except perhaps on Macs...that depends on how it's setup)
    * Doing
      a `git status; git add .; git status; git commit -m "SomethingShortButWillRemindYou"; git status; git push; git status`
      on a regular basis will make for a happy and healthy life.
        * All of this is just in your branch and won't bother anyone else
    * Whenever the team *accepts* a Pull Request, everyone on the team needs to
      do `git fetch; git merge origin/main; git status`.
      We do this so GitHub won't say your feature branch is out-of-date.
        * `git fetch` --> makes your repository know about anything which happened at GitHub
        * `git merge origin/main` --> merges anything recently added to GitHub's "main" branch onto your feature branch
* When you think your feature branch is ready:
    * Do another `git fetch; git merge origin/main; git status`, and then do any necessary adds/commits/pushes.
    * Go onto GitHub and create a Pull Request.
    * Have the others on your team review the change and then accept the Pull Request and merge it into main.
    * Then everyone on the team should do a `git fetch; git merge origin/main; git status` on their machines (i.e. in
      the feature branch they're working on). If they happen to be working on multiple feature branches (and they should
      *not* be), then do the `git merge origin/main` on each such branch.
* When you're ready to start a new feature branch:
    * `git checkout main; git pull` --> Temporarily switch back to the main branch and update it
    * `git status` --> Verify that the pull succeeded
    * `git checkout -b feature_even_better_feature` --> Create a new branch, and then start working there.
* What can go wrong?
    * Possible problem: The team accepts a Pull Request with less-than-perfect code
        * Possible solutions:
            * Read the changes before agreeing.
            * Create a new branch and fix what's wrong.
    * Possible problem: After you're done coding your branch, you try to make a pull request and GitHub says that your
      branch is-out-of-date.
        * Possible solutions:
            * Do lots of `git fetch; git merge origin/main` -- at least immediately after every PR is accepted.
            * Wait until you're ready for the PR and do the `git fetch; git merge origin/main` then -- but it will be
              harder then.

# Quick and Dirty Agile

* "New" -- Anything goes! You have an idea...just throw it here.
* "Backlog" -- This should contain *stories* in the form of "As a ____, I need ___, so that ____".
  These should *not* contain references to technologies, specific behavior, etc.
  Instead, they should detailed a small chunk of *useful* and *observable* behavior, in terms intelligible to a
  Product Owner who knows what they want but hasn't programmed a day in their life.
  But as long as your tasks comply with this, feel free to throw stuff at the *bottom* of the list.
  But the team should have consensus on what gets moved to the top of the list.
* "Ready" -- This contains the tasks which the team agrees are "on deck".  
  It's better to have fewer tasks here.  
  Unlike "Backlog", the stories in this column should be well-defined and understood by the entire team, which means
  you should list the actual tasks which need to be done.
* "In Progress" -- You should aim to have at most one item here per team member.  
  It's perfectly fine for a team member to have zero items in this column if they're currently working on a task
  that's in the "In Review" column. Moving items from "In Review" to "Done" is more important than moving items
  from "In Progress" to "In Review".
* "In Review" -- This contains tasks for which the teammate doing the coding feel they're done, but the entire team
  needs to verify that the work is *done*.
  Inspecting such stories is usually your highest priority.
* "Done" -- You're confident that the work is correct.
  Each team needs to define its own concept of "done", and this might be the most important decision the team makes.
  "Done" has to mean "done" ... otherwise the board doesn't give an accurate summary of the state of your project.
