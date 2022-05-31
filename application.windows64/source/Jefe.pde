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

  void disain() {
   
    fill(0, 50, 0);
    image(BOSS,xlakitu,ylakitu,100,100);
   
  }
  void move() {
    
    xlakitu = xlakitu + dirBoss; 
    if ((xlakitu > width - 50) || (xlakitu < 50)) {
      dirBoss  = dirBoss * (-1);
    }
  }
  void shoot() {

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
  void coli() {
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
