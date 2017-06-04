import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
// I] Analyse du code
// Faites la liste des objets et classes utilisées dans la méthode main.

// II] Ajout d'un knight;
//
// L'objectif est d'ajouter un knight à l'écran, puis d'animer ce knight.
//
// 1) décommentez la ligne //knight.paint(g);
// 2) ajoutez knight comme champ de la classe knight dans Game.
// 3) Initialisez knight dans le constructeur
// 4) Créez la classe knight, et ajoutez la méthode paint (avec la bonne signature)
// 5) dans la méthode paint du knight, ajoutez l'affichage d'un rectangle
// normalement, votre code ne doit plus comporter d'erreur, et afficher un rectangle quand on le lance.
// 6) à la fin du main, ajouter un appel à la méthode play() de l'objet game,
//    et créez cette méthode.
// 7) Dans la méthode play(), créez une boucle sans fin ( while (true){} ).
//    Dans cette boucle, demandez un réaffichage du jeu ( repaint(); ), ainsi
//    Qu'une pause ( Thread.sleep(20); ).
//    Pour corriger l'erreur indiquée eur la ligne avec la commande sleep, sélectionnez
//    "Surround with try/catch"
//    Enfin, toujours dans la boucle, ajoutez un appel à la méthode act() du knight, et créez cette méthode.
// 8) Pour que le knight bouge, il faut maintenant :
//    - remplacer les coordonnées (fixes) du rectangle par deux champs x et y (qui pourront donc varier)
//      x et y devront être déclarées, et initialisées dans un constructeur ( il faut créer le constructeur
//      avec deux paramètres, un pour chaque champ, et donc ajouter deux valeurs lors de l'instanciation
//      de knight dans Game() ).
//    - modifier au moins une des coordonnées ( x ou y ) dans la méthode act() de knight,
//      par exemple avec x = x+1; 
//
// III] Ajout d'un deuxième knight
//
//    Ajoutez un deuxième knight au jeu. (Il n'est pas demandé de créer une nouvelle classe, juste un nouvel objet !)
//
// IV] Ajout d'un rond
//
//    Ajoutez un nouveau knight, dont la classe sera cette fois Rond. La seule différence avec
//    knight sera que Rond affiche un rond ( drawOval au lieu de drawRect )
//
// V] Mouvements
//
//  Modifiez la méthode act de knight ou de Rond pour avoir les mouvements suivants :
//  1) Déplacement vers la droite. Quand le knight va sortir de la fenêtre, il réapparait à gauche.
//  2) Aller et retour horizontal
//  3) Trajectoire carrée
//  4) Trajectoire en zig-zag
//  5) (difficile) Trajectoire circulaire
//
// VI] (difficile) Particules
// Ajoutez un objet de classe Particule, qui suit un des knights ( il occupe à chaque fois la précédente position
// du knight. Vous pouvez ensuite essayer de créer les effets suivants :
// - trace : plusieurs particules ( par exemple 10) suivent exactement un knight, laissant comme un sillage
// - trace évanescente : comme la trace, mais les particules sont de plus en plus petites quand on s'éloigne
//   du knight
// - bulles : les particules, une fois émises par le knight, montent vers le haut de l'écran
// - fumée : comme la trace évanescentes, avec un déplacement aléatoire des particules, et une augmentation de la taille
//   (au lieu de la diminution)
// - gouttes : comme les bulles, mais vers le bas et avec une accélération (correspondant à la gravité)
// - étincelles : comme les gouttes, avec un mouvement aléatoire en plus.

