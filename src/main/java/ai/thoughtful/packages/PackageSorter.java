package ai.thoughtful.packages;

import ai.thoughtful.packages.model.PackageResult;
import ai.thoughtful.packages.model.Stack;

public final class PackageSorter {
    // Constants for package classification
    private static final double BULKY_VOLUME_THRESHOLD = 1_000_000;
    private static final double BULKY_DIMENSION_THRESHOLD = 150;
    private static final double HEAVY_MASS_THRESHOLD = 20;

    /**
     * Sort the packages into the correct stack based on volume, dimensions, and mass.
     *
     * @param width  Width of the package in cm.
     * @param height Height of the package in cm.
     * @param length Length of the package in cm.
     * @param mass   Mass of the package in kg.
     * @return PackageResult containing the classification details.
     * @throws IllegalArgumentException if any input parameter is invalid.
     */
    public static PackageResult sort(double width, double height, double length, double mass) {
        // Validate inputs
        if (width <= 0 || height <= 0 || length <= 0 || mass <= 0) {
            throw new IllegalArgumentException("All dimensions and mass must be greater than zero.");
        }

        // Calculate volume
        final double volume = width * height * length;

        // Determine if the package is bulky or heavy
        final boolean isBulky = volume >= BULKY_VOLUME_THRESHOLD || Math.max(width, Math.max(height, length)) >= BULKY_DIMENSION_THRESHOLD;
        final boolean isHeavy = mass >= HEAVY_MASS_THRESHOLD;

        // Decide the stack based on criteria
        final Stack stack;
        if (isBulky && isHeavy) {
            stack = Stack.REJECTED;
        } else if (isBulky || isHeavy) {
            stack = Stack.SPECIAL;
        } else {
            stack = Stack.STANDARD;
        }

        return new PackageResult(isBulky, isHeavy, stack);
    }
}
