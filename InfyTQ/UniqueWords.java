import java.util.*;
public class UniqueWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");
        ArrayList<String> full = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            ArrayList<String> li = new ArrayList<>();
            String st[]=s[i].split(" ");
            for(int j=0;j<st.length;j++){
                if(!li.contains(st[j]) && !full.contains(st[j])){
                    li.add(st[j]);
                    full.add(st[j]);
                }
            }
            if(li.size()>0)
            System.out.println(li);
            else System.out.println("X");
        }
    }
}