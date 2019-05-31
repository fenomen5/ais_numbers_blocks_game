package com.ais.barkov.numbersgame.elements;

public interface Element<T> {

    public T getValue();
    public void setElementId(String elementId);
    public String getElementId();
}

