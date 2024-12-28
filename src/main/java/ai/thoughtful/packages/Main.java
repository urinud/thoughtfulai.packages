package ai.thoughtful.packages;

import static ai.thoughtful.packages.PackageSorter.sort;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("For a package with width 200, height 100, length 50, and mass 25:");
            System.out.println(sort(200, 100, 50, 25)); // REJECTED
            System.out.println("For a package with width 100, height 50, length 20, and mass 10:");
            System.out.println(sort(100, 50, 20, 10));  // STANDARD
            System.out.println("For a package with width 150, height 100, length 50, and mass 10:");
            System.out.println(sort(150, 100, 50, 10)); // SPECIAL
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}