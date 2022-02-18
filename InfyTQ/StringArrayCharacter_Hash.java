import java.util.HashMap;

public class StringArrayCharacter_Hash{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split("");
        String[] s2 = scanner.nextLine().split(",");
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0;i<s1.length;i++){
            hm.put(s1[i],s2[i]);
        }
        String s="";
        for(int i=0;i<s1.length;i++){
            
        }
    }
}