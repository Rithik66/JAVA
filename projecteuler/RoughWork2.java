package projecteuler;

public class RoughWork2 extends RoughWork1{
	String gender;
	RoughWork2(String name,int age,String gender){
		super(name,age);
		this.gender=gender;
	}
	public String toString() {
		return super.toString()+this.gender;
		
	}
}
