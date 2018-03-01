package ru.stqa.pft.addressbook.model;

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
}
