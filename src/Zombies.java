import java.awt.Graphics;


public class Zombies extends Knight {

	static boolean dead=false;
	boolean mvt;
	int t=0;
	boolean trajectoire;
	int x,y,defaut;
	
	public Zombies(int x, int y, Level level,boolean mvt) {
		super(x, y, level);
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.mvt=mvt;
		this.defaut=x;
	}
	public void paint(Graphics g) {
		if (trajectoire==true){
			g.drawImage(Game.zombier,x,y,null);
		}
		else
		g.drawImage(Game.zombieimg,x,y,null);
	}
	
public  void act() {
	t=t+1;
		if (level.valide(x,y+4,49,89)){
			y = y+4;
		}
		if (kill == true){
			dead=true;
		}
		dead=true;
		if (mvt==true){
			if (trajectoire == false && x<defaut+20){
				x = x+1;
			}
			else {
				trajectoire = true;
				x = x-1;
			}
			if (x==defaut-20){
				trajectoire = false;
			}
		
		}
	}
}
