public class MAVround2{
    public static void main(String[] args){
        String s1 = "Hiiamri";
        String s2 = "Hiiamrai";
        char[] c1 = s1.length()<s2.length()
                    ?s1.toCharArray():s2.toCharArray();
        char[] c2 = s2.length()>s1.length()
                    ?s2.toCharArray():s1.toCharArray();
        int count=0;
        for(int i=0;i<c1.length;i++){
            if(c1[i]==c2[i]){
                count+=2;
                c2[i]=0;
            }
            else if(check(c1[i],c2)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean check(char c1,char c2[]){
        for(int i=0;i<c2.length;i++){
            if(c2[i]==c1) return true;
        }
        return false;
    }
}