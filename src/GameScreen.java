import java.util.Iterator;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class GameScreen extends ApplicationAdapter  {
    private SpriteBatch batch;
    private Texture background;
    private Player player;
    private Array<Obstacle> obstacles;
    private long lastObstacleTime;
    private int score;
    private int powers;
    private Array<Shot> shots; //tiros
    private BitmapFont font;

    @Override
    public void create(){
        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("assets/city_background.png"));
        player = new Player();
        obstacles = new Array<>();
        spawnObstacle();

        score = 0;
        powers = 0;
        shots = new Array<>();
        font = new BitmapFont();
    }

    @Override
    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //atualiza a lógica do jogo
        update();

        //inicia o desenho dos elementos
        batch.begin();;
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        player.draw(batch);

        for(Obstacle obstacle : obstacles){
            obstacle.draw(batch);
        }
        for(Shot shot : shots){
            shot.draw(batch);
        }
        font.draw(batch, "Score: " + score, 10, Gdx.graphics.getHeight() - 10);
        font.draw(batch, "Powers: " + powers, 10, Gdx.graphics.getHeight() - 30);

        batch.end();        
    }

    private void update(){
        //verifica se a tecla espaço foi pressionada
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.jump();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && powers > 0){
            userPower();
        }
        player.update();

        //a cada 2 segundos cria um obstáculo
        if(TimeUtils.nanoTime() - lastObstacleTime > 2000000000){
            spawnObstacle();
        }

        //atualiza a posição de cada obstáculo e verifica as colisões
        for(Obstacle obstacle : obstacles){
            obstacle.update();
            if(obstacle.getBounds().overlaps(player.getBounds())){
                //reiniciar caso colisão
                Gdx.app.log("Game", "Game Over! Jogador acertou o obstáculo");
                resetGame();
                break;
            }
            if(obstacle.getPosition().x < -obstacle.getWidth()){
                score++;
                if(score % 2 == 0)
                    powers++;
            }
        }
        //atualizar a posição de cada tiro e
        // verificar colisões com os obstáculos:
        for(Shot shot : shots){
            shot.update();
            for(Obstacle obstacle : obstacles){
                if(shot.getBound().overlaps(obstacle.getBounds())){
                    shots.removeValue(shot, true);
                    obstacles.removeValue(obstacle, true);
                    break;
                }
            }
        }

        //remover obstáculos fora da tela
        for(Iterator<Obstacle> iterator = obstacles.iterator(); iterator.hasNext();){
            Obstacle obstacle = iterator.next();
            if(obstacle.getPosition().x < -obstacle.getWidth()){
                iterator.remove();
            }
        }

        //remover tiros fora da tela
        for(Iterator<Shot> iterator = shots.iterator(); iterator.hasNext();){
            Shot shot = iterator.next();
            if(shot.getX() > Gdx.graphics.getWidth()){
                iterator.remove();
            }
        }
    }

    private void spawnObstacle(){
        obstacles.add(new Obstacle(Gdx.graphics.getWidth(),100)); //cria o obstáculo fora da tela
        lastObstacleTime = TimeUtils.nanoTime();
    }

    private void resetGame(){
        obstacles.clear();
        player.reset();
        score = 0;
        powers = 0;
        spawnObstacle();
    }

    @Override
    public void dispose(){
        batch.dispose();
        background.dispose();
        player.dispose();
        font.dispose();
        for(Obstacle obstacle : obstacles){
            obstacle.dispose();
        }
        for(Shot shot : shots){
            shot.dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    private void userPower(){
        if(powers > 0){
            Shot shot = new Shot(
                player.getPosition().x + player.getBounds().width,
                player.getPosition().y + player.getBounds().height/2
            );
            shots.add(shot);
            powers--; //diminuir a qte de poder
            Gdx.app.log("Game", "Poder utilizado!");
        }
    }

}