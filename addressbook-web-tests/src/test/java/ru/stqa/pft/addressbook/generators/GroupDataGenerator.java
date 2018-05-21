package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
    //принимаем парамтеры из командной строки, первый - количество групп, второй - путь к файлу. Генерируем данные и записываем их в файл
public class GroupDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData> groups = generateGroups(count);
        save(groups, file);

    }

    //Записываем в файл, по переданному пути, список сгенерированных данных
    private static void save(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for(GroupData group: groups){
            writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getHeaderName(), group.getFooterName()));
        }
        writer.close();
    }

    //Генерируем переданное количество элементов группы.
    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for(int i = 0; i < count; i++){
            groups.add(new GroupData().withGroupName(String.format("test %s", i)).withHeaderName(String.format("header %s", i)).withFooterName(String.format("footer %s", i)));
        }
        return groups;
    }
}
