public class reverseWords {
    public static void main(String[] args) {
        String s = "hi.i.am.a.software.developer";
        System.out.println(reverse(s));
    }
    public static String reverse(String s){
        String arr[] = s.split("[.]");
        String str="";
        for(int i=arr.length-1;i>=0;i--){
            str+=arr[i];
            if(i!=0)str+=".";
        } //hi
        return str;
    }
}