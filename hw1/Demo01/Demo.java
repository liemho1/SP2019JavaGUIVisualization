import java.util.Scanner;

class Demo 
{
    public static double area(int n, double s)
    {
        return (n*(s*s))/(4*Math.tan((Math.PI/n)));      
    }
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of sides: ");
        int n = input.nextInt();
        System.out.print("Enter length of sides: ");
        double s = input.nextDouble();
        System.out.print("The area of polygon is: " + area(n,s)+"\n");
    }
}
