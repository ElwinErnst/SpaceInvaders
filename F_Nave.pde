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
  
    void move() {//MOVIMIENTO DE LA NAVE
        if (left && xNave > 0+75 ) 
              xNave=xNave-15;
        if (right && xNave < width-75)
              xNave=xNave+15;        
    }
    
    void disain() {//DISEÑO DE LA NAVE

 link.resize(150,150);
 image(link,xNave,yNave);
    }
    void shoot() {//DISPARO DE LA NAVE
        
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
    void coliDisp() {//COLICIONES ENTRE DISPAROS
      
      if(lakitu.disparo==true && disparo==true && dist(lakitu.x,lakitu.y,x,y)<15) {//colision entre disparos
        disparo=false;
        lakitu.disparo=false;
      }
    }
}
