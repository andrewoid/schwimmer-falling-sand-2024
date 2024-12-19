package schwimmer.fallingsand;

import schwimmer.fallingsand.dagger.DaggerFallingComponent;
import schwimmer.fallingsand.dagger.FallingComponent;

public class Main {

    public static void main(String[] args) {
        FallingComponent component = DaggerFallingComponent
                .builder()
                .build();
        SandFrame frame = component.frame();
        frame.setVisible(true);
    }

}
