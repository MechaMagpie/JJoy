# JJoy
A Joy interpreter in Java

## What is Joy?
Joy is a functional programming language developed by Dr. Manfred von Thun of La Trobe University. Most of the information on the language is currently found in [this mirror of his homepage](http://www.kevinalbrecht.com/code/joy-mirror/index.html) that was saved before the original was deleted.

## The interpreter
The interpreter currently runs a REPL in what the manual refers to as automatic output mode 2, that is, it prints the entire stack after each evaluation. It lacks some features of the reference implementation, and differs on som other features. Notably, there is strict segregation between truth values and numbers. Integers are mostly 64 bit, because I'm 15 years closer to 2038.
