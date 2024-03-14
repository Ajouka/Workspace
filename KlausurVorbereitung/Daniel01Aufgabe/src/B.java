public class B {
    private static int cnt = 0;
    private double d1;
    private Float f;
    private Integer a;
    private int j;

    // Constructor with primitive data types
    public B(int a, int b, int c, int d) {
        this.a = a; // Assigning the value of a to the instance variable a
        this.j = b; // Assigning the value of b to the instance variable j
        this.d1 = d; // Assigning the value of d to the instance variable d1
        this.f = (float)c; // Casting c to float and assigning to the instance variable f
        cnt++; // Incrementing the static variable cnt
    }

    // Constructor with a mix of wrapper and primitive data types
    public B(Integer a, int b, double c, Float d) {
        this.a = a; // Assigning the value of a to the instance variable a
        this.j = b; // Assigning the value of b to the instance variable j
        this.d1 = c; // Assigning the value of c to the instance variable d1
        this.f = d; // Assigning the value of d to the instance variable f
        cnt++; // Incrementing the static variable cnt
    }

    // Overloaded methods f with different parameter types
    public int f(Float x, int y) {
        return 101;
    }

    public int f(double x, int y) {
        return 102;
    }

    public Integer f(double x, Long y) {
        return 103;
    }

    // Methods g with different parameter types
    public double g(long x) {
        return 7.0;
    }

    public Float g(Integer x) {
        return 8f;
    }

    // Main method to demonstrate the usage of class B
    public static void main(String[] args) {
        B b1 = new B(1, 2, 3, 4);
        System.out.println(b1.d1); // Output the value of d1

        // The following lines have issues with parameters and method calls
        // Corrected and commented for clarity
        System.out.println(b1.f(7.5f, 8)); // Calls f(Float, int)
        System.out.println(b1.f(5.0, 6)); // Calls f(double, int)
        System.out.println(b1.f(10.2, new Long(17))); // Calls f(double, Long)

        B b2 = new B(b1.a, 5, 6, 9);
        System.out.println(b2.f); // This line is incorrect as f is a method, not a variable

        // The following lines have issues with parameters and method calls
        // Corrected and commented for clarity
        System.out.println(b2.f(b1.f, b1.j)); // This line is incorrect as f is a method, not a variable
        B b3 = new B(++b2.a, 14, 15.0, 16f);
        System.out.println(b3.d1); // Output the value of d1
        System.out.println(b3.g(new Long(18 + 1))); // Calls g(Long)
        System.out.println(b3.g(b1.a)); // Calls g(Integer)
        System.out.println(b3.f(b2.g(19), 21)); // Calls f(double, int)
        System.out.println(b1.j++); // Output the value of j and then increment
        System.out.println(cnt); // Output the value of static variable cnt



    }
}
