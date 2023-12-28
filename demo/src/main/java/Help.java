import java.util.Scanner;

public class Help {
    public static void main(String[] str) {
        Scanner scanner = new Scanner(System.in);
        Help a = new Help();
        String input = "";

        while (!input.equalsIgnoreCase("q")) {
            a.showMenu();
            System.out.print("Enter a value (or 'q' to quit): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break; // Exit the loop if user enters "q"
            }

            try {
                int number = Integer.parseInt(input);
                if (a.isValid(number)) {
                    a.helpOn(number);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        scanner.close();
        System.out.println("Program finished.");
    }

    void helpOn(int what) {
        switch (what) {
            case 8: {
                return;
            }
            case 1: {
                System.out.println("**************************************** FOR **************************************");
                System.out.println("if (condition1) {\n" +
                        "\t//code to be executed if condition1 is true\n" +
                        "} else if (condition2) {\n" +
                        "\t//code to be executed if condition1 is false and condition2 is true\n" +
                        "} else {\n" +
                        "\t//code to be executed if all conditions are false\n" +
                        "}");
                break;
            }
            case 2: {
                System.out.println("********************************** SWITCH CASE ************************************");
                System.out.println("switch (expression) {\n" +
                        "\tcase value1:\n" +
                        "\t\t//code to be executed if expression matches value1\n" +
                        "\t\tbreak;\n" +
                        "\tcase value2:\n" +
                        "\t\t//code to be executed if expression matches value2\n" +
                        "\t\tbreak;\n" +
                        "\t...\n" +
                        "\tcase valuen\n" +
                        "\tdefault:\n" +
                        "\t\t//code to be executed if expression doesn't match any case\n" +
                        "}");
                break;
            }
            case 3: {
                System.out.println("*********************************** FOR LOOP **************************************");
                System.out.println("for (initialization; condition; update) {\n" +
                        "    // code to be executed in each iteration\n" +
                        "}");
                break;
            }
            case 4: {
                System.out.println("*********************************** WHILE LOOP ***********************************");
                System.out.println("while (condition) {\n" +
                        "    // code to be executed\n" +
                        "}");
                break;
            }
            case 5: {
                System.out.println("*********************************** DO ... WHILE **********************************");
                System.out.println("do {\n" +
                        "    // code to be executed\n" +
                        "} while (condition);");
                break;
            }
            case 6: {
                System.out.println("*************************************** BREAK *************************************");
                System.out.println("*** In a Loop ***");
                System.out.println("while (condition) {\n" +
                        "    // code\n" +
                        "\n" +
                        "    if (/* some condition */) {\n" +
                        "        break; // exit the loop\n" +
                        "    }\n" +
                        "\n" +
                        "    // more code\n" +
                        "}\n");
                System.out.println("*** In a switch ***");
                System.out.println("switch (expression) {\n" +
                        "    case value1:\n" +
                        "        // code\n" +
                        "        break;\n" +
                        "\n" +
                        "    case value2:\n" +
                        "        // code\n" +
                        "        break;\n" +
                        "\n" +
                        "    default:\n" +
                        "        // code\n" +
                        "        break;\n" +
                        "}");
                break;
            }
            case 7: {
                System.out.println("************************************* CONTINUE ************************************");
                System.out.println("Forces the next iteration of the loop to take place,\n" +
                        "skipping any code between itself and the conditional\n" +
                        "expression that controls the loop.");
                System.out.println("Sample: \nfor (int i = 1; i <= 10; i++) {\n" +
                        "    if (i % 2 == 0) {\n" +
                        "        continue; // Skip even numbers\n" +
                        "    }\n" +
                        "    System.out.println(i);\n" +
                        "}");
                break;
            }
        }
    }

    void showMenu() {
        System.out.println("***************************************** MENU ********************************************");
        System.out.println("Help on:");
        System.out.println("\t1. if");
        System.out.println("\t2. switch");
        System.out.println("\t3. for");
        System.out.println("\t4. while");
        System.out.println("\t5. do ... while");
        System.out.println("\t6. break");
        System.out.println("\t7. continue");
        System.out.println("\tq. to Exit");
    }

    boolean isValid(int choice) {
        if (choice >= 1 && choice <= 8) {
            return true;
        }
        return false;
    }
}

