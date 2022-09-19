package com.epam.rd.autocode.startegy.cards;

class CardImpl1 implements Card {

    private String name;

    CardImpl1(final String name) {
        this.name = name;
    }

    CardImpl1(final int name) {
        this(Integer.toString(name));
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
