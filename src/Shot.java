import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Shot {
    private Texture texture;
    private Vector2 positon;
    private float speed = 10f;
    private Rectangle bouds;

    public Shot(float x, float y){
        texture = new Texture(Gdx.files.internal("assets/shot.png"));
        positon = new Vector2(x, y);
        bouds = new Rectangle(
            positon.x,
            positon.y,
            texture.getWidth(),
            texture.getHeight()
        );
    }

    public void update(){
        positon.x += speed; //Mover o tiro para a direita
        bouds.setPosition(positon.x, positon.y);
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, positon.x, positon.y);
    }

    public Rectangle getBound(){
        return bouds;
    }
    public float getX(){
        return positon.x;
    }
    public void dispose(){
        texture.dispose();
    }

}
