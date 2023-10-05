import java.sql.SQLOutput;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        String strs[] = {"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder r = new StringBuilder();

        if (strs.length == 1 && strs[0].length()==0) return r.toString();

        int shortestStrLength = strs[0].length() > 0 ? strs[0].length() : 0;
        for (int i=1 ; i<strs.length ; i++) {
            if (strs[i].length() < shortestStrLength) {
                shortestStrLength = strs[i].length();
            }
        }

        int cIndex = 0;
        char c = strs[0].charAt(cIndex);

        for (int j=0 ; j<shortestStrLength ; j++) {
            for (int i=1 ; i<strs.length ; i++) {
                if (strs[i].charAt(cIndex) == c) {
                    if (i!=strs.length-1) {continue;}
                    r.append(c);
                    cIndex++;
                    c = strs[0].charAt(cIndex);
                    continue;
                }
                break;
            }
        }
        return r.toString();
    }
}



