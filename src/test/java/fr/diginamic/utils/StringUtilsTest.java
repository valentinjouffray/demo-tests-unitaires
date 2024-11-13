package fr.diginamic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilsTest {

    @Test
    public void levenshteinDistance() {
        int distanceChat = StringUtils.levenshteinDistance("chat", "chats");
        int distanceMachin = StringUtils.levenshteinDistance("machins", "machine");
        int distanceAvion = StringUtils.levenshteinDistance("avion", "aviron");
        int distanceInstance = StringUtils.levenshteinDistance("distance", "instance");
        int distanceChien = StringUtils.levenshteinDistance("chien", "chine");

        assertEquals(1, distanceChat);
        assertEquals(1, distanceMachin);
        assertEquals(1, distanceAvion);
        assertEquals(2, distanceInstance);
        assertEquals(2, distanceChien);

        assertThrows(NullPointerException.class, () -> StringUtils.levenshteinDistance(null, "test"));
    }
}