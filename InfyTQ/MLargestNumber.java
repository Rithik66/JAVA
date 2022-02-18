import java.util.*;
public class MLargestNumber{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] ar1 = new int[a];
        for(int i=0;i<a;i++){
            ar1[i]=scanner.nextInt();
        }
        int b = scanner.nextInt();
        int[] ar2 = new int[b];
        for(int i=0;i<b;i++){
            ar2[i]=scanner.nextInt();
        }
        ArrayList<Integer> com = new ArrayList<>();
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(ar1[i]==ar2[j] && ar2[j]>=0){
                    if(!com.contains(ar1[i]))com.add(ar1[i]);
                    break;
                }
            }
        }
        Collections.sort(com);
        //System.out.println(com);
        int m=com.get(0);
        //System.out.println(m);
        if(String.valueOf(m).length()>1)
        m=check(m);
        //System.out.println(m);
        //ArrayList<ArrayList<Integer>> fin = new ArrayList<>();
        int temp=m;
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        ArrayList<Integer> row1 = new ArrayList<>();
        for(int i=a-1;i>=0 && m>0;i--){
            if(!row1.contains(ar1[i]))row1.add(ar1[i]);
            if(row1.size()==m) break;
        }
        ArrayList<Integer> row2 = new ArrayList<>();
        for(int i=b-1;i>=0 && m>0;i--){
            if(!row2.contains(ar2[i]))row2.add(ar2[i]);
            if(row2.size()==m) break;
        }
        Collections.sort(row1);
        Collections.sort(row2);
        if(row1.size()==0 && row2.size()==0) System.out.println(-1);
        System.out.println(row1+"\n"+row2);
    }
    public static int check(int m){
        int temp=m;
        int len=String.valueOf(m).length();
        if(len==1) return m;
        int sum=0;
        while(m>0){
            sum+=m%10;
            m/=10;
        }
        m=sum;
        if(String.valueOf(m).length()>1) check(m);
        return m;
    }
}