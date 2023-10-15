package com.example.myapplication.Parser.AttributeFolder;

import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Parser.Attribute;

/**
 * @author 13521
 * @date 15/10/2023
 */
public class AttributeFactory {
    public IAttribute getAttribute(Attribute attribute) {
        if (attribute.getType().equals("id")) {
            return new idAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals("name")) {
            return new nameAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals("type")) {
            return new typeAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals("money")) {
            return new moneyAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals("bodytype")) {
            return new bodyTypeAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals("color")) {
            return new colorAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals("comment")) {
            return new commentAttribute(attribute.getValue(), attribute.getRelation());
        }
        return null;
    }
}
