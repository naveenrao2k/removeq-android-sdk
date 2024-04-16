package com.removeq.sdk;

public class Config {
    private final String containerId;

    public Config(String containerId) {
        this.containerId = "@" + containerId;
    }

    public String getContainerId() {
        return containerId;
    }
}
