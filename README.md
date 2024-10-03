# LAB06 - Code Template

Please see problem statement/slides.

## Task 1 -- Implement `generateAdoptionTable()` and print the adoption table `printAdoptionTable()`
- Generate a 2D array that stores one adoption per row
- An adoption includes: cat’s name, the owner’s name, and the adoption year 
    - These are the columns, all values should be stored as Strings
    - The order of the columns is predefined and can be accessed directly
- The adoption year should be a randomly generated number between 2000 and 2024
- Use formatted strings to print out the adoption table (use the 2D array!)
- **Hint:** `String.valueOf(someInteger);` converts an integer to a string

## Task 2 -- Implement `sortAdoptions()`
- Implement BubbleSort to sort the adoptions in descending order
- **Hint:** Parse a String to an int: `int year = Integer.parseInt(yearString)`
