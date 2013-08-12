package de.myreality.acidsnake;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.myreality.acidsnake.google.DesktopInterface;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Acid Snake";
		cfg.useGL20 = true;
		cfg.width = 1280;
		cfg.height = 720;
		cfg.vSyncEnabled = true;
		cfg.useCPUSynch = true;
		new LwjglApplication(new SnakeGame(new DesktopInterface()), cfg);
	}
}
