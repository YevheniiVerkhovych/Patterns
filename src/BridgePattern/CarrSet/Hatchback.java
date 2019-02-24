package BridgePattern.CarrSet;

import BridgePattern.Carr;
import BridgePattern.Make;

public class Hatchback extends Carr {
    public Hatchback(Make m) {
        super(m);
    }
   public void showType() {
        System.out.println("Hatchback");
    }
}


