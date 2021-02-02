package com.epam.rd.autocode.factory.plot;

public class ClassicDisneyPlot implements Plot {
    private static final String HERO_ARC = "%s is great.";
    private static final String LOVE_STORY = "%s and %s love each other.";
    private static final String VILLAIN_ARC =
            "%s interferes with their happiness but loses in the end.";
    private final Character hero;
    private final Character beloved;
    private final Character villain;

    public ClassicDisneyPlot(final Character hero, final Character beloved,
                             final Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public String toString() {
        String heroStory = String.format(HERO_ARC, hero.name());
        String loveStory = String.format(LOVE_STORY, hero.name(), beloved.name());
        String villainStory = String.format(VILLAIN_ARC, villain.name());
        return heroStory + " " + loveStory + " " + villainStory;
    }
}
