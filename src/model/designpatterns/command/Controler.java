package model.designpatterns.command;

import java.util.ArrayList;

public class Controler
{
    private Command[] c = new Command[10];
    private ArrayList<Command> log = new ArrayList<Command>();
    
    public void setCommand(Command c, int key){
        this.c[key] = c;
    }
    
    public void keyPressed(int key){
        this.c[key].execute();
        log.add(c[key]);
    }
    
    public void executa(Command c){
        c.execute();
        log.add(c);
        
    }    
    
    public void showLog(){
    	int order = 0;
        for (Command c : log){
            System.out.println(order +" command executed: " + c.toString());
        	order++;
        }
    }

    public ArrayList<String> getLog(){
        int order = 0;
        ArrayList<String> output = new ArrayList<String>();
        for(Command c : log)
        {
            output.add(String.format("%d - comando executado: " + c.toString()));
            order++;
        }

        return output;
    }
    
    public void replay(){
        for (Command c : log)
            c.execute();
    }    
    
    
}
