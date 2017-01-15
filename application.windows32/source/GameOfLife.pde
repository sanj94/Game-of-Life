//Author : Sanjana Gupta
//CS 7492 - Simulation of Biology
//Assignment 1
//Professor Greg Turk

Cell grid[][];
Boolean updateGrid = false;
Boolean sim = false;
Boolean displayText = true;
void setup()
{
  size(600,600);

  
  grid = new Cell[100][100];
  for(int i = 0 ; i < 100 ; i ++)
  {
    for(int j = 0 ;j < 100 ; j++)
    {
      grid[i][j] = new Cell();
    }
  }
  
   frameRate(5);
}

void draw()
{
  background(black);
  
  drawGrid();
  
  if(updateGrid)
  {
   simulate(); 
   updateGrid = false;
  }
  
  if(sim)
  {
    displayText = false;
    simulate();
  }
  if(!sim ||!filming)
  {
     displayText = true;
  }
  if(displayText)
  {
  displayInstructions();
  header();
  }
  if(filming) {videoRecord();}
  
}

//UTILITY FUNCTIONS TO SIMULATE GRID 
void drawGrid()
{
  for(int i = 0 ; i < 100 ; i++)
  {
    for(int j =0 ; j < 100 ; j++)
    {
      if(grid[i][j].state)
      {
        fill(white);
        rect(i*6,j*6,6,6);
      }
     else
     {
       fill(black);
       rect(i*6,j*6,6,6);
     }
    }
  }
}

void updateNeighbours()
{
  for(int i = 0 ; i < 100 ; i ++)
  {
    for(int j = 0 ;j < 100 ; j++)
    {
      grid[i][j].neighbours = 0;
    }
  }
  for(int i = 0; i < 100 ; i++)
  {
    for(int j = 0; j < 100 ; j++)
  {
    for(int k = -1 ; k < 2 ; k++)
    {
      for(int l = -1 ; l < 2 ; l++)
      {
        if(k == 0 && l == 0);
        else
        {
          if(grid[(i+k+100)%100][(j+l+100)%100].state)
          grid[i][j].neighbours++;
        }
      }
    }
  }
  }
}

void updateState()
{
  for(int i =0 ; i < 100 ; i++)
  {
    for(int j =0 ; j < 100 ; j++)
    {
      if(grid[i][j].state == true && grid[i][j].neighbours==2)
      {
         grid[i][j].state = true;
      }
      else if(grid[i][j].neighbours==3 )
      {
         grid[i][j].state = true;
      }
      else
      {
        grid[i][j].state = false;
        
  
      }
    }
  }
}

void simulate()
{
  updateNeighbours();
  updateState();
   updateNeighbours();
  
}

void randomise()
{
  for(int i =0; i<100;i++)
  {
    for(int j = 0; j < 100 ; j++)
    {
      float r = random(1);
      if(r<0.5)
      {
        grid[i][j].state = false;
        
      }
      else
      {
        grid[i][j].state = true;
      }
    }
  }
}

void clearGrid()
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