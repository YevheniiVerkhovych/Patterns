package BridgePattern.CarrSet;

import BridgePattern.Carr;
import BridgePattern.Make;

public class Sedan extends Carr {
    public Sedan(Make m) {
        super(m);
        }
  public   void showType() {
    System.out.println("Sedan");
        }
}
