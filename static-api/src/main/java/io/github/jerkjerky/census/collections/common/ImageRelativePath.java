package io.github.jerkjerky.census.collections.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ImageRelativePath {

    private final String path;

    @JsonCreator
    public ImageRelativePath(@JsonProperty("image_path") String path) {
        this.path = path;
    }
}
