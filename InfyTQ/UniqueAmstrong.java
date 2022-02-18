import java.util.*;
public class UniqueAmstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<a;i++){
            arr[i]=scanner.nextInt();
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<a;i++){
            for(int j=i+1;j<a;j++){  
                String res="";
                res=arr[i]+""+arr[j];
                if(isAmstrong(res) && !ans.contains(res)) ans.add(res);
            }
        }
        System.out.println(ans);
    }
    public static boolean isAmstrong(String s){
        int len=s.length();
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=(int)(Math.pow(Integer.parseInt(s.charAt(i)+""),len));
        }
        if((res+"").equals(s)) return true;
        return false;
    }
}