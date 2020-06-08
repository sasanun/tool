package tool;

public class MainTest {
    public static void main(String[] args) {
        CheckPoint cp = new CheckPoint();

        cp.check("A");

        for (int i = 0; i < 100; i++) {
            System.out.println("テスト");
        }

        cp.check("B");

        for (int i = 0; i < 100; i++) {
            System.out.println("テスト");
        }

        cp.check("C");
        System.out.println(cp);
    }
}
