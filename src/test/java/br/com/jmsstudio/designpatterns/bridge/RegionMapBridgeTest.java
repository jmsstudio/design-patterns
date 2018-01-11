package br.com.jmsstudio.designpatterns.bridge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegionMapBridgeTest {

    @Test
    public void shouldProcessMapRequestToGoogle() throws Exception {
        RegionMap map = new GoogleRegionMapBridge();

        assertEquals("{\n" +
                "   \"error_message\" : \"This service requires an API key.\",\n" +
                "   \"html_attributions\" : [],\n" +
                "   \"results\" : [],\n" +
                "   \"status\" : \"REQUEST_DENIED\"\n" +
                "}", map.getMap("test"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldProcessMapRequestToMaplink() throws Exception {
        RegionMap map = new MapLinkRegionMapBridge();

        map.getMap("test");
    }
}
