public class Main{
    public static void main(String[] args) {
        String s = "teioautereeae";
        int max=Integer.MIN_VALUE;
        String result="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String ans="";
                for(int k=i;k<=j;k++){
                    ans+=s.charAt(k);
                }
                if(check(ans)){
                    if(ans.length()>max){
                        max=ans.length();
                        result=ans;
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static boolean check(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a' && s.charAt(i)!='e' && s.charAt(i)!='i' && s.charAt(i)!='o' && s.charAt(i)!='u'){
                return false;
            }
        }
        return true;
    }
}
