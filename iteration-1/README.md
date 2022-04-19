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
     - the first names the option
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

...ongoing

# Ideas for future changes

- when an unexpected argument is encountered, include its
  position in the error message (for better usability)
