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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return parentId == area.parentId && Objects.equals(name, area.name) && Objects.equals(children, area.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentId, children);
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}
