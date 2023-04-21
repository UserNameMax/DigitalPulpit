package model;

public class Developer {
    public String name;
    public int rate;
    public Developer(String name, int rate){
        this.name = name;
        this.rate = rate;
    }
    @Override
    public boolean equals(Object obj){
        Developer other = (Developer) obj;
        return rate == other.rate;
    }
}
