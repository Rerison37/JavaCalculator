import java.util.Scanner;
import java.lang.Math;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to Calculator mark-1!");

        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Which operation would you like to perform:");
            System.out.println("1. Addition | 2. Subtraction");
            System.out.println("3. Multiplication | 4. Division");
            System.out.println("5. Quadratic Equation | 6. Pythagorean Theorem");
            System.out.println("7. Circumference | 8. Calculate Area");
            System.out.println("q to quit: ");
            String choice = sc.next();

            if (choice.equals("q")) {
                System.out.println("Exiting...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

            try {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt < 1 || choiceInt > 8) {
                    System.out.println("Enter a number between 1 and 8 to choose the operation");
                    continue;
                }

                Double num1 = null, num2 = null;
                if (choiceInt != 8) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter the first number: ");
                    num1 = sc.nextDouble();
                }

                if (choiceInt < 5 || choiceInt == 6) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter the second number: ");
                    num2 = sc.nextDouble();
                }

                processOperation(sc, choiceInt, num1, num2);

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }

        sc.close();
    }

    public static double addition(double x, double y) {
        return x + y;
    }

    public static double subtraction(double x, double y) {
        return x - y;
    }

    public static double multiplication(double x, double y) {
        return x * y;
    }

    public static Double division(double x, double y) {
        if (y == 0) {
            System.out.println("Error: Division by zero!");
            return null;
        }
        return x / y;
    }

    public static void circumference(double radius) {
        double c = 2 * Math.PI * radius;
        System.out.printf("The circumference value is: %.2f\n", c);
    }

    public static double pythagoreanTheorem(double x, double y) {
        double z = x * x + y * y;
        return Math.sqrt(z);
    }

    public static double[] quadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            throw new IllegalArgumentException("The equation has no real roots");
        }
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return new double[]{root1, root2};
    }

    public static double areaTriangle(double base, double height) {
        return (base * height) / 2;
    }

    public static double areaRectangle(double base, double height) {
        return base * height;
    }

    public static double areaSquare(double side) {
        return side * side;
    }

    public static double areaParallelogram(double base, double height) {
        return base * height;
    }

    public static double areaTrapezoid(double upperBase, double lowerBase, double height) {
        return ((upperBase + lowerBase) / 2) * height;
    }

    public static double areaRhombus(double diagonal1, double diagonal2) {
        return (diagonal1 * diagonal2) / 2;
    }

    public static double areaRegularHexagon(double side) {
        return (3 * Math.sqrt(3) * (side * side)) / 2;
    }

    public static double areaCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public static double areaCircularSector(double angle, double radius, boolean inRadians) {
        if (inRadians) {
            return (angle * radius * radius) / 2;
        } else {
            return (angle * Math.PI * radius * radius) / 360;
        }
    }

    public static void processOperation(Scanner sc, int choice, Double num1, Double num2) {
        switch (choice) {
            case 1:
                System.out.println("Result: " + addition(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + subtraction(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + multiplication(num1, num2));
                break;
            case 4:
                Double divResult = division(num1, num2);
                if (divResult != null) {
                    System.out.println("Result: " + divResult);
                }
                break;
            case 5:
                System.out.println("Enter the third number: ");
                Double num3 = sc.nextDouble();
                try {
                    double[] roots = quadraticEquation(num1, num2, num3);
                    System.out.println("Roots: " + roots[0] + " and " + roots[1]);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 6:
                System.out.printf("The result is %.2f!\n", pythagoreanTheorem(num1, num2));
                break;
            case 7:
                circumference(num1);
                break;
            case 8:
                System.out.println("Select the 2D shape to calculate the area:");
                System.out.println("1. Triangle\n2. Rectangle\n3. Square\n4. Parallelogram\n5. Trapezoid\n6. Rhombus\n7. Regular Hexagon\n8. Circle\n9. Circular Sector");
                int shape = sc.nextInt();
                switch (shape) {
                    case 1:
                        System.out.println("Enter the base of the triangle: ");
                        double baseTriangle = sc.nextDouble();
                        System.out.println("Enter the height of the triangle: ");
                        double heightTriangle = sc.nextDouble();
                        System.out.println("The area of the triangle is: " + areaTriangle(baseTriangle, heightTriangle));
                        break;
                    case 2:
                        System.out.println("Enter the base of the rectangle: ");
                        double baseRectangle = sc.nextDouble();
                        System.out.println("Enter the height of the rectangle: ");
                        double heightRectangle = sc.nextDouble();
                        System.out.println("The area of the rectangle is: " + areaRectangle(baseRectangle, heightRectangle));
                        break;
                    case 3:
                        System.out.println("Enter the side length of the square: ");
                        double sideSquare = sc.nextDouble();
                        System.out.println("The area of the square is: " + areaSquare(sideSquare));
                        break;
                    case 4:
                        System.out.println("Enter the base of the parallelogram: ");
                        double baseParallelogram = sc.nextDouble();
                        System.out.println("Enter the height of the parallelogram: ");
                        double heightParallelogram = sc.nextDouble();
                        System.out.println("The area of the parallelogram is: " + areaParallelogram(baseParallelogram, heightParallelogram));
                        break;
                    case 5:
                        System.out.println("Enter the larger base of the trapezoid: ");
                        double upperBase = sc.nextDouble();
                        System.out.println("Enter the smaller base of the trapezoid: ");
                        double lowerBase = sc.nextDouble();
                        System.out.println("Enter the height of the trapezoid: ");
                        double heightTrapezoid = sc.nextDouble();
                        System.out.println("The area of the trapezoid is: " + areaTrapezoid(upperBase, lowerBase, heightTrapezoid));
                        break;
                    case 6:
                        System.out.println("Enter the larger diagonal of the rhombus: ");
                        double diagonal1 = sc.nextDouble();
                        System.out.println("Enter the smaller diagonal of the rhombus: ");
                        double diagonal2 = sc.nextDouble();
                        System.out.println("The area of the rhombus is: " + areaRhombus(diagonal1, diagonal2));
                        break;
                    case 7:
                        System.out.println("Enter the side length of the regular hexagon: ");
                        double sideHexagon = sc.nextDouble();
                        System.out.println("The area of the regular hexagon is: " + areaRegularHexagon(sideHexagon));
                        break;
                    case 8:
                        System.out.println("Enter the radius of the circle: ");
                        double radiusCircle = sc.nextDouble();
                        System.out.println("The area of the circle is: " + areaCircle(radiusCircle));
                        break;
                    case 9:
                        System.out.println("Enter the radius of the circular sector: ");
                        double radiusSector = sc.nextDouble();
                        System.out.println("Enter the angle of the circular sector (in degrees): ");
                        double angleSector = sc.nextDouble();
                        System.out.println("The area of the circular sector is: " + areaCircularSector(angleSector, radiusSector, false));
                        break;
                }
                break;
        }
    }
}
