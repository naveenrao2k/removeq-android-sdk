package com.removeq.sdk;

public class RemoveQ {
    private static final String BASE_URL = "https://cdn.removeq.com/";

    public static RemoveQ getInstance(Config config) {
        return new RemoveQ(config);
    }

    private final Config config;
    private String url;
    private Integer width;
    private Integer height;
    private Integer quality;

    private RemoveQ(Config config) {
        this.config = config;
    }

    public RemoveQ url(String url) {
        this.url = UrlManipulator.removeDomain(url);
        return this;
    }

    public RemoveQ width(Integer width) {
        this.width = width;
        return this;
    }

    public RemoveQ height(Integer height) {
        this.height = height;
        return this;
    }

    public RemoveQ quality(Integer quality) {
        this.quality = quality;
        return this;
    }

    public String create() {
        String containerId = config.getContainerId();
        String transformedUrl = BASE_URL + containerId + "/" + url;

        // Append query parameters if not null
        transformedUrl = appendQueryParam(transformedUrl, "width", width);
        transformedUrl = appendQueryParam(transformedUrl, "height", height);
        transformedUrl = appendQueryParam(transformedUrl, "quality", quality);

        return transformedUrl;
    }

    private String appendQueryParam(String url, String paramName, Integer paramValue) {
        if (paramValue != null) {
            return url + (url.contains("?") ? "&" : "?") + paramName + "=" + paramValue;
        }
        return url;
    }
}
