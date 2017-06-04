import java.awt.Graphics;
import java.awt.Rectangle;

public class Sprite {

	int x;
	int y;
	int t=-455;
	int vx, vy;
	Level level;
	boolean saut=false;


	Rectangle getRectangle() {
		return new Rectangle(x,y,49,89);
	}
	
	boolean intersects(Rectangle n){
		
		if (this.x == n.x){
			return true;
		}
		else return false;
	}
	
	public Sprite(int x, int y, Level level) {

		this.level = level;
		this.x = x;
		this.y = y;
		this.vx=0;
		this.vy=0;
	}
	public void paint(Graphics g) {

	}
	

	public  void act() {

		
		if (level.valide(x,y+4,50,50)){
			y = y+4;
		}

		/* Déplacement carré
		if(t>=0 && t<50){
			x=x+1;
		}
		if (t>=50 && t<100){
			y=y-1;
		}
		if (t>=100 && t<150){
			x=x-1;
		}
		if (t>=150 && t<200){
			y=y+1;
		}
		if (t==200){
			t=0;
		}*/

		/*	Déplacement zig zag
 		if(t>0 && t<50){
			x=x+1;
		}
		if(t>=50 && t<100){
			y=y+1;
		}
		if(t>=100 && t<150){
			x=x+1;
		}
		if(t>=150 && t<200){
			y=y-1;
		}
		if(t==200){
			t=0;
		}*/

		//x = x+100*Math.cos(arg0);
		//y = y+100*Math.sin(a);
	}
}
