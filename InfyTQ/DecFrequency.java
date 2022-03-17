import java.util.*;
public class DecFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<a;i++){
            arr.add(scanner.nextInt());
        }
        Map<Integer,Integer> freq = new HashMap<>();
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        for (int i=0;i<a;i++) {
            int k=Collections.frequency(arr,arr.get(i));
            freq.put(k,arr.get(i));
        }
        int maxK=0,maxV=0;
        for(Map.Entry<Integer,Integer> set:freq.entrySet()){
            if(set.getKey()>max){
                maxK=set.getKey();
                maxV=set.getValue();
            }
        }
    }
}