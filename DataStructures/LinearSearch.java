class LinearSearch{
    public static void main(String[] args) {
        int first[] = {7,3,5,2,8,1,9,6,4};
        String second[] = "rithik".split("");
        searchInt(first, 8);
        searchString(second,"h");
    }
    public static void searchString(String[] arr,String token){
        System.out.print("String search : ");
        int index=0;
        for(String a:arr){
            if(a.equals(token)){
                System.out.println("Token = "+token+" : Index = "+index);
                return;
            }
            index++;
        }
        System.out.println("No Match found");
    }
    public static void searchInt(int[] arr,int token){
        System.out.print("Integer search : ");
        int index=0;
        for(int a:arr){
            if(a==token){
                System.out.println("Token = "+token+" : Index = "+index);
                return;
            }
            index++;
        }
        System.out.println("No Match found");
    }
}