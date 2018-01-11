package br.com.jmsstudio.designpatterns.bridge;

public class MapLinkRegionMapBridge implements RegionMap {

    private final String MAPLINK_API_KEY = "";

    @Override
    public String getMap(String address) throws Exception {
        throw new UnsupportedOperationException("Not implemented");
    }
}