public class Game extends JComponent implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width,height;
	HashSet <Zombies> Zombie;
	HashSet <Objets> Sac;
	Knight knight;
	Zombies zombie1,zombie2,zombie3,zombie4,zombie5,zombie6,zombie7,zombie8,zombie9,zombie10,zombie11,zombie12,zombie13,zombie14,zombie15,zombie16,zombie17,zombie18,zombie19,zombie20,zombie21,zombie22,zombie23;
	Sprite princesse;
	Objets pierre;
	Rond rond, rond2,rond3;
	Level level;
	static BufferedImage emeraude,imgPrincesse,imgKnight,imgKnightRun,imgKnightr,imgKnightRunr,imgKnightAttack,wp,wp2,wp3,cube,scie,coeur,wall,cave,door,cube_un,pics,menu,gameOver,imgFin,menuHelp,zombieimg,zombieRun,zombier,zombieRunr;
	int etat;
	static int vie;
	boolean access=false;
	boolean mvt;

	public Game(Dimension d) {
		width = d.width;
		height = d.height;

		level = new Level();
		knight = new Knight(0,200,level);
		princesse = new Princesse(7450,200,level);
		
		zombie1 = new Zombies(400,300,level,false);
		zombie2 = new Zombies(500,300,level,false);
		zombie3 = new Zombies(1010,100,level,true);
		zombie4 = new Zombies(1290,300,level,false);
		zombie5 = new Zombies(1415,300,level,false);
		zombie6 = new Zombies(1575,300,level,true);
		zombie7 = new Zombies(1550,100,level,false);
		
		zombie8 = new Zombies(2855,100,level,true);
		zombie9 = new Zombies(3040,100,level,false);
		zombie10 = new Zombies(3385,50,level,true);
		zombie11 = new Zombies(3630,50,level,true);
		zombie12 = new Zombies(4135,300,level,false);
		zombie13 = new Zombies(4255,300,level,true);
		zombie14 = new Zombies(4330,300,level,true);
		
		zombie15 = new Zombies(5200,100,level,false);
		zombie16 = new Zombies(5440,200,level,true);
		zombie17 = new Zombies(5515,200,level,true);
		zombie18 = new Zombies(5620,200,level,false);
		zombie19 = new Zombies(5950,150,level,false);
		zombie20 = new Zombies(6050,150,level,false);
		zombie21 = new Zombies(6565,250,level,true);
		zombie22 = new Zombies(6815,250,level,true);
		zombie23 = new Zombies(6995,150,level,true);
		
		Zombie= new HashSet<Zombies>();
		Sac = new HashSet<Objets>();
		pierre= new Objets(4000,200,level);
		rond = new Rond(3300,170,3295,3630);
		rond2 = new Rond(3970,100,3968,4155);
		rond3 = new Rond(6830,200,6540,6850);
		etat =0;
		vie = 5;
		//Liste des zombies
			//Level1
		Zombie.add(zombie1);
		Zombie.add(zombie2);
		Zombie.add(zombie3);
		Zombie.add(zombie4);
		Zombie.add(zombie5);
		Zombie.add(zombie6);
		Zombie.add(zombie7);
			//Level2
		Zombie.add(zombie8);
		Zombie.add(zombie9);
		Zombie.add(zombie10);
		Zombie.add(zombie11);
		Zombie.add(zombie12);
		Zombie.add(zombie13);
		Zombie.add(zombie14);
			//Level3
		Zombie.add(zombie15);
		Zombie.add(zombie16);
		Zombie.add(zombie17);
		Zombie.add(zombie18);
		Zombie.add(zombie19);
		Zombie.add(zombie20);
		Zombie.add(zombie21);
		Zombie.add(zombie22);
		Zombie.add(zombie23);
		
		//Objets
		Sac.add(pierre);
		
		try {
			//Images menu
			menu = ImageIO.read(new File("Ressources/Menu.png"));
			gameOver = ImageIO.read(new File("Ressources/GameOver.png"));
			imgFin = ImageIO.read(new File("Ressources/victoire_modif.png"));
			menuHelp = ImageIO.read(new File("Ressources/Menu_help.png"));
			//Image Princesse
			imgPrincesse = ImageIO.read(new File("Ressources/princess2.png"));
			//Images Chevalier
			imgKnight = ImageIO.read(new File("Ressources/perso/mv/knight.png"));
			imgKnightRun = ImageIO.read(new File("Ressources/perso/mv/knight2.png"));
			imgKnightr = ImageIO.read(new File("Ressources/perso/mv/knight_r.png"));
			imgKnightRunr = ImageIO.read(new File("Ressources/perso/mv/knight2_r.png"));
			//Interaction Chevalier
			imgKnightAttack = ImageIO.read(new File("Ressources/perso/attack/knight_attack2.png"));
			//Images Fonds
			wp = ImageIO.read(new File("Ressources/fond.png"));
			wp2 = ImageIO.read(new File("Ressources/fond2.png"));
			wp3 = ImageIO.read(new File("Ressources/fond3.png"));
			//Autres
			cube = ImageIO.read(new File("Ressources/cube1.png"));
			scie = ImageIO.read(new File("Ressources/scie.png"));
			coeur= ImageIO.read(new File("Ressources/coeur2.png"));
			wall= ImageIO.read(new File("Ressources/wall.png"));
			door= ImageIO.read(new File("Ressources/door.png"));
			cube_un = ImageIO.read(new File("Ressources/cube_under1.png"));
			pics= ImageIO.read(new File("Ressources/pics.png"));
			cave= ImageIO.read(new File("Ressources/wall_cove.png"));
			emeraude = ImageIO.read(new File("Ressources/pierres/emeraude_min.png"));
			//Zombies
			zombieimg= ImageIO.read(new File("Ressources/monsters/zombie/zombie.png"));
			zombieRun= ImageIO.read(new File("Ressources/monsters/zombie/zombierun.png"));
			zombier= ImageIO.read(new File("Ressources/monsters/zombie/zombie_r.png"));
			zombieRunr= ImageIO.read(new File("Ressources/monsters/zombie/zombierun_r.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(d);
		setPreferredSize(d);
	}	
	public void play() {
		while (true){
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (etat==1){
				boolean kill=knight.kill;
				knight.act();
				//Passage au level3
				if (knight.x==4400 && access==true){
					knight.x = 4500;
					knight.y = 100;
				}
				rond.act();
				rond2.act();
				rond3.act();
				princesse.act();
				for (Zombies zombies:Zombie){					
					zombies.act();
				}
				Rectangle r1 = knight.getRectangle();
				//Scies
				Rectangle rect_scie1= rond.getRectangle();
				Rectangle rect_scie2= rond2.getRectangle();
				Rectangle rect_scie3= rond3.getRectangle();
				Rectangle rect_emeraude=pierre.getRectangle();
				//Interaction Emeraude
				if (r1.intersects(rect_emeraude)){
					Sac.remove(pierre);
					access=true;
				}
				//Interaction Pics
				if ((knight.y)>= 360 && knight.cooldown==0){
					vie=vie-1;
					knight.cooldown=60;
				}
				//Intersection avec scies
				if ((r1.intersects(rect_scie1) || r1.intersects(rect_scie2) || r1.intersects(rect_scie3))&& knight.cooldown==0){					
					vie = vie-1;
					knight.cooldown=70;
				}
				//Intersection avec zombies
					//Level1
				if ((r1.intersects(zombie1.getRectangle()) || r1.intersects(zombie2.getRectangle()) ||r1.intersects(zombie3.getRectangle()) || r1.intersects(zombie4.getRectangle()) || r1.intersects(zombie5.getRectangle()) || r1.intersects(zombie6.getRectangle()) || r1.intersects(zombie7.getRectangle()))&& knight.cooldown==0){
					System.out.println(knight.kill);
					if (kill==true){
						Zombie.remove(zombie1);
						Zombie.remove(zombie1.getRectangle());
					}
					//System.out.println(Zombies.dead);
					vie = vie-1;
					knight.cooldown=60;
					kill=false;
				}
					//Level2
				if ((r1.intersects(zombie8.getRectangle()) || r1.intersects(zombie9.getRectangle()) ||r1.intersects(zombie10.getRectangle()) || r1.intersects(zombie11.getRectangle()) || r1.intersects(zombie12.getRectangle()) || r1.intersects(zombie13.getRectangle()) || r1.intersects(zombie14.getRectangle()))&& knight.cooldown==0){
					System.out.println(knight.kill);
					//Zombie.remove(zombie1);
					vie = vie-1;
					knight.cooldown=60;
				}
					//Level3
				if ((r1.intersects(zombie15.getRectangle()) || r1.intersects(zombie16.getRectangle()) || r1.intersects(zombie17.getRectangle()) || r1.intersects(zombie18.getRectangle()) || r1.intersects(zombie19.getRectangle()) || r1.intersects(zombie20.getRectangle()) || r1.intersects(zombie21.getRectangle()) || r1.intersects(zombie22.getRectangle())|| r1.intersects(zombie23.getRectangle())) && knight.cooldown==0){
					System.out.println(knight.kill);
					//Zombie.remove(zombie1);
					vie = vie-1;
					knight.cooldown=60;
				}
				if ((knight.y + 49) > 420 || vie ==0){
					etat=3;
					System.out.println("You're dead");
				}
				if ((knight.x >=princesse.x)){
					etat=2;
					System.out.println("GG MEC!!!");
				}
			}
		}
	}
	
	public void paint(Graphics g){
		if (etat==0){
			g.drawImage(Game.menu,150,0,null);
		}
		
		if (etat==1){
			Graphics2D g2d = (Graphics2D) g;
			int tx = 280- knight.x;
			if (tx > 0) tx = 0;
			g2d.transform(AffineTransform.getTranslateInstance(tx, 0));
			g.drawImage(Game.wp,0,0,null);
			g.drawImage(Game.wp2,2700,0,null);
			g.drawImage(Game.wp3,4450,0,null);
			//g.drawRect(5,5,width-10,height-10);
			//g.clearRect(0,0,640,480);
			level.paint(g);
			princesse.paint(g);
			rond.paint(g);
			rond2.paint(g);
			rond3.paint(g);
			//Emeraude
			for (Objets sac:Sac){
				sac.paint(g);
			}
			//Monstres
			for (Zombies zombies:Zombie){
				zombies.paint(g);
			}
			//Knight
			knight.paint(g);
			// Affiche de la vie
			for (int i =0;i<vie;i++){
				g.drawImage(Game.coeur,-tx+i*50,430,null);
			}
		}
		if (etat==2){
			g.drawImage(Game.imgFin,150,0,null);
		}
		if (etat==3){
			g.drawImage(Game.gameOver,150,0,null);
		}
		if (etat==4){
			g.drawImage(Game.menuHelp,150,0,null);
		}
	}

	public static void main(String[] arg){
		JFrame frame = new JFrame("Game");
		Game game = new Game(new Dimension(640,480));
		
		frame.addKeyListener(game); //permet de prendre en compte les touches du clavier dans le jeu
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.play();
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//Déplacement & saut
		if (arg0.getKeyChar()=='d'){
			knight.droite();
		}
		if (arg0.getKeyChar()=='z'){
			knight.saut();
		}
		if (arg0.getKeyChar()=='s'){
			if ( etat==2 || etat==3 || etat==0){
				etat=1;
			}
		}
		if (arg0.getKeyChar()=='q'){
			knight.gauche();
		}
		if (arg0.getKeyChar()=='h'){
			if (etat==0){
				etat=4;
			}
			else{
				etat=0;
			}
		}
		if (arg0.getKeyChar()=='o'){
			//Attaque
			knight.attaque();
		}
		if (arg0.getKeyChar()=='p'){
			//Défense
		}
		if(arg0.getKeyChar()==' '){
			System.out.println(knight.x);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyChar()=='d'){
			knight.stopx();
		}
		if (arg0.getKeyChar()=='z'){
			knight.stopy();
		}
		if (arg0.getKeyChar()=='s'){
			knight.stopy();
		}
		if (arg0.getKeyChar()=='q'){
			knight.stopx();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
