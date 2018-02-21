package ru.stqa.pft.sandbox;

public class Square {
    public double a;
    public Square(Double x){
        this.a = x;
    }

    public double area(){
        return this.a*this.a;
    }
}
