package io.github.jerkjerky.census.collections;

import io.github.jerkjerky.census.collections.client.StaticContentClient;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite // Census is so unstable that tests are more for development purposes only :/
@SuiteDisplayName("Static census API test suite")
@SelectPackages("io.github.jerkjerky.census.collections")
public class TestSuite {
    public static StaticContentClient CLIENT = new StaticContentClient(System.getenv("CENSUS_API_KEY"));
}
