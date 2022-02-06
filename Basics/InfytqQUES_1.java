import java.util.*;
public class infytqQUES_1{
    static List<String> li = new ArrayList<>(); 
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        subsequence(s,"");int k=0;
        for(int i=0;i<li.size();i++){
            k=Integer.parseInt(li.get(i));
            if(checkPrime(k)) ans.add(k);
        }
        Collections.sort(ans);
        if(ans.size()==0) System.out.println(-1);
        else System.out.println(ans.get(ans.size()-1));
    }
    public static void subsequence(String s,String res){
        if (s.length()==0){
            if(res.length()>0 && res.charAt(0)!='0') li.add(res);
            return;
        }
        subsequence(s.substring(1),res+s.charAt(0));
        subsequence(s.substring(1),res);
    }
    public static boolean checkPrime(int a){
        if(a==0 || a==1) return false;
		int i=2;
		while(i<a){      
			if(a%i==0) {
				return false;
			}
			i++;			   
		}
		return true;
	}
}
