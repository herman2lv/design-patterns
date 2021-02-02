package com.epam.rd.autocode.factory.plot;

public class ContemporaryDisneyPlot implements Plot {
    private static final String HERO_STORY = "%s feels a bit awkward and uncomfortable.";
    private static final String EPIC_CRISIS_STORY =
            "But personal issues fades, when a big trouble comes - %s.";
    private static final String MAIN_STORY =
            "%s stands up against it, but with no success at first."
            + "But putting self together and help of friends, "
            + "including spectacular funny %s restore the spirit "
            + "and %s overcomes the crisis and gains gratitude and respect";
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    public ContemporaryDisneyPlot(final Character hero, final EpicCrisis epicCrisis,
                                  final Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public String toString() {
        String heroStory = String.format(HERO_STORY, hero.name());
        String epicCrisisStory = String.format(EPIC_CRISIS_STORY, epicCrisis.name());
        String mainStory = String.format(MAIN_STORY, hero.name(), funnyFriend.name(), hero.name());
        return heroStory + " " + epicCrisisStory + " " + mainStory;
    }
}
