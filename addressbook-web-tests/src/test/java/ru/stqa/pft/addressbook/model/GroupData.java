package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="group_list")
public class GroupData implements Serializable {
    @XStreamOmitField
    //анотации для Hibernate
    @Id
    @Column(name = "group_id")
    private int id;
    @Expose
    @Id
    @Column(name = "group_name")
    private String groupName;
    @Expose
    @Id
    @Column(name = "group_header")
    @Type(type = "text")
    private String headerName;
    @Expose
    @Id
    @Column(name = "group_footer")
    @Type(type = "text")
    private String footerName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, groupName);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getFooterName() { return footerName; }

    public int getId() { return id; }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeaderName(String headerName) {
        this.headerName = headerName;
        return this;
    }

    public GroupData withFooterName(String footerName) {
        this.footerName = footerName;
        return this;
    }


}
