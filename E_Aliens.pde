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
  void move() {//MOV ALIENS
    xpos = xpos + dirAlien; 
      if ((xpos > width - 670) || (xpos < 50)) {
      dirAlien = dirAlien * (-1); 
        ypos+=30;
      }
   }
  
  void disign(float x, float y) {//DISEÑO DE LOS ALIENS
    if( alive == true) {
    cucco.resize(50,50);
    image(cucco,x,y);
        
        if (ypos>=640) {//PASA AL ESTADO DE GAME OVER
          state=2;//gameOver
          ypos= 0;
       }
    }
 }
 void series() {//FILAS DE ALIENS
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
  void coli(float a, float b) {
      
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
