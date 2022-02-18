public class StringArrayCharacter{
	public static void main(String[] args) {
		String s = "dbabbca";
		String check = "bat,ball,rat,bat,bat,car,rat";
		String[] arr = check.split(",");
		char[] ch = s.toCharArray();
		String res="";
		for(int i=0;i<ch.length;i++){
		    int flag=1;
    		for(int j=i+1;j<ch.length;j++){
    		    if(arr[j].equals(arr[i]) && !arr[i].equals("")){
    		        if(ch[i]!=ch[j] && ch[i]!=0) {
    		            flag=0;
    		            arr[j]="";
    		        }
                }
                else if(ch[i]==ch[j] && ch[i]!=0){
                    if(!arr[j].equals(arr[i])) {
                        flag=0;
                        ch[j]=0;
                    }
                }
                if(arr[j].equals(arr[i]) && ch[i]==ch[j]){
                    ch[j]=0;
                    arr[j]="";
                }
    		}
		    if(flag==1) res+=ch[i];
		}
		System.out.println(res);
	}
}