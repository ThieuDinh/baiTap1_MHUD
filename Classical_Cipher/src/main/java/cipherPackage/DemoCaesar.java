package cipherPackage;

/**
 *
 * @author dinht
 */
public class DemoCaesar {

    private static char[][] charTable;
    private static final int SIZE = 5;

    private static boolean exist(int[] temp, int n) {
        for (int i = 0; i < temp.length; i++) {
            if (n == temp[i]) {
                return true;
            }
        }
        return false;
    }

    public static String generateKey(String keyWord) {
        int[] temp = new int[26];
        int count = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < keyWord.length(); i++) {
            if (keyWord.charAt(i) == ' ') {
                continue;
            }
            if (!exist(temp, keyWord.charAt(i))) {
                temp[count] = keyWord.charAt(i);
                count++;
                str.append(keyWord.charAt(i));
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (!exist(temp, i) && i != 'j') {
                temp[count] = i;
                count++;
                str.append((char) i);
            }
        }
        return str.toString();
    }

    private static void createTable(String key) {
        charTable = new char[SIZE][SIZE];
        String keyString = key.toUpperCase().replaceAll("[^a-z]", "").replace("j", "i");
        StringBuilder sb = new StringBuilder();
        for (char c : keyString.toCharArray()) {
            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (c != 'j' && sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }
        for (int i = 0, k = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                charTable[i][j] = sb.charAt(k++);
            }
        }
    }

    public static String modifyString(String input) {
        // Remove spaces
        String noSpaces = input.replaceAll("\\s", "");

        // Check if the length is odd
        if (noSpaces.length() % 2 != 0) {
            noSpaces += 'z';
        }

        return noSpaces;
    }

    public static void main(String[] args) {
        String text = "playfairkey";
        String t=generateKey(text);
        char [][]x;
        createTable(t);
       for(int i=0;i<SIZE;i++){
           for(int j=0;j<SIZE;j++)
               System.out.print(charTable[i][j]+" ");
               
       System.out.println(" ");}
    }
}
