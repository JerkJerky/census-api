package com.github.jerkjerky.census.collections.experience;

import com.github.jerkjerky.census.collections.client.ExperienceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.jerkjerky.census.collections.TestSuite.CLIENT;

class ExperienceClientTests {


    @Test
    void fetchKillPlayerExperienceType() {
        ExperienceClient experienceClient = CLIENT.getExperienceClient();

        Experience experience = Assertions.assertDoesNotThrow(() -> experienceClient.fetchExperienceById(1L));

        Assertions.assertNotNull(experience);
    }

    @Test
    void fetchKillAwardType() {
        ExperienceClient experienceClient = CLIENT.getExperienceClient();

        ExperienceAwardType experienceAwardType = Assertions.assertDoesNotThrow(() -> experienceClient.fetchExperienceAwardTypeById(1L));

        Assertions.assertNotNull(experienceAwardType);
    }


}
