# ColorFactory

A Java coursework project by Blake Lacroix, created while studying at Tacoma Community College (TCC).

## What it does

Validates a production order containing red, orange, yellow, green, blue, and violet items. Checks nonnegative quantities, a maximum of 100 items, three to five distinct colors, presence of primary and secondary colors, and sufficient primary-color quantities for the secondary colors.

`productionOrder(...)` prints validation errors and returns whether the order is valid. The `main` method demonstrates valid and invalid inputs.

## Requirements

JDK 21 (matching the included Eclipse configuration). No external libraries are needed.

## Run from a terminal

From this project folder:

```powershell
javac -d bin src/ColorFactory.java
java -cp bin ColorFactory
```

The first eleven demonstration orders return `false`; the last three return `true`. Error messages for invalid inputs are expected.

## Open in Eclipse

Use File > Import > General > Existing Projects into Workspace, select this folder, and finish the import. Run `src/ColorFactory.java` as a Java Application. If a project named ColorFactory already exists in your workspace, use that existing project or import this copy into a different workspace.

## Files

- `src/ColorFactory.java`: original student implementation, unchanged.
- `.project`, `.classpath`, `.settings/`: Eclipse project configuration.
- `.gitignore`: excludes generated files from Git.

The instructor-provided ColorFactoryTester.java is omitted from this sharing copy because its header limits use to students in a specific TCC course. This project runs independently of that tester.
