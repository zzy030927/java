package Program.bookManager.model;

public class BookType {
    private Integer typeId;     // 唯一的标识
    private String typeName;    // 类别名称
    private String remark;      // 类别描述信息

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
