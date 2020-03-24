package com.base.network;

import com.base.network.model.SectionType;

public class MainEnum {
    public static void main(String[] args) {
        for(SectionType type: SectionType.values()){
            System.out.println(type.getTitle());
        }
    }
}
