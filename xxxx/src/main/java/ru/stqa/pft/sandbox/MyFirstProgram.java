package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	public static void main(String[] args){
		Square s = new Square(5.0);
		Rectangle r = new Rectangle(4.0, 5.0);
		String name = "world";
		System.out.println("Hello," + name + "!");
		System.out.printf("Область прямоугольника со сторонами " + r.a +" и " +r.b + " = " + area(r));
	}


	public static double area(Rectangle r){
		return r.a*r.b;
	}
}