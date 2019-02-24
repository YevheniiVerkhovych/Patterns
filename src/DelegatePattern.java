public class DelegatePattern {

    public static void main(String[] args) {

    Painter painter = new Painter();

    painter.setGraphics(new Square());
    painter.draw();
    painter.setGraphics(new Triangle());
    painter.draw();
    painter.setGraphics(new Circle());
    painter.draw();


    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics{
    public void draw() {
        System.out.println("Рисуем Треугольник!");
    }
}
class Square implements Graphics{
    public void draw() {
        System.out.println("Рисуем Квадрат!");
    }
}
class Circle implements Graphics{
    public void draw() {
        System.out.println("Рисуем Круг!");
    }
}

class  Painter {
    Graphics graphics;

    void setGraphics(Graphics g) {
        graphics = g;
    }
    void draw() {
        graphics.draw();
    }
}