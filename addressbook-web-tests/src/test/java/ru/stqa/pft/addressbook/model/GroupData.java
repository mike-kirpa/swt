package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private final String groupName;
    private final String headerName;
    private final String footerName;

    public GroupData(String groupName, String headerName, String footerName) {
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

    public String getFooterName() {
        return footerName;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupName);
    }
}
