# Approach

## Iteration 1

### Step 1: Tasks

- read the kata instructions (see [../README.md](../README.md))
- pick the public API nominally (see next step "API")
  - pick the command names, argument names and result names
  - but no actual data types
- fix the requirements/expectations
- estimate
- implement

### Step 2: API

- API command `parse`
  - takes a `schema`
  - takes an argument list

### Step 3: Requirements

1. Parse an argument list that consists of command line options
  1. an option consists of one or two items
     - the first item names the option
     - the first item is a dash followed by a letter
     - if the option takes no argument, there is no second item
     - if the option takes an argument, there may be a second item (arguments are optional)
  2. for now, only two data types are supported for arguments:
     1. non-negative integers (a minus sign is interpreted as another option)
     2. strings without white spaces (the parser does not support escapes)
  3. for now, options are not expected to occur more than once

More or new requirements may be added later.

### Step 4: Estimate

How long will it take?

I expect there will be two main things coming out:

- SchemaParser: code to parse the schema and construct a parser
- ArgParser: code to parse the arguments and construct the result

### Step 5: Implement

Disclaimer: Since this is an Uncle Bob Kata, I try to implement it
TDD-style.

#### First Implementation Session

Spent 3h to implement simple arguments (no arg values).

- Learned/seen/done:
  - first, outline use case(s)
    (see [SimpleUsageTest.java](src/test/java/ch/patchcode/kata/args/it1/SimpleUsageTest.java))
    - helps to write down the API in code
    - test does not assert anything
    - may or will break when behavior is added or modified
      (keep test expectations low, don't assert anything; only expectation is to compile)
  - do error handling early
    (see [ErrorHandlingTest.java](src/test/java/ch/patchcode/kata/args/it1/ErrorHandlingTest.java))
  - growth from factory method to factory class to builder class
    (see [ArgsBuilder.java](src/main/java/ch/patchcode/kata/args/it1/ArgsBuilder.java))
    - began with a factory method in the result class
    - became heavy (and noisy), moved to a factory class (no state)
    - grew further, accumulated state in the method, hence changed
      to a builder class
      - before, schema was a parameter to the factory method and the
        factory class, now schema became a constructor argument
        (configuring the builder class)
      - "state in the method" are method-local variables that are accessed
        not only line-local but througout the method 
- using git features a lot: `amend`, `stash`, `rebase -i`
- working on three fronts:
  - `*.java` (implementing and testing)
  - `pom.xml` (configuration)
  - `README.md` (keeping track)
- sometimes lost stashes (`git stash pop` later followed by `git checkout -- .`)
- the IDE (IntelliJ) suggested that 3 out of 4 classes produced so far
  (`Arg`, `Args` and `Parameter`, but not `ArgsBuilder`) _could_ be converted
  to Java records, but then also warned that conversion would make the so-far
  private fields public and thus weaken visibility
  - putting the focus on "OO is about messaging" (Alan Key, Robert C. Martin),
    (also see Clean Code Episode 5 @46:58, @48:28, most of all @49:01)

#### First Review Session

Spent 30 minutes, looking over the code and over this documentation so far.

Code critique:

- `ArgsBuilder` does two different things
  - the constructor parses the schema string into a `String`-`Parameter` map
  - the method `parse` parses the argument by matching it to the schema
- `ArgsBuilder` public API (public methods) seems unbalanced
  - plenty of code and logic in `parse` (updating the internal state for a given list of arguments)
  - no real code in `build`, this only calls the `Arg` constructor
- maybe `ArgsBuilder.parse` should take a stream or a single element, not a fixed-size array?
  - because as of now, it can anyway be called multiple times, incrementally

General thoughts:

- there are two things to parse, the schema and the actual arguments,
  hence there is a choice:
  - parse schema upfront and parse arguments later, or
  - parse schema and arguments in a nested loop
  - ...is there a good reason to choose one over the other?
- similarities to the bowling kata? consequences...?

Conclusion, measures:

- none yet

#### Second Implementation Session

Spent 45 minutes parsing an additional 'modifier' string or suffix in the
schema part after the short option letter.

#### Third Implementation Session

Spent 15 minutes or so parsing Strings and Integers.

# Unexpected time-outs

- how to use Hamcrest with JUnit5 (simple answer by stack Overflow)

# Conclusion

It somehow works. I am not happy with the code that came out by this "TDD".
I have an idea what the code should more look like at the end, and I wonder
if I could have done better with different refactoring; like Uncle Bob did
in the Bowling Kata screencast.

In general:
- I should not have split the tests (as I did, into error handling, no
  arguments, with arguments, and test for utility class). I should have
  written one incremental suite of tests.
- I should have refactored differently. TDD does not guide the refactoring,
  and the choice of refactoring seems quite important for the outcome.
  - I ended up with four classes, three of which the IDE tells me should or
    could be records.
  - I would prefer to have a chain of responsibility, or rather two (one for
    the schema, one for the arguments), to do the parsing (this saves me the
    loops, and it probably gives nice, polymorphic code)

# Appendix: Ideas for future changes

- when an unexpected argument is encountered, include its
  position in the error message (for better usability)

# Appendix: Other ideas

- commit timer: how long ago was my last (local) commit or
  my last (public) push; have I got stuck or delayed?
  - timer reset when:
    1. committing
    2. resetting
  - what about stashing?
- probably this can be implemented similar to the bowling kata
  - in the bowling kata, the processor sweeps over the rolls
  - the current roll affects how the next roll is accounted
  - expectation is, that I end up with one simple method, instead many classes
  - expectation is, it will only work on a fixed-size array, not on a stream
    (if look-ahead is avoided)
