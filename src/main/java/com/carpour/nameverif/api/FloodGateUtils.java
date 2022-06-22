package com.carpour.nameverif.api;

public class FloodGateUtils {

    private FloodGateUtils() {}

    public static boolean getFloodGateAPI() {

        try {

            Class.forName("org.geysermc.floodgate.api.FloodgateApi");

        } catch (Exception ignored) {

            return false;

        }

        return true;
    }
}