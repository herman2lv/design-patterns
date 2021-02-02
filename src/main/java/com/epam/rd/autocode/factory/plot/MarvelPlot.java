package com.epam.rd.autocode.factory.plot;

import java.util.StringJoiner;

public class MarvelPlot implements Plot {
    private static final String EPIC_CRISIS_STORY = "%s threatens the world.";
    private static final String VILLAIN_STORY =
            "So, no way that intrigues of %s overcome the willpower of inflexible heroes";
    private static final String HEROES_STORY = "But %s on guard.";
    private static final String HERO_DECLARATION = "brave %s";
    private static final String DELIMITER = ", ";
    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlot(final Character[] heroes, final EpicCrisis epicCrisis,
                      final Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        String epicCrisisStory = String.format(EPIC_CRISIS_STORY, epicCrisis.name());
        StringJoiner heroesList = new StringJoiner(DELIMITER);
        for (Character hero : heroes) {
            heroesList.add(String.format(HERO_DECLARATION, hero.name()));
        }
        String heroesStory = String.format(HEROES_STORY, heroesList.toString());
        String villainStory = String.format(VILLAIN_STORY, villain.name());
        return epicCrisisStory + " " + heroesStory + " " + villainStory;
    }
}
