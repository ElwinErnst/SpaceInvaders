import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SpaceInvaders_2_0 extends PApplet {

public void setup() {
  //P2D 2 dimenciones fijas
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
 
public void draw() {
 
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
PFont fontStart;//Fuente de texto



SoundFile MainMenu;
SoundFile Battle;
SoundFile GameOver;
SoundFile GameWin;


PImage cucco;
PImage fondogame;
PImage balaNave;
PImage balaBoss;
PImage BOSS;
PImage gameover;
PImage link;
PImage gamewin1;
PImage fondomenu;
PImage controls;

boolean bandera1=true;
boolean bandera2=true;
boolean bandera3=true;
boolean bandera4=true;

int score;//contador de puntos
int vida=24;//vidas de los aliens

int state=0;//estados

boolean right=false;//mov. de la nave (hacia la der)
boolean left=false;//mov. de la nave (hacia la izq)
main_menu menu;

class main_menu {
  main_menu() {
  GameOver.stop();
  GameWin.stop();
  if(bandera1==true) {
    MainMenu.play();
    bandera1=false;
  }
  }
  public void homeScreen() {
   //background(255);                     //FONDO MENU PRINCIPAL
      image(fondomenu ,width/2 ,height/2,width,height);
      textAlign(CENTER);                      //FUENTE DE TEXTO
      textFont(fontStart,50);
      
      
      /////////////////////////BOTON DE START
      
                     
      fill(255, 174, 0);
      text("START",width/2,600);
      
   if(mouseX>width/2-110 && mouseX<width/2+110 && mouseY>600-40 && mouseY<600) {//coliciones del boton
      fill(255, 72, 0);
      text("START",width/2,600);
   if(mousePressed) {//colicion de cambio de estado
      MainMenu.stop(); 
      bandera1=false;
      Battle.play();
      bandera2=true;
      bandera3=true;
      bandera4=true;
      
      state=1;
   }
   }
   
   //////////////////////////BOTON DE CONTROLES
   
      fill(255, 174, 0);
      text("Controls",width/5,600);
   if(mouseX>width/5-110 && mouseX<width/5+110 && mouseY>600-40 && mouseY<600+40) {//coliciones del boton
      fill(255, 72, 0);
      text("Controls",width/5,600);
   if(mousePressed) {//colicion de cambio de estado
      state=-1;
   }
   } 
   
   ////////////////////////BOTON DE EXIT
     
      fill(255, 174, 0);
      text("Exit",width/1.25f,600);
   if(mouseX>width/1.25f-60 && mouseX<width/1.25f+60 && mouseY>600-40 && mouseY<600+40) {//coliciones del boton
      fill(255, 72, 0);
      text("Exit",width/1.25f,600);
   if(mousePressed) {//colicion de cambio de estado
      exit();
   }
   }
  }
  
  public void controls() {//PANTALLA DE CONTROLES
    fill(0,0,0,40);
    noStroke();
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    
    textAlign(CORNER);
    fill(255, 174, 0);
    
    textSize(50);
    
    text("CONTROLES",width/10,height/10);
    image(controls,350,200,500,350);
    //textSize(20);
    
    //text("press left and right buttons to move the ship",width/10,height/5); 
    //text("press spacebar button to shoot",width/10,height/4);
 
 ////////////////////BOTON PARA VOLVER A MENU PRINCIPAL
    
    textAlign(CENTER);
    fill(255, 174, 0);
    text("Return",width-120,80);
    
   if(mouseX>width-120-60 && mouseX<width-120+60 && mouseY>80-20 && mouseY<80+20) {//coliciones del boton
     fill(255, 72, 0);
     text("Return",width-120,80);
   if(mousePressed) {//colicion de cambio de estado
    state=0;
   }
   }
}
}
game Game;
class game {
  public void Screen() {
 
      image(fondogame, width/2,height/2,width,height); 
      
      textSize(25);
      fill(0);
      
      text("SCORE",70,50);
      text(score,150,50);
      
      text("FPS  ",width-100,50);
      text(PApplet.parseInt(frameRate),width-50,50);
      
      text("HEARTS  ",width-600,50);
      text(Nave.hearts,width-530,50);
  
   if(key=='p') {
    state=4;
   }
  }
    
  public void gameOver() {
      Battle.stop();
      image(gameover,width/2,height/2,width,height);
      textFont(fontStart,100);
      noStroke();
      fill(0);
      text("game over",width/2,height/4);
      
        textAlign(CENTER);
        textSize(50);
        stroke(0);
        fill(255);
        text("Main Menu", width/2, 650);
        
    if(mouseX>width/2-140 && mouseX<width/2+140 && mouseY>650-40 && mouseY<650+40) {//coliciones del boton
      textSize(50);
      stroke(0);
      fill(55);
      text("Main Menu", width/2,650);
    if(mousePressed) {//colision de cambio de estado
      GameWin.stop();
      bandera1=true;
      state = 0;//VUELVE AL MENU
      if(bandera1==true) {
        MainMenu.play();//inicia la musica del menu principal
        bandera1=false;
      }
      Nave.xNave=width/2;//LA NAVE VUELVE A LA POCICION ORIGINAL
      Nave.disparo=false;//EL DISPARO ES FALSO
      score=0;//EL PUNTAJE VUELVE A 0
      lakitu.y=lakitu.xlakitu;//bala vuelve a la posicion inicial
      lakitu.disparo=false;//EL DISPARO DEL BOSS SE VUELVE FALSO
      Nave.hearts=3;//LAS VIDAS DE LA NAVE VUELVEN A SER 3
      vida=24;//contador de aliens vivos
      lakitu.xlakitu=width-60;//el lakitu vuelve a su posicion original
      
      for(int i=0; i < Aliens.length; i++) {//INICIALIZACION DE LOS ALIENS
        Aliens[i] = new Invasors(90,160);
      }
      
    }  
    } 
  }
  public void gameWin() {
   
      Battle.stop();
      image(gamewin1,width/1.2f,height/1.2f,width,height);
      
      textFont(fontStart,100);
      fill(0);
      text("YOU WIN",width/2,height/2);
      
   ////////////////BOTON PARA SALIR AL MENU   
      
        textAlign(CENTER);
        textSize(50);
        fill(255);
        text("Main Menu", width/2, 650);
        
      
    if(mouseX>width/2-140 && mouseX<width/2+140 && mouseY>650-40 && mouseY<650+40) {//coliciones del boton
      textSize(50);
      fill(55);
      text("Main Menu", width/2,650);
    if(mousePressed) {//colicion de cambio de estado
      GameWin.stop();
      bandera1=true;
      state = 0;//VUELVE AL MENU
      if(bandera1==true) {
        MainMenu.play();//inicia la musica del menu principal
        bandera1=false;
      }
      Nave.xNave=width/2;//LA NAVE VUELVE A LA POCICION ORIGINAL
      Nave.disparo=false;//EL DISPARO ES FALSO
      score=0;//EL PUNTAJE VUELVE A 0
      lakitu.y=lakitu.xlakitu;//bala vuelve a la posicion inicial
      lakitu.disparo=false;//EL DISPARO DEL BOSS SE VUELVE FALSO
      Nave.hearts=3;//LAS VIDAS DE LA NAVE VUELVEN A SER 3
      vida=24;//contador de los aliens vivos
      lakitu.xlakitu=width-60;//el lakitu vuelve a su posicion original
      
      for(int i=0; i < Aliens.length; i++) {//INICIALIZACION DE LOS ALIENS
        Aliens[i] = new Invasors(90,160);
      }
    } 
    } 
  }
}
Invasors[] Aliens = new Invasors[24];

class Invasors {
  float xpos, ypos;//POSICION DE LOS ALIENS
  int X_count, Y_count;//CONTADORES PARA LA SEPARACION DE LOS ALIENS
  int diam;//DIAMETRO DE LOS ALIENS
  float dirAlien;//VARIABLE DE DIRECCION
  boolean alive;//VIDA DE LOS ALIENS

Invasors(int x, int y) {
  
  ypos=y;   
    Y_count=0;
  xpos=x;
    X_count=0;

  dirAlien=5;
  
  alive=true;
  
  diam=50;
  }
  public void move() {//MOV ALIENS
    xpos = xpos + dirAlien; 
      if ((xpos > width - 670) || (xpos < 50)) {
      dirAlien = dirAlien * (-1); 
        ypos+=30;
      }
   }
  
  public void disign(float x, float y) {//DISEÑO DE LOS ALIENS
    if( alive == true) {
    cucco.resize(50,50);
    image(cucco,x,y);
        
        if (ypos>=640) {//PASA AL ESTADO DE GAME OVER
          state=2;//gameOver
          ypos= 0;
       }
    }
 }
 public void series() {//FILAS DE ALIENS
    for(int i=0; i < Aliens.length/3; i++) {     
      Aliens[i].coli(xpos+X_count*90,ypos+Y_count*60);///FILA 1
      Aliens[i].disign(xpos+X_count*90,ypos+Y_count*60);

        X_count++;//SE SUMA CADA CICLO PARA LA SEPARACION DE LOS ALIENS
        
    }
        Y_count++;//SE SEPARAN DE LA SIGUIENTE FILA
        X_count=0;//EL CONTADOR EN X VUELVE A 0
        
    for(int i=8; i < 2*Aliens.length/3; i++) {
      Aliens[i].coli(xpos+X_count*90,ypos+Y_count*60);///FILA 2
      Aliens[i].disign(xpos+X_count*90,ypos+Y_count*60);
 
        X_count++;
    }
        Y_count++;
        X_count=0;
                
    for(int i=16; i < Aliens.length; i++) {
      Aliens[i].coli(xpos+X_count*90,ypos+Y_count*60);///fILA 3
      Aliens[i].disign(xpos+X_count*90,ypos+Y_count*60);
       
        X_count++; 
    }
        Y_count=0;//AL SER LA ULTIMA FILA ESTE VUELVE A SER 0
        X_count=0;
  }
  public void coli(float a, float b) {
      
    if(dist(a ,b ,Nave.x ,Nave.y )<diam/2+Nave.diam/2 && alive) {//colision entre nave y aliens.
        
        Nave.y = Nave.xNave;//el disparo vuelve a la nave
        alive = false;//el alien "muere"
        Nave.disparo = false;//el disparo desaparece
        score = score+10;//se suman 10 puntos
        vida=vida-1;
      
    }
      if(vida==0) {//YOU WIN
        if(bandera3==true) {
          Battle.stop();
          GameWin.play();
          bandera3=false;
        }
        state=3;
      }
    }
}
spaceShip Nave;

class spaceShip {
  
  int diam;//de la nave
  int y;//pos en eje y del disparo
  int x;//pos en eje x del disparo
  int xNave;//pos en eje x de la nave
  int yNave;//pos en eje y de la nave
  boolean disparo;//disparo de la nave
  int hearts;//vidas de la nave
  
spaceShip() {
  
  diam=10;
  xNave=width/2;
  y=yNave;
  x=xNave;
  yNave=670;
  disparo=false;
  hearts=3;
  }
  
    public void move() {//MOVIMIENTO DE LA NAVE
        if (left && xNave > 0+75 ) 
              xNave=xNave-15;
        if (right && xNave < width-75)
              xNave=xNave+15;        
    }
    
    public void disain() {//DISEÑO DE LA NAVE

    link.resize(150,150);
    image(link,xNave,yNave);
    
    }
    public void shoot() {//DISPARO DE LA NAVE
        
      if(disparo==true) {//SI ES VERDADERO
      
        image(balaNave,x,y,diam,diam);//SE DIBUJA
          y=y-20;
          
      } else {//SINO
        x=xNave;//SE QUEDA EN LA POCICION INICIAL (Y NO SE DIBUJA)
        y=yNave;
      disparo=false;//disparo queda falso
      }
      if(Nave.y<0) {//SI EL DISPARO SALE DE LA PANTALLA SE VUELVE FALSO
        Nave.disparo=false;
      }
    }
    public void coliDisp() {//COLICIONES ENTRE DISPAROS
      
      if(lakitu.disparo==true && disparo==true && dist(lakitu.x,lakitu.y,x,y)<15) {//colision entre disparos
        disparo=false;
        lakitu.disparo=false;
      }
    }
}
SpaceBoss lakitu;

class SpaceBoss {
  
  int dirBoss;
  int diam;
  int ylakitu;
  int xlakitu;
  int y;
  int x;
  boolean disparo;  
  
  SpaceBoss() {

    dirBoss=5;  
    diam=10;
    xlakitu=width-60;
    x=xlakitu;
    ylakitu=100;
    y=ylakitu;
    disparo=false;
  }  

  public void disain() {
   
    fill(0, 50, 0);
    image(BOSS,xlakitu,ylakitu,100,100);
   
  }
  public void move() {
    
    xlakitu = xlakitu + dirBoss; 
    if ((xlakitu > width - 50) || (xlakitu < 50)) {
      dirBoss  = dirBoss * (-1);
    }
  }
  public void shoot() {

    if (Nave.xNave==lakitu.xlakitu) {
      disparo=true;
    }  
    if (disparo==true) {
      image(balaNave,x,y,diam,diam);
      
      y=y+10;
    } else {
      y=ylakitu;
      x=xlakitu;
    }
    if (y>height) {
      disparo=false;
      y=xlakitu;
    }
  }
  public void coli() {
   if(dist(Nave.xNave,Nave.yNave,x,y)<75+5) {
    
    disparo=false;
    Nave.hearts=Nave.hearts-1;
    y=xlakitu;
   }
    if(Nave.hearts==0) {
      if(bandera4==true) {
        Battle.stop();
        GameOver.play();
        bandera4=false;
      }
      state=2;
    }
  
  }
}
public void keyPressed() { 

  if (keyCode == 37) { 
    left = true;
  } 

  if (keyCode == 39) { 
    right = true;
  }
  if (keyCode == 32) { 
    Nave.disparo = true;
  }
} 
public void keyReleased() { 

  if (keyCode == 37) { 
    left = false;
  } 

  if (keyCode == 39) { 
    right = false;
  }
}
public void pause() {
      
      noFill();
      noStroke();      
      rect(width/2,height/2,width,height);
      textSize(100);
      fill(0);
      text("pause",width/2,height/2);
      text("score ",width/2-150,450);
      textSize(80);
      text(score,width/2+110,440);
      
      if(key=='o') {
        state=1;
      }
}
  public void settings() {  size(1100,700,P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SpaceInvaders_2_0" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}