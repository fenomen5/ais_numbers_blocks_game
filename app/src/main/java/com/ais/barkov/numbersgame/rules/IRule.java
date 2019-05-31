package com.ais.barkov.numbersgame.rules;

import com.ais.barkov.numbersgame.elements.Element;

public interface IRule {

    public Element applyRule(Element[] elements) throws NoSuchMethodException;
    public String getRuleText();
}
