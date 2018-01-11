package br.com.jmsstudio.designpatterns.bridge;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class GoogleRegionMapBridge implements RegionMap {

    private final String GOOGLE_API_KEY = "";

    @Override
    public String getMap(String address) throws Exception {
        URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + address
                + "&key=" + GOOGLE_API_KEY);

        InputStream inputStream = url.openStream();

        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        return result;
    }
}
