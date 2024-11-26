import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;
    private final float GRAVITY = -0.3f;
    private final float JUMP_VELOCITY = 15f;
    
    public Player(){
        texture = new Texture(Gdx.files.internal("assets/player.png"));
        position = new Vector2(50,100);
        velocity = new Vector2(0,0);
        bounds = new Rectangle(
            position.x,
            position.y,
            texture.getWidth(),
            texture.getHeight()
        );
    }

    public void update(){
        velocity.y += GRAVITY;
        position.add(velocity);
        //Limite mínimo do chão:
        if(position.y < 100){
            position.y = 100;
            velocity.y = 0;
        }
        bounds.setPosition(position);
    }
    public void jump(){
        if(position.y == 100){
            velocity.y = JUMP_VELOCITY;
        }
    }
    public void draw(SpriteBatch batch){
        batch.draw(texture, position.x, position.y);
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public Vector2 getPosition(){
        return position;
    }
    public void reset(){
        position.set(50,100);
        velocity.set(0,0);
    }
    public void dispose(){
        texture.dispose();
    }
}
