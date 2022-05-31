void pause() {
      
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
