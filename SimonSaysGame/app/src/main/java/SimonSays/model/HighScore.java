package model;

public class HighScore 
{   
    public int score;
    public String name;
    
    public HighScore(String name, int score){
       this.name=name;
       this.score=score;
    }
       
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        System.out.println("Setting name");
        this.name = name;
        
    }
    
    public void setScore(int score)
    {
        this.score = score; 
    }
    
    public int getScore()
    {
        return this.score;
    }
    public HighScore getHighScore()
    {
        return this;
    }
    
}

