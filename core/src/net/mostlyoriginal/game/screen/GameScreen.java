package net.mostlyoriginal.game.screen;

import com.artemis.SuperMapper;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.link.EntityLinkManager;
import com.badlogic.gdx.graphics.Color;
import net.mostlyoriginal.api.screen.core.WorldScreen;
import net.mostlyoriginal.api.system.camera.CameraSystem;
import net.mostlyoriginal.api.system.graphics.RenderBatchingSystem;
import net.mostlyoriginal.api.system.physics.PhysicsSystem;
import net.mostlyoriginal.api.system.render.AnimRenderSystem;
import net.mostlyoriginal.api.system.render.ClearScreenSystem;
import net.mostlyoriginal.game.*;
import net.mostlyoriginal.game.system.*;
import net.mostlyoriginal.game.system.view.GameScreenAssetSystem;
import net.mostlyoriginal.plugin.OperationsPlugin;
import net.mostlyoriginal.plugin.ProfilerPlugin;

/**
 * Example main game screen.
 *
 * @author Daan van Yperen
 */
public class GameScreen extends WorldScreen {

    public static final String BACKGROUND_COLOR_HEX = "969291";

    @Override
    protected World createWorld() {
        RenderBatchingSystem renderBatchingSystem;
        return new World(new WorldConfigurationBuilder()
                .dependsOn(EntityLinkManager.class, ProfilerPlugin.class, OperationsPlugin.class)
                .with(
                        new SuperMapper(),
                        new EmotionService()
                )
                .with(

                        // Replace with your own systems!
                        new CameraSystem(2),
                        new ClearScreenSystem(Color.valueOf(BACKGROUND_COLOR_HEX)),
                        new GameScreenAssetSystem(),
                        new SetupWorldSystem(),
                        new VisitorSpawnSystem(),
                        new DesireSystem(),
                        new HuntSystem(),
                        new UseSystem(),
                        new DirtySystem(),
                        new VisitorSystem(),
                        new PlayerControlSystem(),
                        new PlayerSystem(),
                        new CoinSystem(),
                        new PhysicsSystem(),
                        renderBatchingSystem = new RenderBatchingSystem(),
                        new AnimRenderSystem(renderBatchingSystem),
                        new AngerRenderSystem()
                ).build());
    }

}
