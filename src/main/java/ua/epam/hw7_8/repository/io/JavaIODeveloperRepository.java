package ua.epam.hw7_8.repository.io;

import ua.epam.hw7_8.model.Developer;
import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.repository.DeveloperRepository;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JavaIODeveloperRepository implements DeveloperRepository {
    private final String EXCEPTION_TEXT = "IOException";
    private final String ID_NOT_FOUND_TEXT = "Developer id not found";
    private final String name = "developer.txt";

    public Developer writeDataToFile(Developer data) {
        File file = new File(name);
        Long index;
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList, file);
            pw = new PrintWriter(file);
            if (arrayList.size() == 0) {
                ArrayList<Skill> skillArrayList = new ArrayList<Skill>(data.getDevSkills());
                Long skillIndex = skillArrayList.get(0).getId();
                Long accountIndex = data.getDevAccount().getId();
                pw.println("1 " + data.getName() + " " + accountIndex + " " + skillIndex);            } else {
                index = JavaIOCommonLogic.lastIndex(arrayList);
                for (int i = 0; i < arrayList.size(); i++) {
                    pw.println(arrayList.get(i));
                }
                ArrayList<Skill> skillArrayList = new ArrayList<Skill>(data.getDevSkills());
                Long skillIndex = skillArrayList.get(0).getId();
                Long accountIndex = data.getDevAccount().getId();
                pw.println(++index + " " + data.getName() + " " + accountIndex + " " + skillIndex);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        return data;
    }

    public ArrayList<Developer> readDataFromFile() {
        File file = new File(name);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<Developer> developerArrayList = new ArrayList<Developer>();
        try {
            JavaIOCommonLogic.read(arrayList, file);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        JavaIOCommonLogic.createListDeveloper(arrayList, developerArrayList);
        return developerArrayList;
    }

    public Developer readDataFromFileById(Long id) {
        File file = new File(name);
        ArrayList<String> arrayList = new ArrayList<String>();
        Developer developer = null;
        try {
            JavaIOCommonLogic.read(arrayList,file);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        if (arrayList.size() == 0) {
            System.out.println(ID_NOT_FOUND_TEXT);
        } else if (id > JavaIOCommonLogic.maxIndex(arrayList)) {
            System.out.println(ID_NOT_FOUND_TEXT);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                String[] fileString = arrayList.get(i).split(" ");
                int fileIndex = Integer.parseInt(fileString[0]);
                if (fileIndex == id) {
                    developer = JavaIOCommonLogic.createDeveloper(fileString[0],fileString[1],fileString[2],fileString[3]);
                }
            }
        }
        return developer;
    }

    public void editDataFromFile(Long id, Developer data) {
        File file = new File(name);
        int index = id.intValue();
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList,file);
            if (arrayList.size() == 0) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else if (index > JavaIOCommonLogic.maxIndex(arrayList)) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else {
                pw = new PrintWriter(file);
                for (int i = 0; i < arrayList.size(); i++) {
                    String[] fileString = arrayList.get(i).split(" ");
                    int fileIndex = Integer.parseInt(fileString[0]);
                    if (fileIndex != index) {
                        pw.println(arrayList.get(i));
                    } else {
                        JavaIOCommonLogic.editDeveloper(fileString[0], fileString[2], fileString[3], data);
                        pw.println(index + " " + data.getName() + " " + fileString[2] + " " + fileString[3]);
                    }
                }
                pw.close();
            }
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
    }

    public void deleteDataFromFile(Long id) {
        File file = new File(name);
        int index = id.intValue();
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList,file);
            if (arrayList.size() == 0) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else if (index > JavaIOCommonLogic.maxIndex(arrayList)) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else {
                pw = new PrintWriter(file);
                for (int i = 0; i < arrayList.size(); i++) {
                    String[] fileString = arrayList.get(i).split(" ");
                    int fileIndex = Integer.parseInt(fileString[0]);
                    if (fileIndex != index) {
                        pw.println(arrayList.get(i));
                    }
                }
                pw.close();
            }
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
    }
}