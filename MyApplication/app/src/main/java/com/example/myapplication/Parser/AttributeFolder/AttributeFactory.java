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
        if (attribute.getType().equals(AttributeTypeEnum.id.toString())) {
            return new idAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals(AttributeTypeEnum.name.toString())) {
            return new nameAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals(AttributeTypeEnum.type.toString())) {
            return new typeAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals(AttributeTypeEnum.money.toString())) {
            return new moneyAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals(AttributeTypeEnum.bodyType.toString())) {
            return new bodyTypeAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals(AttributeTypeEnum.color.toString())) {
            return new colorAttribute(attribute.getValue(), attribute.getRelation());
        } else if (attribute.getType().equals(AttributeTypeEnum.comment.toString())) {
            return new commentAttribute(attribute.getValue(), attribute.getRelation());
        }
        return null;
    }
}
