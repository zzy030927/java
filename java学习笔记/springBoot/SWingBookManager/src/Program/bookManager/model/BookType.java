package Program.bookManager.model;

public class BookType {
    private Integer typeId;     // Ψһ�ı�ʶ
    private String typeName;    // �������
    private String remark;      // ���������Ϣ

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
