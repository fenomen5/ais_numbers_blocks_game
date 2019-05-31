package com.ais.barkov.numbersgame.rules;

import com.ais.barkov.numbersgame.elements.Element;

public class Rule implements IRule{

    public static final int FIND_LOWEST_RULE_TYPE = 5;
    public static final int FIND_BIGGEST_RULE_TYPE = 6;

    private String ruleText;
    private Integer ruleType;

    public Rule() {}

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public Element applyRule(Element[] elements) throws NoSuchMethodException {
       throw new NoSuchMethodException("Method not implemented");
    };

}
