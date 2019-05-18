package ru.isdev.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIP() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("217.112.35.95");
        assertEquals(ipLocation, "<GeoIP><Country>GB</Country><State>CA</State></GeoIP>");
    }

    @Test
    public void testInvalidIP() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("127.0.0.1");
        assertEquals(ipLocation, "<GeoIP><Country>GB</Country><State>CA</State></GeoIP>");
    }

}

