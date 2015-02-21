package net.mostlyoriginal.game.system.render;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * Clearing the screen.
 *
 * @author Daan van Yperen
 */
public class ClearScreenSystem extends VoidEntitySystem {

	private final Color color;

	public ClearScreenSystem() {
		this(Color.BLACK);
	}

	public ClearScreenSystem(Color color) {
		this.color = color;
	}

	@Override
	protected void processSystem( ) {
		Gdx.gl.glClearColor(color.r, color.g,color.b,color.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
