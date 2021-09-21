public class Hello {
    public static void main(String[] args) {
        int a = 1, b = 5;
        System.out.println("hello world!");
        int c = add(a,b);
        int d = sub(a,b);
        int e = multi(a,b);
        int f = dive(a,b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int sub(int a, int b) {
        return Math.abs(a - b);
    }

    static int multi(int a, int b) {
        return a*b;
    }

    static int dive(int a, int b) {
        return a/b;
    }

}
