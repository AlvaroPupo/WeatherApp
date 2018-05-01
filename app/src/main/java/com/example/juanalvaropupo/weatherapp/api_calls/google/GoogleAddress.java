package com.example.juanalvaropupo.weatherapp.api_calls.google;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleAddress {

    @SerializedName("results")
    private List<Results> resultsList;

    public List<Results> getResultsList(){
        return resultsList;
    }
    public class Results {

        @SerializedName("formatted_address")
        private String AddressName;

        @SerializedName("geometry")
        private Geometry geometry;

        public String getAddressName() {
            return AddressName;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public class Geometry {

            @SerializedName("location")
            private GoogleLocation googleLocation;

            public GoogleLocation getGoogleLocation() {
                return googleLocation;
            }

            public class GoogleLocation{

                @SerializedName("lat")
                private double latitude;

                @SerializedName("lng")
                private double longitude;

                public double getLatitude() {
                    return latitude;
                }

                public double getLongitude() {
                    return longitude;
                }
            }
        }
    }
}
