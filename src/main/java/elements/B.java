package elements;

public class B extends A{
	public B(){
		System.out.println("Inside a B constr");
	}
	
	public B(String param){
		//super(param);
		System.out.println("Inside a B constr with param");
	}
	
	public static void main(String[] args) {
		B b = new B("param");
	}

}
