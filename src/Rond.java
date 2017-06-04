import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Rond {

	int x,y,min,max;
	int t=0;
	boolean trajectoire;

	public Rond(int x, int y,int min, int max){
		this.x = x;
		this.y = y;
		this.min=min;
		this.max=max;
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		AffineTransform transform = AffineTransform.getRotateInstance(t/5.0, 50, 50);
		transform.preConcatenate(AffineTransform.getTranslateInstance(x,y));
		g2d.drawImage(Game.scie,transform ,null);
	}

	public  void act() {
		t=t+1;
		if (trajectoire == false && x<max){
			x = x+1;
		}
		else {
			trajectoire = true;
			x = x-1;
		}
		if (x==min){
			trajectoire = false;
		}
	}
	Rectangle getRectangle() {
		return new Rectangle(x,y,100,100);
	}
}
