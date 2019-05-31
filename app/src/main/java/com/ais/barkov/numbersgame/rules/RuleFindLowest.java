package com.ais.barkov.numbersgame.rules;

import com.ais.barkov.numbersgame.elements.Element;

public class RuleFindLowest extends Rule
{

    public RuleFindLowest() {
        this.setRuleText("Choose the LOWEST block value");
        this.setRuleType(Rule.FIND_LOWEST_RULE_TYPE);
    }

    @Override
    public Element applyRule(Element[] elements) {

        Element lowest = null;
        for (Element element: elements) {
            if (lowest == null || (int)lowest.getValue() > (int)element.getValue()) {
                lowest = element;
            }
        }
        return lowest;
    }
}
