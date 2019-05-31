package com.ais.barkov.numbersgame.rules;

import android.util.Log;
import android.widget.Toast;

import com.ais.barkov.numbersgame.elements.Element;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Random;

public class RulesFactory {

    public static final int FIND_LOWEST_RULE_TYPE = 5;
    public static final int FIND_BIGGEST_RULE_TYPE = 6;

    private String[] ruleClasses = {RuleFindBiggest.class.getName(), RuleFindLowest.class.getName()};


    public Object getRandomRule() throws ClassNotFoundException {

        Random generator  = new Random();
        int index = generator.nextInt(this.ruleClasses.length);
        Class ruleClass;
        Object rule;
        try {
          ruleClass = Class.forName(ruleClasses[index]);
          rule = ruleClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ClassNotFoundException("class" + ruleClasses[index] + "not found");
        }
        return rule;
    }
}
