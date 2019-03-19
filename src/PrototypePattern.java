
public class PrototypePattern {

    public static void main(String[] args) {

        Human2 original = new Human2(18, "Vasya");
        System.out.println(original);

        Human2 copy = (Human2)original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human2 h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setPrototype(new Human2(30, "Valeriya"));
        Human2 h2 = factory.makeCopy();
        System.out.println(h2);
    }

}


interface Copyable {
    Object copy();
    }

class Human2 implements Copyable{

    int age;
    String name;

    public Human2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public  String toString() {
        return  "Human [age=" + age + ", name= " + name + "]";
    }

    public Object copy() {
        Human2 copy = new Human2(age, name);
        return copy;
    }
}

class HumanFactory{
    Human2 human;

    public HumanFactory(Human2 human){
        setPrototype(human);
    }
    public void setPrototype(Human2 human){
        this.human = human;
    }
    Human2 makeCopy(){
        return (Human2)human.copy();
    }
}