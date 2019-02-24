
public class FacadePattern {
    public static void main(String[] args) {
    Computer computer = new Computer();
    computer.copy();
    }
}

class Computer{
        Power power = new Power();
        DVDRom dvd = new DVDRom();
        HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("System is on!");
    }
    void off() {
        System.out.println("System is off!");
    }
}
class DVDRom {
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        data = true;
    }
    void unload() {
        data = false;
    }
}
class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()){
            System.out.println("Data is copied!");
        }
        else System.out.println("Please, insert disk with data!");
    }
}