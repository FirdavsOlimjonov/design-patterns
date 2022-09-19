package com.epam.rd.autocode.factory.plot;

import java.util.StringJoiner;

class PlotFactories implements PlotFactory, Plot{

    private String result;

    public PlotFactories() {
    }

    public PlotFactories(String result) {
        this.result = result;
    }

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        String classicStr = String.format("%s is great. %s and %s love each other. %s interferes with their happiness but loses in the end.",
                hero.name(),hero.name(),beloved.name(),villain.name());
        return new PlotFactories(classicStr);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        String format = String.format("%s feels a bit awkward and uncomfortable. But personal issues fades, when a big trouble comes - %s. %s stands up against it, but with no success at first.But putting self together and help of friends, including spectacular funny %s restore the spirit and %s overcomes the crisis and gains gratitude and respect",
                hero.name(),epicCrisis.name(),hero.name(),funnyFriend.name(),hero.name());
        return new PlotFactories(format);
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {

        StringJoiner stringJoiner = new StringJoiner(", brave ", "brave ", " ");

        for (Character hero : heroes) {
            stringJoiner.add(hero.name());
        }

        String format = String.format("%s threatens the world. But %son guard. So, no way that intrigues of %s overcome the willpower of inflexible heroes",
        epicCrisis.name(),stringJoiner.toString(),villain.name());
        return new PlotFactories(format);
    }


    @Override
    public Plot plot() {
        return this;
    }

    @Override
    public String toString() {
        return result;
    }
}
