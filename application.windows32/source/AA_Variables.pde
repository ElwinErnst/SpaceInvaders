PFont fontStart;//Fuente de texto

import processing.sound.*;

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
