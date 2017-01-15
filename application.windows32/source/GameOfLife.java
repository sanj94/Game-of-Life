import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class GameOfLife extends PApplet {

//Author : Sanjana Gupta
//CS 7492 - Simulation of Biology
//Assignment 1
//Professor Greg Turk

Cell grid[][];
Boolean updateGrid = false;
Boolean sim = false;
Boolean displayText = true;
public void setup()
{
  

  
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

public void draw()
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
public void drawGrid()
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

public void updateNeighbours()
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

public void updateState()
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

public void simulate()
{
  updateNeighbours();
  updateState();
   updateNeighbours();
  
}

public void randomise()
{
  for(int i =0; i<100;i++)
  {
    for(int j = 0; j < 100 ; j++)
    {
      float r = random(1);
      if(r<0.5f)
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

public void clearGrid()
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
class Cell
{
  Boolean state;
  int neighbours;
  Cell(){
    state = false;
    neighbours=0;
  };
  
  
 
}
public void keyPressed()
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
    
         
   if(key == '`'){filming = !filming;}      
  
  
}

public void mousePressed()
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
class Grid
{
  Cell grid[][]= new Cell[100][100];;
  Grid()
  {
    
  }
  public void declare()
  {
    
     for(int i = 0 ; i < 100 ; i ++)
    {
    for(int j = 0 ;j < 100 ; j++)
    {
      grid[i][j].state = false;
      grid[i][j].neighbours = 0;
    }
  }
  }
  public void drawGrid()
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

public void updateNeighbours()
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

public void updateState()
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

public void simulate()
{
  updateNeighbours();
  updateState();
   updateNeighbours();
  
}

public void randomise()
{
  for(int i =0; i<100;i++)
  {
    for(int j = 0; j < 100 ; j++)
    {
      float r = random(1);
      if(r<0.5f)
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

public void clearGrid()
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
}
int red = 0xffFF0000 , white = 0xffFFFFFF , black = 0xff000000 , blue = 0xff0000ff , green = 0xff00ff00;
int frameCounter = 0;
int pictureCounter=0;
Boolean filming = false;
public void displayInstructions()
{
  fill(white);
  text("Mouse click to change the state of cells on the grid", 15,height-50);
  text("Press g,G - to start and stop continuous simulation" , 15,height-40);
  text("Press c,C - to clear the screen" , 15,height-10);
  text("Press space bar - for a single simulation step" ,15, height-30);
  text("Press r,R - to get a randomised grid" , 15,height-20);
}

public void header()
{
  fill(white);
  text("Author: Sanjana Gupta",10,10);
  text("CS 7492-Simulation of Biology - Assignment 1",width-250,10);
}

public void videoRecord()
{
  displayText = false; 
  saveFrame("FRAMES/F"+nf(frameCounter++,4)+".tif");
}

public void snapPicture() {displayText = false; saveFrame("PICTURES/P"+nf(pictureCounter++,3)+".jpg"); }
  public void settings() {  size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GameOfLife" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
