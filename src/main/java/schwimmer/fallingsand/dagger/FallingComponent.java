package schwimmer.fallingsand.dagger;

import dagger.Component;
import schwimmer.fallingsand.SandFrame;

import javax.inject.Singleton;

@Singleton
@Component(modules = { FallingModule.class })
// Dagger will create a class called DaggerFallingComponent when you *BUILD*
public interface FallingComponent {
    SandFrame frame();
}
