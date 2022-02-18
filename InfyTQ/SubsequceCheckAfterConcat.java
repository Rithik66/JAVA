import java.util.*;
public class SubsequceCheckAfterConcat {
    static ArrayList<String> li = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1[] = scanner.nextLine().split(",");
        String s2[] = scanner.nextLine().split(",");
        String s3[] = scanner.nextLine().split(",");
        int flag=0;
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                String s=s1[i]+s2[j];
                //subsequence(s,s3);
                if(check(s,s3)) {
                    flag=1;
                    break;
                }
            }
        }
        Collections.sort(li);
        if(flag==0) System.out.println(-1);
        else 
        System.out.println(li);
    }
    public static boolean check(String s,String[] s3){
        s=s.toUpperCase();
        for(int i=0;i<s3.length;i++){
            int sum=0;
            for(int j=0;j<s3[i].length();j++){
                if(!s.contains(s3[i].toUpperCase().charAt(j)+"")) return false;
                sum=s.indexOf(s3[i].toUpperCase().charAt(j))-sum;
                if(sum<0) return false;
            }
            if(!li.contains(s3[i])) li.add(s3[i]);
            return true;
        }
        return true;
    }
    // public static void subsequence(String s,String []arr){
    //     int n=s.length();
    //     int limit=(int)Math.pow(2,n);
    //     for(int i=1;i<limit;i++){
    //         int temp=i;
    //         String str="";
    //         for(int j=0;j<n;j++){
    //             int res=temp%2;
    //             temp/=2;
    //             if(res==1) str+=s.charAt(j);
    //         }
    //         for(int k=0;k<arr.length;k++){
    //             if(str.equalsIgnoreCase(arr[k])) 
    //                 if(!li.contains(arr[k]))
    //                     li.add(arr[k]);
    //         }
    //     }
    // }
}
