import java.util.*;

public class sugan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0;i<a;i++) {
            arr.add(scanner.nextInt());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            int k=Collections.frequency(arr,arr.get(i));
            if(k==1) ans.add(arr.get(i));
        }
        System.out.println(ans.get(2));
    }
}
