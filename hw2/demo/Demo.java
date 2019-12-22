package code;
import java.util.Scanner;

class Demo  
{
    public static void main(String[] args) 
    {
        System.out.println("\nProgrammer Name: Liem Thanh Ho" );
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three sides of the Triangle");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        System.out.println("Enter the color of the Triangle");
        String color = input.next();

        System.out.println("Is the Triangle filled? Enter 'True' or 'False'");
        String filled = input.next(); 

        Triangle triangle = new Triangle(side1, side2, side3);
        
        if (filled.equals("True") || filled.equals("true"))
        {
            triangle.setFilled(true);
        }
        else
        {
            triangle.setFilled(false);
        }
        triangle.setColor(color);
        
        System.out.println("The Triangle Sides are \nSide 1: " 
        + triangle.getSide1() + "\nSide 2: " + triangle.getSide2() 
        + "\nSide 3: " + triangle.getSide3());
        System.out.println("The Triangle's Area is " + triangle.getArea());
        System.out.println("The Triangle's Perimeter is " + triangle.getPerimeter());
        System.out.println("The Triangle's Color is " + triangle.getColor());
        System.out.println("The Triangle's filled status is " + triangle.isFilled());
    }
}