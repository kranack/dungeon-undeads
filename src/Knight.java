import java.awt.Graphics;



public class Knight extends Sprite {

	boolean sens=true;
	boolean course=false;
	boolean attack=false;
	boolean touche=false;
	boolean parer=false;
	boolean kill=false;
	int cooldown=0;
	int timer=0;
	int time_life=100;
	public Knight(int x, int y, Level level) {
		super(x, y, level);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		if (sens==true){
			if (course == true){
				g.drawImage(Game.imgKnightRun,x,y,null);
			}
			else
				g.drawImage(Game.imgKnight,x,y,null);
		}
		else {
			if (course==true){
				g.drawImage(Game.imgKnightRunr,x,y,null);
			}
			else{
				g.drawImage(Game.imgKnightr,x,y,null);
			}
		}
		if(attack == true){
			//g.drawImage(Game.imgKnightAttack,x,y,null);
		}
	}

	public  void act() {
		timer=timer+1;

		//Regain de vie
		time_life= time_life-1;
		if (time_life==0){
			if (Game.vie <5){
				Game.vie = Game.vie+1;
				time_life=400;
			}
			else
				time_life=400;
		}
		//Cooldown
		if (cooldown >0){
			cooldown= cooldown-1;
		}
		//Collision
		if (level.valide(x,y+5,49,89) && !saut){
			y = y+5;
		}
		//Saut
		if (saut) {
			t = t+1;
			if (this.t>=2 && this.t<10){
				if (level.valide(x,y-10,49,89) ){
					y=y-10;
				} else {
					saut = false;
				}
			}
			if (this.t>=10 && this.t<15){
				if (level.valide(x,y-5,49,89)){
					y=y-5;
				}else {
					saut=false;
				}
			}
			if (this.t>=15 && this.t<17){
				if (level.valide(x,y-4,49,89) ) {
					y=y-4;
				}else {
					saut=false;
				}
			}
			if (level.valide(x,y+5,49,89) && this.t>=17){
				saut=false;
			}
		}
		//Déplacement
		if (level.valide(x+vx,y+vy,49,89)) {
			x=x+vx;
			y=y+vy;
		}
		//Attaque
		if (attack==true){
				kill=true;
			attack=false;
		}

	}
	public void gauche() {
		// TODO Auto-generated method stub
		vx=-5;
		sens=false;
		int run=0;
		run=x%timer;
		if (run<timer/2){
			course=false;
		}
		else{
			course=true;
		}
	}
	public void haut() {
		// TODO Auto-generated method stub
		vy=-5;
	}
	public void bas() {
		// TODO Auto-generated method stub
		vy=5;
	}
	public void droite() {
		// TODO Auto-generated method stub
		vx=5;
		sens=true;
		int run=0;
		run=x%timer;
		if (run<timer/16){
			course=false;
		}
		else{
			course=true;
		}
	}
	public void stopx() {
		// TODO Auto-generated method stub
		vx=0;
	}
	public void stopy() {
		// TODO Auto-generated method stub
		vy=0;
	}
	public void saut() {
		// TODO Auto-generated method stub
		t=0;
		if (!(level.valide(x,y+5,49,89))){
			saut = true;
			t=0;
		}
	}

	public void attaque() {
		// TODO Auto-generated method stub
		attack=true;
	}

}
