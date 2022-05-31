game Game;
class game {
  void Screen() {
 
      image(fondogame, width/2,height/2,width,height); 
      
      textSize(25);
      fill(0);
      
      text("SCORE",70,50);
      text(score,150,50);
      
      text("FPS  ",width-100,50);
      text(int(frameRate),width-50,50);
      
      text("HEARTS  ",width-600,50);
      text(Nave.hearts,width-530,50);
  
   if(key=='p') {
    state=4;
   }
  }
    
  void gameOver() {
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
  void gameWin() {
   
      Battle.stop();
      image(gamewin1,width/1.2,height/1.2,width,height);
      
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
