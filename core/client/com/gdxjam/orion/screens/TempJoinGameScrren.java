package com.gdxjam.orion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.gdxjam.orion.Assets;
import com.gdxjam.orion.ClientGameManager;
import com.gdxjam.orion.GameManager.ShipType;
import com.gdxjam.orion.net.Network;

public class TempJoinGameScrren implements Screen {

	private Stage stage = new Stage();
	private Table table = new Table();

	private Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"), new TextureAtlas(Gdx.files.internal("skin/uiskin.atlas")));

	private TextButton buttonPlay = new TextButton("Play", skin), buttonExit = new TextButton("Exit", skin);
	private TextField ip = new TextField("127.0.0.1", skin);
	private SelectBox<ShipType> shipType;
	private ShipType selected;

	@Override
	public void show() {

		Assets.load();
		Assets.create();

		Assets.getManager().finishLoading();

		shipType = new SelectBox<ShipType>(Assets.skin);
		shipType.setItems(ShipType.DEFAULT, ShipType.SHOOTER, ShipType.TESTSHIP);
		shipType.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				selected = shipType.getSelected();

			}
		});

		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ClientGameManager.setShipType(selected);
				Network.setIP(ip.getText());
				ClientGameManager.setScreen(new ClientGameScreen());
			}
		});

		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});

		table.add(ip).row();
		table.add(shipType).row();
		table.add(buttonPlay);
		table.add(buttonExit);

		table.setFillParent(true);
		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().setScreenSize(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();

	}

}
