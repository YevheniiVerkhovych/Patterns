
public class VisitorPattern {
    public static void main(String[] args) {

//        Element body = new BodyElement();
//        Element engine = new EngineElement();
//        Visitor mechanic = new MechanicVisitor();
//
//        body.accept(mechanic);
//        engine.accept(mechanic);

        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());

    }

}

// Visitor
interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

// Car spare part
interface Element {
    void accept(Visitor visitor);
}

//Car body
class BodyElement implements Element{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Car engine
class EngineElement implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
//Car wheel
class WheelElement implements Element{
    private String name;

    public WheelElement(String name) {this.name = name;}
    public String getName() {return this.name;}

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Car
class CarElement implements Element {
    Element[] elements;

    public CarElement() {
        this.elements = new Element[] {new WheelElement("Front left"),
            new WheelElement("Front right"), new WheelElement("Rear left"),
            new WheelElement("Rear right"), new BodyElement(), new EngineElement()};
    }

    public void accept(Visitor visitor) {
        for(Element elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{
    public void visit(WheelElement wheel) {
        System.out.println("Kick " + wheel.getName() + " wheel.");
    }

    public void visit(EngineElement engine) {
        System.out.println("Engine has been started!");
    }

    public void visit(BodyElement body) {
        System.out.println("Knocked on the wheel..");
    }

    public void visit(CarElement car) {
        System.out.println("Smoked inside the car.");
    }
}

class MechanicVisitor implements Visitor{

    public void visit(WheelElement wheel) {
        System.out.println("Puped up" + wheel.getName() + " the wheel");
    }

    public void visit(EngineElement engine) {
        System.out.println("Checked the engeine.");
    }

    public void visit(BodyElement body) {
        System.out.println("Polished the body.");
    }

    public void visit(CarElement car) {
        System.out.println("Checked entire look of the car.");
    }

}