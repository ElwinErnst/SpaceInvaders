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
  void homeScreen() {
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
      text("Exit",width/1.25,600);
   if(mouseX>width/1.25-60 && mouseX<width/1.25+60 && mouseY>600-40 && mouseY<600+40) {//coliciones del boton
      fill(255, 72, 0);
      text("Exit",width/1.25,600);
   if(mousePressed) {//colicion de cambio de estado
      exit();
   }
   }
  }
  
  void controls() {//PANTALLA DE CONTROLES
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
