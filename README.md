# thoughtfulai.packages
Thoughtful AI Packages

# PackageSorter

## Overview
`PackageSorter` is a Java program that sorts packages into different stacks based on their dimensions, volume, and mass. It classifies packages as:

- **STANDARD**: Packages that are within the standard size and weight limits.
- **SPECIAL**: Packages that are either bulky or heavy.
- **REJECTED**: Packages that are both bulky and heavy.

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Gradle 7.x or later

## Project Structure

The project contains:

- **PackageSorter.java**: The main class that implements the sorting logic.
- **model/PackageResult.java**: A helper class to store the results of sorting.
- **model/Stack.java**: Enum class to represent the different stacks.
- **PackageSorterTest**: Unit tests implemented using JUnit.

## Constants

The following thresholds are used for classification:

- **Bulky Volume Threshold**: 1,000,000 cm³
- **Bulky Dimension Threshold**: 150 cm
- **Heavy Mass Threshold**: 20 kg

## Build and Run

### Clone the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/urinud/thoughtfulai.packages.git
cd thoughtfulai.packages
```

### Build the Project
Use Gradle to build the project:

```bash
gradle build
```

### Run the Program
To execute the main method in `Main`, run:

```bash
gradle run
```

### Example Output

```
PackageResult(isBulky=true, isHeavy=true, stack=REJECTED)
PackageResult(isBulky=false, isHeavy=false, stack=STANDARD)
PackageResult(isBulky=true, isHeavy=false, stack=SPECIAL)
```

## Testing

Unit tests are implemented using JUnit. To execute the tests, run:

```bash
gradle test
```

## License

This project is licensed under the ISC License.

