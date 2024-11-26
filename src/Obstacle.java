import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Obstacle {
    private Texture texture;
    private Vector2 position;
    private Rectangle bounds;
    private final float SPEED = 5f;

    public Obstacle(float x, float y){
        texture = new Texture(Gdx.files.internal("assets/obstacle.png"));
        position = new Vector2(x, y);
        bounds = new Rectangle(
            position.x,
            position.y,
            texture.getWidth(),
            texture.getHeight()
        );
    }
    public void update(){
        position.x -= SPEED;
        bounds.setPosition(position);
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
    public float getWidth(){
        return texture.getWidth();
    }
    public void dispose(){
        texture.dispose();
    }
}
