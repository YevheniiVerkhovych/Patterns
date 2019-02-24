package BridgePattern;

import BridgePattern.CarrSet.*;
import BridgePattern.MakeSet.*;

public class BridgeApp {

    public static void main(String[] args) {
        Carr c = new Hatchback(new Mercedes());
        c.showDetails();

    }
}

