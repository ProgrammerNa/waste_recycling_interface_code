package cn.edu.guet.waste_recycling.bean;

/**
 * @author HHS
 */
public class Area extends BaseModel {
    private String name;
    private int type;
    private long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
