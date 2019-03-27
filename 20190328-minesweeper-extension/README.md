# Kata: Minesweeper 2D

## Introduction
Add the numbers to a minesweeper board.

Minesweeper is a popular game where the user has to find the mines 
using numeric hints that indicate how many mines are directly adjacent 
(horizontally, vertically, diagonally) to a square.

In this exercise you have to create some code 
that counts the number of mines adjacent to a square 
and transforms boards like this (where * indicates a mine):

_Note:_ The one-dimensional mines are extended to two-dimensional array. 
It's continuation from the previous session (see: [o2-dojo/20190313-minesweeper](../20190328-minesweeper)).

### Example
This input mine game...
```
+-----+
| * * |
|  *  |
|     |
|     |
+-----+
```

...should be computed into this:
```
+-----+
|1*3*1|
|12*21|
| 111 |
|     |
+-----+
```

## About session
* Date: 28. 3. 2019
* Language: Kotlin
* IDE: Intellij IDEA 2018.3
* Participants: Jan Jaroš, Tomáš Bartošek, Filip Kropáček, Petr Slezák
* Source: [exercism.io/Minesweeper](https://exercism.io/my/solutions/7bc33b4bbbd542e0857e4efa25c7d03b)
