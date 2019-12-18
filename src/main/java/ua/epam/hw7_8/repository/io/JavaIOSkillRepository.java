package ua.epam.hw7_8.repository.io;

import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.repository.SkillRepository;
import java.io.*;
import java.util.ArrayList;

public class JavaIOSkillRepository implements SkillRepository {
    private final String EXCEPTION_TEXT = "IOException";
    private final String ID_NOT_FOUND_TEXT = "Skill id not found";
    private final String name = "skill.txt";

    public Skill writeDataToFile(Skill data) {
        File file = new File(name);
        Long index;
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList, file);
            pw = new PrintWriter(file);
            if (arrayList.size() == 0) {
                pw.println("1 " + data.getSkill());
                data.setId(1L);
            } else {
                index = JavaIOCommonLogic.lastIndex(arrayList);
                for (int i = 0; i < arrayList.size(); i++) {
                    pw.println(arrayList.get(i));
                }
                pw.println(++index + " " + data.getSkill());
                data.setId(index);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        return data;
    }

    public ArrayList<Skill> readDataFromFile() {
        File file = new File(name);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<Skill> skillArrayList = new ArrayList<Skill>();
        try {
            JavaIOCommonLogic.read(arrayList, file);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        JavaIOCommonLogic.createListSkill(arrayList, skillArrayList);
        return skillArrayList;
    }

    public Skill readDataFromFileById(Long id) {
        File file = new File(name);
        ArrayList<String> arrayList = new ArrayList<String>();
        Skill skill = null;
        try {
            JavaIOCommonLogic.read(arrayList, file);
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
                    skill = JavaIOCommonLogic.createSkill(id.toString(), fileString[1]);
                }
            }
        }
        return skill;
    }

    public void editDataFromFile(Long id, Skill data) {
        File file = new File(name);
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList, file);
            if (arrayList.size() == 0) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else if (id > JavaIOCommonLogic.maxIndex(arrayList)) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else {
                pw = new PrintWriter(file);
                for (int i = 0; i < arrayList.size(); i++) {
                    String[] fileString = arrayList.get(i).split(" ");
                    int fileIndex = Integer.parseInt(fileString[0]);
                    if (fileIndex != id) {
                        pw.println(arrayList.get(i));
                    } else {
                        pw.println(id + " " + data.getSkill());
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
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList, file);
            if (arrayList.size() == 0) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else if (id > JavaIOCommonLogic.maxIndex(arrayList)) {
                System.out.println(ID_NOT_FOUND_TEXT);
            } else {
                pw = new PrintWriter(file);
                for (int i = 0; i < arrayList.size(); i++) {
                    String[] fileString = arrayList.get(i).split(" ");
                    int fileIndex = Integer.parseInt(fileString[0]);
                    if (fileIndex != id) {
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