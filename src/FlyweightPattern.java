import java.util.*;

public class FlyweightPattern {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape2> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));

        Random rand = new Random();
        for (Shape2 shape : shapes) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x,y);
        }
    }

}
//Flyweight
interface Shape2 {
    void draw(int x, int y);
}

//Point Flyweight
class Point2 implements Shape2{
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"):drawing the point ");
    }
}
//Circle Flyweight
class Circle2 implements Shape2{
    int r = 5;
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"):drawing circle with radius " + r);
    }
}


//Square Flyweight
class Square2 implements Shape2 {
    int a = 10;
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"):drawing square with  side " + a);
    }
}
class ShapeFactory{
    private static final Map<String, Shape2> shapes = new HashMap<>();
    public Shape2 getShape(String shapeName) {

        Shape2 shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName) {
                case "circle":
                    shape = new Circle2();
                    break;
                case "square":
                    shape = new Square2();
                    break;
                case "point":
                    shape = new Point2();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}
