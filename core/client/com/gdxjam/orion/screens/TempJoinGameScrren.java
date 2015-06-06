package com.gdxjam.orion.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gdxjam.orion.ClientGameManager;
import com.gdxjam.orion.ClientMain;
import com.gdxjam.orion.net.Network;

public class TempJoinGameScrren implements Screen {

    private Stage stage = new Stage();
    private Table table = new Table();
	
    private Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"),
            new TextureAtlas(Gdx.files.internal("skin/uiskin.atlas")));

    private TextButton 
    		buttonPlay = new TextButton("Play", skin),
            buttonExit = new TextButton("Exit", skin);
    private TextField
    		ip = new TextField("127.0.0.1", skin);

	
	@Override
    public void show() {
        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	Network.setIP(ip.getText());
//            Didn't know how to change screens
            }
        });
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        
		table.add(ip).row();
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
		// TODO Auto-generated method stub
		
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
