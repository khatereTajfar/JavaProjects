/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package anti.pacman;

/**
 *
 * @author khatere
 */
public class Pacman {
    
    int NumberOfDots;
    int x, y;
    boolean superPower;

    public Pacman() {
        x=25;
        y=18;
    }
    
    void PacmanMove(Map map){
        int Random=(int)((Math.random()*10)%4)+1; 
        if(Random==1 && map.CheckUp(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            x=x-1;
            map.map[x][y]='@';
            
        }
        if(Random==2 && map.CheckRight(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            y=y+1;
            map.map[x][y]='@';
        }
        if(Random==3 && map.CheckDown(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            x=x+1;
            map.map[x][y]='@';
        }
        if(Random==4 && map.CheckLeft(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            y=y-1;
            map.map[x][y]='@';
        }
        
        if(Random==1 && map.DotCheckUp(x,y)==1 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            x=x-1;
            map.map[x][y]='@';
        }
        if(Random==2 && map.DotCheckRight(x, y)==1 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            y=y+1;
            map.map[x][y]='@';
        }
        if(Random==3 && map.DotCheckDown(x, y)==1 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            x=x+1;
            map.map[x][y]='@';
        }
        if(Random==4 && map.DotCheckLeft(x, y)==1 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            y=y-1;
            map.map[x][y]='@';
        }
        
        if(Random==1 && map.DotCheckLeft(x, y)==0 && map.DotCheckRight(x, y)==0 && map.CheckUp(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            x=x-1;
            map.map[x][y]='@';
        }
        if(Random==2 && map.DotCheckDown(x, y)==0 && map.DotCheckUp(x, y)==0 && map.CheckRight(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            y=y+1;
            map.map[x][y]='@';
        }
        if(Random==3 && map.DotCheckLeft(x, y)==0 && map.DotCheckRight(x, y)==0 && map.CheckDown(x, y)==0 && map.map[x+1][y]!='0' ){
            map.map[x][y]=' ';
            x=x+1;
            map.map[x][y]='@';
        }
        if(Random==4 && map.DotCheckDown(x, y)==0 && map.DotCheckUp(x, y)==0 && map.CheckLeft(x, y)==0 && map.map[x+1][y]!='0'){
            map.map[x][y]=' ';
            y=y-1;
            map.map[x][y]='@';
        }
        
        if(map.map[x+1][y]=='0'){
            map.map[x][y]=' ';
            y=y-1;
            map.map[x][y]='@';
        }
        
       
        
        System.out.println("Random=" +Random);
        
            
    }
}
