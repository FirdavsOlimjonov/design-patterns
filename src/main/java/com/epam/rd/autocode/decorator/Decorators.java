package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.List;

public class Decorators {
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        List<String> arrayList = new ArrayList<>();

        for (int i = 0; i < sourceList.size();i++) {
            if (i%2==0)
                arrayList.add(sourceList.get(i));
        }
        return arrayList;
    }


}

