package com.carpour.nameverif.APIs;

public class FloodGateUtils {

    public static boolean getFloodGateAPI() {

        try {

            Class.forName("org.geysermc.floodgate.api.FloodgateApi");

        }catch (Exception ignored){

            return false;

        }

        return true;
    }
}