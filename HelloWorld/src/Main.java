import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println(test(121));
    }

    public static boolean test(int n) {
        StringBuilder num = new StringBuilder();
        num.append(n);

        for (int i=0 ; i<num.length()-1 ; i++) {
            if (num.charAt(i) != num.charAt(num.length()-i-1)) {return false;}
        }

        return true;
    }
}



