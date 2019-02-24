package BridgePattern;

public abstract class Carr {
    Make make;

    public Carr(Make m){
        make = m;
    }

    public abstract void  showType();

    public void showDetails(){
        showType();
        make.setMake();
    }
}
