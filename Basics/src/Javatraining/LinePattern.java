package Javatraining;

public class LinePattern
{
	public static void main(String[] args)
	{
		int rows = 4;
		for (int i = 1; i <= rows; i++) {
            for (int k = 1; k <=(rows*2)-1; k++) {
				if(i==rows || i+k==5 || k-i==3) System.out.print("*");
				else {
					System.out.print("");
				}
            }
			System.out.println();
		}
	}
}