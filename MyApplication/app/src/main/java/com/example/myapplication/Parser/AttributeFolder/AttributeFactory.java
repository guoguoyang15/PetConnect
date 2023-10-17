package com.example.myapplication.Parser.AttributeFolder;

import com.example.myapplication.Interface.IAttribute;
import com.example.myapplication.Parser.Attribute;
import com.example.myapplication.tool.AttributeTypeEnum;

/**
 * @author 13521
 * @date 15/10/2023
 */
public class AttributeFactory {
    public IAttribute getAttribute(Attribute attribute) {
        if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.id.toString())) {
            return new idAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.name.toString())) {
            return new nameAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.type.toString())) {
            return new typeAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.money.toString())) {
            return new moneyAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.bodytype.toString())) {
            return new bodyTypeAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.color.toString())) {
            return new colorAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equalsIgnoreCase(AttributeTypeEnum.comment.toString())) {
            return new commentAttribute(attribute.getValue(), attribute.getRelation());
        }
        return null;
    }
}
