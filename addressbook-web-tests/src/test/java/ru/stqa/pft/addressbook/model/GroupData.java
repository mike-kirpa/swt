package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {

    private int id;
    private final String groupName;
    private final String headerName;
    private final String footerName;

    public GroupData(int id, String groupName, String headerName, String footerName) {
        this.id = id;
        this.groupName = groupName;
        this.headerName = headerName;
        this.footerName = footerName;
    }

    public GroupData(String groupName, String headerName, String footerName) {
        this.id = 0;
        this.groupName = groupName;
        this.headerName = headerName;
        this.footerName = footerName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getFooterName() { return footerName; }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(id, groupData.id) &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, groupName);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }


}
