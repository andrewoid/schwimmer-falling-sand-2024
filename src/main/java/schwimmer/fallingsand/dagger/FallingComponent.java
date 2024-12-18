package schwimmer.fallingsand.dagger;

import dagger.Component;
import schwimmer.fallingsand.SandFrame;

import javax.inject.Singleton;

@Singleton
@Component(modules = { FallingModule.class })
public interface FallingComponent {
    SandFrame frame();
}
