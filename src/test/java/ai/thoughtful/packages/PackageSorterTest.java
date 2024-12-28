package ai.thoughtful.packages;

import ai.thoughtful.packages.model.PackageResult;
import ai.thoughtful.packages.model.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackageSorterTest {
    @Test
    public void testStandardPackage() {
        PackageResult result = PackageSorter.sort(100, 50, 20, 10);
        assertFalse(result.isBulky());
        assertFalse(result.isHeavy());
        assertEquals(Stack.STANDARD, result.stack());
    }

    @Test
    public void testSpecialPackageBulky() {
        PackageResult result = PackageSorter.sort(150, 100, 50, 10);
        assertTrue(result.isBulky());
        assertFalse(result.isHeavy());
        assertEquals(Stack.SPECIAL, result.stack());
    }

    @Test
    public void testSpecialPackageHeavy() {
        PackageResult result = PackageSorter.sort(100, 50, 20, 25);
        assertFalse(result.isBulky());
        assertTrue(result.isHeavy());
        assertEquals(Stack.SPECIAL, result.stack());
    }

    @Test
    public void testRejectedPackage() {
        PackageResult result = PackageSorter.sort(200, 100, 50, 25);
        assertTrue(result.isBulky());
        assertTrue(result.isHeavy());
        assertEquals(Stack.REJECTED, result.stack());
    }

    @Test
    public void testEdgeCaseVolume() {
        PackageResult result = PackageSorter.sort(100, 100, 100, 10);
        assertTrue(result.isBulky());
        assertFalse(result.isHeavy());
        assertEquals(Stack.SPECIAL, result.stack());
    }

    @Test
    public void testEdgeCaseDimension() {
        PackageResult result = PackageSorter.sort(150, 50, 50, 10);
        assertTrue(result.isBulky());
        assertFalse(result.isHeavy());
        assertEquals(Stack.SPECIAL, result.stack());
    }

    @Test
    public void testInvalidWidth() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PackageSorter.sort(-100, 50, 20, 10));
        assertEquals("All dimensions and mass must be greater than zero.", exception.getMessage());
    }

    @Test
    public void testInvalidHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PackageSorter.sort(100, -50, 20, 10));
        assertEquals("All dimensions and mass must be greater than zero.", exception.getMessage());
    }

    @Test
    public void testInvalidLength() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PackageSorter.sort(100, 50, -20, 10));
        assertEquals("All dimensions and mass must be greater than zero.", exception.getMessage());
    }

    @Test
    public void testInvalidMass() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> PackageSorter.sort(100, 50, 20, -10));
        assertEquals("All dimensions and mass must be greater than zero.", exception.getMessage());
    }
}
