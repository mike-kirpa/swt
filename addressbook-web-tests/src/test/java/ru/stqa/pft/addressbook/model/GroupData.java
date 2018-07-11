package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="group_list")
public class GroupData implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName) &&
                Objects.equals(headerName, groupData.headerName) &&
                Objects.equals(footerName, groupData.footerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, groupName, headerName, footerName);
    }

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

    public Set<ContactData> getContacts() {
        return contacts;
    }

    @ManyToMany(mappedBy = "groups")
    private Set<ContactData> contacts = new HashSet<ContactData>();


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
