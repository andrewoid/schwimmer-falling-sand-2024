package schwimmer.fallingsand.dagger;

import dagger.Module;
import dagger.Provides;
import schwimmer.fallingsand.Sand;
import schwimmer.fallingsand.SandComponent;
import schwimmer.fallingsand.SandFrame;

import javax.inject.Singleton;

@Module
public interface FallingModule {

    int WIDTH = 300;
    int HEIGHT = 400;

    @Singleton
    @Provides static Sand provideSand() {
        return new Sand(WIDTH, HEIGHT);
    }

    @Provides static SandFrame provideSandFrame(
            Sand sand,
            SandComponent sandComponent
    ) {
        return new SandFrame(sand, sandComponent,WIDTH, HEIGHT+40);
    }
}
