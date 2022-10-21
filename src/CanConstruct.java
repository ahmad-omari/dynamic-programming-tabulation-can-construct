/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/22/2022, Saturday
 * @project : dynamic-programming-tabulation-can-construct
 **/
public class CanConstruct {

    public static boolean canConstruct(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;
        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                for (String word : wordBank) {
                    if (((i + word.length()) < table.length) && target.startsWith(word, i)) {
                        table[i + word.length()] = true;
                    }
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }
}
