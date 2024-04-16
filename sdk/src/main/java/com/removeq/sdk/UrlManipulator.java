package com.removeq.sdk;

import android.net.Uri;
public class UrlManipulator {
    public static String removeDomain(String urlString) {
        Uri uri = Uri.parse(urlString);
        String path = uri.getPath();
        if (path != null && !path.isEmpty()) {
            // Remove leading "/"
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            return path;
        }
        return null;
    }
}
