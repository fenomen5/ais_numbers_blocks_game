package com.ais.barkov.numbersgame.rules;

import com.ais.barkov.numbersgame.rules.Rule;
import com.ais.barkov.numbersgame.elements.Element;

public class RuleFindBiggest extends Rule
{

    public RuleFindBiggest() {
        this.setRuleText("Choose the BIGGEST block value");
        this.setRuleType(Rule.FIND_BIGGEST_RULE_TYPE);
    }

    @Override
    public Element applyRule(Element[] elements) {

        Element biggest = null;
        for (Element element: elements) {
            if (biggest == null || (int)biggest.getValue() < (int)element.getValue()) {
                biggest = element;
            }
        }
        return biggest;
    }
}
