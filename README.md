# anagramfinder
This Program Reads File and Maps All Anagram Words in Spring Boot

## a.How To Run Code

1. Check out Git Repo
2. Run : mvn clean install which will build project and anagram-0.0.1-SNAPSHOT.jar can be found in target folder
3. Go To Target Folder 
4. Run Command : java -jar anagram-0.0.1-SNAPSHOT.jar --file={File Path} , here you can pass filename againts file for example :java -jar anagram-0.0.1-SNAPSHOT.jar --file=D://example0.txt

## b.Big O analysis
1. Time Complexity
- n : Total Number Of Strings
- l : Is Total Number of Character in strings
- As We are iterating over each strings so there is n times iteration
- For Each Iteration we are sorting this string for that time complexity is : l * log(l) 
- To check Key in HashMap Time Complexity is O(1)

There for Total Time Complexity is : O(n  * l log(l) )

## 2. Space Complexity
- As we are storing result in HashMap so for each entry of set of Anagrams it will O(n)
- Also we are creating temporary arrays to sort strings so space complexity for that is O(k)

so total space complexity O(n) + O(k)


## c. Reasons behind data structures chosen
I have used HashMap to store and check group of anagrams, reason for that is i can search for string with O(1) time complexity and I can store list of anagrams in value.

## d. What would you do given more time
I Have not tested code with other laungages apart from English that i can do.
