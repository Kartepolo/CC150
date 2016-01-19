/**
 * Created by HuangXiang on 1/18/16.
 */
public class Arrays_Strings {

    public static boolean isUniqueChr(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int loc = str.charAt(i);
            if (char_set[loc]) return false;
            else char_set[loc] = true;
        }
        return true;
    }

    private class Heap{


    }

    public static boolean isUnique_HeapSort(String str){
        return true;
    }


}
