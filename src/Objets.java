import java.awt.Graphics;
import java.awt.Rectangle;


public class Objets extends Sprite{

	public Objets(int x, int y, Level level) {
		super(x, y, level);
		// TODO Auto-generated constructor stub
	}

	Rectangle getRectangle() {
		return new Rectangle(x,y,40,40);
	}
	
	public void paint(Graphics g) {
		g.drawImage(Game.emeraude,x,y,null);
	}
}
