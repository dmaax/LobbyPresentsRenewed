package com.poompk.lobbypresentsrenewed.versions;

public class SupportedVersions {

    public static Presents getVersion(String version) {
        switch (version) {
            case "v1_8_R1":
                return new v1_8_R1();
            case "v1_8_R2":
                return new v1_8_R2();
            case "v1_8_R3":
                return new v1_8_R3();
            case "v1_9_R1":
                return new v1_9_R1();
            case "v1_9_R2":
                return new v1_9_R2();
            case "v1_10_R1":
                return new v1_10_R1();
            case "v1_11_R1":
                return new v1_11_R1();
            case "v1_12_R1":
                return new v1_12_R1();
            case "v1_13_R1":
                return new v1_13_R1();
            case "v1_13_R2":
                return new v1_13_R2();
            case "v1_14_R1":
                return new v1_14_R1();
            case "v1_15_R1":
                return new v1_15_R1();
            case "v1_16_R1":
                return new v1_16_R1();
            case "v1_16_R2":
                return new v1_16_R2();
            case "v1_16_R3":
                return new v1_16_R3();
            default:
                return null;
        }
    }

}
