package com.boun.swe.mnemosyne.model;

import java.util.List;

public class Area
{
    private List<Point> points;

    Area(List<Point> points)
    {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Point point : points) {
            sb.append("Longitude= " + point.getLongitude() + " latitude= " + point.getLatitude() + "\n");
        }
        return sb.toString();
    }
}

class Point
{
    Point(double longitude, double latitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private double latitude;

    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
