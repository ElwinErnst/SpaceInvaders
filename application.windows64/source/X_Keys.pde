void keyPressed() { 

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
void keyReleased() { 

  if (keyCode == 37) { 
    left = false;
  } 

  if (keyCode == 39) { 
    right = false;
  }
}
