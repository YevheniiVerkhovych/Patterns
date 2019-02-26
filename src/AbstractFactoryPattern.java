public class AbstractFactoryPattern {
    public static void main(String[] args) {

        DeviceFactory factory = getFactoryByCountryCode("RU");
        Mouse  m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(20, 50);

    }
    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "EU":
                return new EnDeviceFactory();
            case "RU":
                return new RuDeviceFactory();
            default: throw new RuntimeException("Unsupported country code: " + lang);
        }
    }
}

interface Mouse {
    void click();
    void dbclick();
    void scroll(int direction);
}
interface Keyboard{
    void print();
    void println();
}
interface Touchpad{
    void track(int deltaX, int deltaY);
        }
interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
class RuMouse implements Mouse{
    public void click() {
        System.out.println("Щелчок мышью.");
    }
    public void dbclick() {
        System.out.println("Двойной щелчок мышью.");
    }
    public void scroll(int direction) {
        if(direction>0)
            System.out.println("Скролим вверх.");
        else if(direction<0)
            System.out.println("Скролим вниз.");
        else System.out.println("Не скролим.");
    }
}
class RuKeyboard implements Keyboard{

    public void print() {
        System.out.println("Печатаем строку.");
    }
    public void println() {
        System.out.println("Печатаем сторку с переводом строки.");
    }
}
class RuTouchpad implements Touchpad{
    public void track(int deltaX, int deltaY) {
int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей.");
    }
}

class EnMouse implements Mouse{
    public void click() {
        System.out.println("Click.");
    }
    public void dbclick() {
        System.out.println("Double Click.");
    }
    public void scroll(int direction) {
        if(direction>0)
            System.out.println("Scroll UP.");
        else if(direction<0)
            System.out.println("Scroll Down.");
        else System.out.println("Do not scroll at all).");
    }
}
class EnKeyboard implements Keyboard{

    public void print() {
        System.out.println("Print.");
    }
    public void println() {
        System.out.println("Print Line.");
    }
}
class EnTouchpad implements Touchpad{
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved on  " + s + " pixels.");
    }
}

class EnDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new EnMouse();
    }
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}


class RuDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new RuMouse();
    }
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}