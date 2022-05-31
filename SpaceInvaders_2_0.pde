void setup() {
  size(1100,700,P2D);//P2D 2 dimenciones fijas
  background(0, 0, 255);
///////////////////////////////////////////////////////////////////////
 
  println("1er Trabajo practico Introducción a la Programación de 2019");
  println("Alumnos: Ernst ALex - Moreno Ian");
  println("Profeores: Da Silva Octavio Barzola D Marcos ");

///////////////////////////////////////////////////////////////////////

fontStart=createFont("Triforce.ttf",50);

/////////////////////////SOUNDS////////////////////////////////////////

MainMenu = new SoundFile(this,"mainmenu.mp3");
  Battle = new SoundFile(this,"battle.mp3");
 GameWin = new SoundFile(this,"gamewin.mp3");
GameOver = new SoundFile(this,"gameover.mp3");


////////////////////////IMAGENES///////////////////////////////////////

imageMode(CENTER);
fondogame=loadImage("background.jpg");
    cucco=loadImage("cucco.png");
     BOSS=loadImage("boss.png");
 balaBoss=loadImage("balaboss.png");
 balaNave=loadImage("balanave.png");
 gameover=loadImage("gameover1.jpg");
     link=loadImage("link.png");
 gamewin1=loadImage("gamewin1.png");
fondomenu=loadImage("fondomenu.jpg");
 controls=loadImage("controls.png");

////////////////////////////////////////////////////////////////////////

  Nave = new spaceShip();//inicializacion de la clase nave
  menu = new main_menu();//inicializacion de la clase Main Menu
  Game = new game();//inicializacion de la clase Game
lakitu = new SpaceBoss();//inicializacion de la clase SpaceBoss

for(int i=0; i < Aliens.length; i++) {//INICIALIZACION DE LOS ALIENS
        Aliens[i] = new Invasors(90,160);
}
}
 
void draw() {
 
  frameRate(30); 
  
  if(state==0){//MENU PRINCIPAL
  menu.homeScreen();
    }
    if(state==-1){//MENU DE CONTROLES
  menu.controls();
    }
    if(state==1) {//JUEGO 
  
  Game.Screen();
  
  for(int i=0; i<Aliens.length; i++) {//ALIENS
        Aliens[i].move();//MOVIMIENTO DE LOS ALIENS
        Aliens[i].series(); //FILAS DE ALIENS
  }
  Nave.move();//MOVIMIENTO DE LA NAVE
  Nave.disain();//DISEÑO DE LA NAVE
  Nave.shoot();//DISPARO DE LA NAVE
  Nave.coliDisp();//COLICION ENTRE DISPAROS
  
  lakitu.move();//MOVIMIENTO DEL BOSS
  lakitu.disain();//DISEÑO DEL BOSS
  lakitu.shoot();//DISPARO DEL BOSS
  lakitu.coli();//COLICION DEL DISPARO DEL BOSS CON LA NAVE
    }
    
    if(state == 2){//perdiste
  
  Game.gameOver();//PANTALLA DE GAME OVER
    }
    
    if(state == 3) {//ganaste
  
  Game.gameWin();//PANTALLA DE GAME WIN
    }
    
  
    if(state==4) {
      pause();
      
    }
}
