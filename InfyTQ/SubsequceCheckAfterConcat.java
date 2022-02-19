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
                //System.out.println(s);
                check(s,s3);
            }
        }
        Collections.sort(li);
        if(li.size()==0) System.out.println(-1);
        else System.out.println(li);
    }
    public static void check(String s,String[] s3){
        s=s.toUpperCase();
        for(int i=0;i<s3.length;i++){
            int in=0,flag=0;
            //System.out.println(s3[i]+" "+s);
            String st=s3[i].toUpperCase();
            for(int j=0;j<s3[i].length();j++){
                if(s.contains(st.charAt(j)+"")){
                    //System.out.println(s3[i].charAt(j));
                    if(in>s.indexOf(st.charAt(j))) in=-1;
                    else in=s.indexOf(st.charAt(j));
                }
                else {
                    flag=1;
                    break;
                }
                if(in<0) {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                if(!li.contains(s3[i])) li.add(s3[i]);
                //System.out.println(li);
        }
    }
}
