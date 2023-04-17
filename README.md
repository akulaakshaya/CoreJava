# CoreJava
Java Assessment -4
									Date: 13-04-2023
1. WAP to create your own exception as NegativeSizeException whenever negative values are 
      put in an array.                                                                                                             4 Marks
2. Write a java program to perform the following operations on List                     24 Marks
a) Sum and average of the elements present in the list
b) Sum of the even numbers in the list
c) print the repeated/duplicate elements with its repetition count
d) identify the highest no. of duplicates elements in the list
e) delete the duplicates from the list
f) list of common elements between two list
g) WAP to calculate the salary of all the employees from one country
h)WAP to print the employees names grouped by country
3. What is the difference between finally, final, and finalize in Java?                      2 Marks
4. Write a program that prints its arguments in random order. Do not make a copy of the argument array. Demonstrate how to print out the elements using both streams and the traditional enhanced for statement.                                                                               6 Marks
import java.util.*;

public class Ran {

    public static void main(String[] args) {
        
        // Get and shuffle the list of arguments
        List<String> argList = Arrays.asList(args);
        Collections.shuffle(argList);

        // Print out the elements using JDK 8 Streams
        argList.stream()
        .forEach(e->System.out.format("%s ",e));

        // Print out the elements using for-each
        for (String arg: argList) {
            System.out.format("%s ", arg);
        }

        System.out.println();
    }
}

5. Consider the four core interfaces, Set, List, Queue, and Map. For each of the following four assignments, specify which of the four core interfaces is best-suited, and explain how to use it to implement the assignment.                                                                                           12 Marks
a) Whimsical Toys Inc (WTI) needs to record the names of all its employees. Every month, an employee will be chosen at random from these records to receive a free toy.
Ans: Use a List. Choose a random employee by picking a number between 0 and size()-1.
b) WTI has decided that each new product will be named after an employee but only first names will be used, and each name will be used only once. Prepare a list of unique first names.
Ans:Use a Set. Collections that implement this interface don't allow the same element to be entered more than once.
c) WTI decides that it only wants to use the most popular names for its toys. Count up the number of employees who have each first name.
Ans:Use a Map, where the keys are first names, and each value is a count of the number of employees with that first name.
d) WTI acquires season tickets for the local lacrosse team, to be shared by employees. Create a waiting list for this popular sport.
Ans:Use a Queue. Invoke add() to add employees to the waiting list, and remove() to remove them.
6.Write a method that takes a List<String> and applies String.trim to each element     6Marks
The enhanced for statement does not allow you to modify the List. Using an instance of the Iterator class allows you to delete elements, but not replace an existing element or add a new one. That leaves ListIterator:
import java.util.*;

public class ListTrim {
    static void listTrim(List<String> strings) {
        for (ListIterator<String> lit = strings.listIterator(); lit.hasNext(); ) {
            lit.set(lit.next().trim());
        }
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList(" red ", " white ", " blue ");
        listTrim(l);
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }
    }
}
7.Take the FindDups example and modify it to use a SortedSet instead of a Set. Specify a Comparator so that case is ignored when sorting and identifying set elements.              6Marks
import java.util.*;

public class FindDups {

    static final Comparator<String> IGNORE_CASE_ORDER
            = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    };

    public static void main(String[] args) {
        
        SortedSet<String> s = new TreeSet<String>(IGNORE_CASE_ORDER);
        for (String a : args) {
            s.add(a);
        }
        System.out.println(s.size() + " distinct words: " + s);
    }
}
8. Write a Java program to test if a map contains a mapping for the specified key.         5Marks
9. What is the purpose of the Synchronized block? explain about static synchronization   											             5Marks
10. What is the Executor interface in Concurrency API in Java?                                            6Marks
11. Explain about Reflection with its advantages ?                                                                  5Marks
12.Write an example that counts the number of times a particular character, such as e, appears in a file. The character can be specified at the command line.                               6Marks
import java.io.*;
import java.nio.file.*;

public class CountLetter {
    private char lookFor;
    private Path file;

    CountLetter(char lookFor, Path file) {
        this.lookFor = lookFor;
        this.file = file;
    }

    public int count() throws IOException {
        int count = 0;
        try (InputStream in = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
            {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (lookFor == line.charAt(i)) {
                        count++;
                    }
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return count;
    }

    static void usage() {
        System.out.println("usage: java CountLetter <letter>");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1 || args[0].length() != 1)
            usage();

        char lookFor = args[0].charAt(0);
        Path file = Paths.get("xanadu.txt");
        int count = new CountLetter(lookFor, file).count();
        System.out.format("File '%s' has %d instances of letter '%c'.%n",
                file, count, lookFor);
    }
}
13. Explain about Thread Communication in java?                                                                   3 Marks
