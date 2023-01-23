package cn.edu.guet.waste_recycling.bean;

import java.util.List;
import java.util.Objects;

/**
 * @author HHS
 */
public class Area extends BaseModel {
    private String name;
    private long parentId;
    private List<Area> children;
    private double longitude;
    private double latitude;

    public Area() {
    }

    public Area(String name, long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<Area> getChildren() {
        return children;
    }

    public void setChildren(List<Area> children) {
        this.children = children;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return parentId == area.parentId && Double.compare(area.longitude, longitude) == 0 && Double.compare(area.latitude, latitude) == 0 && Objects.equals(name, area.name) && Objects.equals(children, area.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentId, children, longitude, latitude);
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
