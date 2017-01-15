color red = #FF0000 , white = #FFFFFF , black = #000000 , blue = #0000ff , green = #00ff00;

void displayInstructions()
{
  fill(white);
  text("Mouse click to change the state of cells on the grid", 15,height-50);
  text("Press g,G - to start and stop continuous simulation" , 15,height-40);
  text("Press c,C - to clear the screen" , 15,height-10);
  text("Press space bar - for a single simulation step" ,15, height-30);
  text("Press r,R - to get a randomised grid" , 15,height-20);
}

void header()
{
  fill(white);
  text("Author: Sanjana Gupta",10,10);
  text("CS 7492-Simulation of Biology - Assignment 1",width-250,10);
}