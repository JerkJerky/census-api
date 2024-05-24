package com.github.jerkjerky.census.collections.experience;

import com.github.jerkjerky.census.collections.client.ExperienceClient;
import com.github.jerkjerky.census.collections.client.StaticContentClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExperienceClientTests {

    private static final String SERVICE_ID = System.getenv("CENSUS_API_KEY");

    private final StaticContentClient staticContentClient = new StaticContentClient(SERVICE_ID);


    @Test
    void fetchKillPlayerExperienceType() {
        ExperienceClient experienceClient = staticContentClient.getExperienceClient();

        Experience experience = Assertions.assertDoesNotThrow(() -> experienceClient.fetchExperienceById(1L));

        Assertions.assertNotNull(experience);
    }

    @Test
    void fetchKillAwardType() {
        ExperienceClient experienceClient = staticContentClient.getExperienceClient();

        ExperienceAwardType experienceAwardType = Assertions.assertDoesNotThrow(() -> experienceClient.fetchExperienceAwardTypeById(1L));

        Assertions.assertNotNull(experienceAwardType);
    }


}
