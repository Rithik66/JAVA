package Javatraining;
import java.util.*;

class Result {
    static void printPermutn(String str, String ans,List<Integer> ar)
    {
        if (str.length() == 0) {
            ar.add(Integer.parseInt(ans));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + 
                         str.substring(i + 1);
            printPermutn(ros, ans + ch,ar);
        }
    }
    public static List<String> checkDivisibility(List<String> arr) {
        List<String> ls=new ArrayList<String>();
        for(String res:arr){
            List<Integer> ar = new ArrayList<Integer>();
            if(res.length()==1)
            {
                if(Integer.parseInt(res)%8==0)
                    ls.add("YES");
                else
                    ls.add("NO");
                continue;
            }
            if(res.length()==2){
                printPermutn(res,"",ar);
                int flag=0;
                for(int i:ar){
                    if(i%8==0){
                        ls.add("YES");
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                    ls.add("NO");
                continue;
            }
            char ch[]=res.toCharArray();
            for(int i=0;i<ch.length;i++)
                for(int j=i+1;j<ch.length;j++)
                    for(int k=j+1;k<ch.length;k++)
                    {
                        String res2 = (ch[i]+"")+(ch[j]+"")+(ch[k]+"");
                        printPermutn(res2,"",ar);
                    }
            int flag=0;
            for(int i:ar){
                if(i%8==0){
                    ls.add("YES");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                ls.add("NO");
        }
        return ls;
    }

}