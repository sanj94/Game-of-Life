void keyPressed()
{
  if(key == 'c')
  {
   clearGrid();
  }
  if(key == 'C')
  {
    for(int i = 0 ; i < 100 ; i++)
    {
      for(int j = 0 ; j < 100 ; j++)
      {
        grid[i][j].state = false;
        grid[i][j].neighbours = 0;
      }
    }
  }
  if(key == 'g'){sim = !sim;}
  if(key == 'G'){sim = !sim;}
  if(key == 'r'){randomise();}
  if(key == 'R'){randomise();}
{
  
}
  if(key == 'R'){}
 
  if(key == ' '){ updateGrid = !updateGrid;} 
         
  
  
}

void mousePressed()
{
  for(int i =0 ; i < 100 ; i++)
  {
    for(int j =0 ; j < 100 ; j++ )
    {
      if((mouseX >= i*6 && mouseX < (i+1)*6) && (mouseY >= j*6 && mouseY < (j+1)*6))
      {
        grid[i][j].state = !grid[i][j].state;
      }
    }
  }
}