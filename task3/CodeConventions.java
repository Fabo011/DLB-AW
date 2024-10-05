package task3;

public class CodeConventions {

    /**
     * Demonstrates various code conventions and best practices in Java.
     * This method showcases examples of bad and best practices in:
     * 1. Naming conventions
     * 2. Code formatting
     * 3. Commenting
     * 4. Method length
     * 5. Error handling
     */
    public static void demonstrateCodeConventions() {
        // 1. Naming Conventions
        System.out.println("1. Naming Conventions:");
        System.out.println("Bad Practice:");
        String x = "John Doe";  // Non-descriptive name
        System.out.println("String x = " + x);

        System.out.println("Best Practice:");
        String fullName = "John Doe";  // Descriptive name
        System.out.println("String fullName = " + fullName + "\n");

        // 2. Code Formatting
        System.out.println("2. Code Formatting:");
        System.out.println("Bad Practice:");
        for(int i=0; i<5; i++){ System.out.print(i + " "); } // No spaces or newlines

        System.out.println("\nBest Practice:");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " "); // Consistent indentation and spacing
        }
        System.out.println("\n");

        // 3. Commenting
        System.out.println("3. Commenting:");
        System.out.println("Bad Practice:");
        // This method does something
        // Missing method declaration for doSomething()
        System.out.println("void doSomething() {");
        System.out.println("    System.out.println(\"Doing something...\"); // Poor comment");
        System.out.println("}");

        System.out.println("Best Practice:");
        /**
         * This method performs a specific action to demonstrate
         * the importance of good commenting in code.
         */
        System.out.println("void performAction() {");
        System.out.println("    System.out.println(\"Performing an action...\"); // Useful comment");
        System.out.println("}\n");

        // 4. Method Length
        System.out.println("4. Method Length:");
        System.out.println("Bad Practice:");
        System.out.println("void longMethod() {  // Long method doing too much");
        System.out.println("    System.out.println(\"Start...\");");
        System.out.println("    System.out.println(\"Doing step 1...\");");
        // ... many more steps
        System.out.println("    System.out.println(\"Done.\");");
        System.out.println("}");

        System.out.println("Best Practice:");
        System.out.println("void step1() {");
        System.out.println("    System.out.println(\"Doing step 1...\");");
        System.out.println("}");

        System.out.println("void step2() {");
        System.out.println("    System.out.println(\"Doing step 2...\");");
        System.out.println("}");

        System.out.println("void executeSteps() {");
        System.out.println("    step1();");
        System.out.println("    step2();");
        System.out.println("}\n");

        // 5. Error Handling
        System.out.println("5. Error Handling:");
        System.out.println("Bad Practice:");
        System.out.println("try {");
        System.out.println("    int result = 10 / 0;  // This will throw ArithmeticException");
        System.out.println("} catch (Exception e) {");
        System.out.println("    System.out.println(\"Error occurred!\");  // Generic catch");
        System.out.println("}");

        System.out.println("Best Practice:");
        System.out.println("try {");
        System.out.println("    int result = 10 / 0;  // This will throw ArithmeticException");
        System.out.println("} catch (ArithmeticException e) {");
        System.out.println("    System.out.println(\"Cannot divide by zero!\");  // Specific catch");
        System.out.println("}");
    }
}
