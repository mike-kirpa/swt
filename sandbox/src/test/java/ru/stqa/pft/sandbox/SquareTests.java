package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class SquareTests {
    @Test
    public void testArea(){
        Square s = new Square(5.0);
        assert s.area() == 25;

    }
}
