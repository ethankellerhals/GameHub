package com.gamehub.myapplication;

//https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm

public interface IteratorPattern {
    public boolean validNext();
    public Object next();
    public void removeGame(games G);
    public void removeUser(users U);
}
