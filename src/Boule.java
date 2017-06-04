import java.awt.Rectangle;


public class Boule extends Rond{
	
	boolean impact;
	
	Rectangle getRectangle() {
		return new Rectangle(x,y,50,50);
	}
	
	boolean intersects(Rectangle n){
		
		if (this.x == n.x){
			return true;
		}
		else return false;
	}
	
	public Boule(int x, int y) {
		super(x, y, y, y);
	}

	public  void act() {
		
		if (trajectoire == false && x<540){
			x = x+1;
		}
		else {
			impact = true;
		}
	}
}
