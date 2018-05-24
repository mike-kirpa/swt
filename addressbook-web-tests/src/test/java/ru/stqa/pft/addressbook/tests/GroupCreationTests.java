package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase{

    //создаем фабрику данных - заполняем список массивов, возвращаем итератор на первый элемент списка.
    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withGroupName("test1").withHeaderName("header 1").withFooterName("footer 1")});
        list.add(new Object[] {new GroupData().withGroupName("test2").withHeaderName("header 2").withFooterName("footer 2")});
        list.add(new Object[] {new GroupData().withGroupName("test3").withHeaderName("header 3").withFooterName("footer 3")});
        return list.iterator();
    }

    //из фабрики массивов забираем элементы списка по итератору, передаем объкет GroupData
    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group){
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation(){

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withGroupName("test2'");
        app.group().create(group);
        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();

        assertThat(after, equalTo(before));
    }
}
