import java.awt.Graphics;


public class Princesse extends Sprite {

	public Princesse(int x, int y, Level level) {
		super(x, y, level);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		g.drawImage(Game.imgPrincesse,x,y,null);
	}
	public  void act() {

		
		if (level.valide(x,y+1,89,100)){
			y = y+1;
		}
	}
}
