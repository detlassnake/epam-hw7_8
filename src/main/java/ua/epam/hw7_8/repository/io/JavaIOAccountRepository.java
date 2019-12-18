package ua.epam.hw7_8.repository.io;

import ua.epam.hw7_8.model.Account;
import ua.epam.hw7_8.repository.AccountRepository;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JavaIOAccountRepository implements AccountRepository {
    private final String EXCEPTION_TEXT = "IOException";
    private final String ID_NOT_FOUND_TEXT = "Account id not found";
    private final String name = "account.txt";

    public Account writeDataToFile(Account data) {
        File file = new File(name);
        Long index;
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList, file);
            pw = new PrintWriter(file);
            if (arrayList.size() == 0) {
                pw.println("1 " + data.getEmail() + " " + data.getAccountStatus().toString());
                data.setId(1L);
            } else {
                index = JavaIOCommonLogic.lastIndex(arrayList);
                for (int i = 0; i < arrayList.size(); i++) {
                    pw.println(arrayList.get(i));
                }
                pw.println(++index + " " + data.getEmail() + " " + data.getAccountStatus().toString());
                data.setId(index);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        return data;
    }

    public ArrayList<Account> readDataFromFile() {
        File file = new File(name);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<Account> accountArrayList = new ArrayList<Account>();
        try {
            JavaIOCommonLogic.read(arrayList, file);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        JavaIOCommonLogic.createListAccount(arrayList,accountArrayList);
        return accountArrayList;
    }

    public Account readDataFromFileById(Long id) {
        File file = new File(name);
        int index = id.intValue();
        ArrayList<String> arrayList = new ArrayList<String>();
        Account account = null;
        try {
            JavaIOCommonLogic.read(arrayList, file);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TEXT);
        }
        if (arrayList.size() == 0) {
            System.out.println(ID_NOT_FOUND_TEXT);
        } else if (index > JavaIOCommonLogic.maxIndex(arrayList)) {
            System.out.println(ID_NOT_FOUND_TEXT);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                String[] fileString = arrayList.get(i).split(" ");
                int fileIndex = Integer.parseInt(fileString[0]);
                if (fileIndex == index) {
                    account = JavaIOCommonLogic.createAccount(id.toString(), fileString[1], fileString[2]);
                }
            }
        }
        return account;
    }

    public void editDataFromFile(Long id, Account data) {
        File file = new File(name);
        int index = id.intValue();
        ArrayList<String> arrayList = new ArrayList<String>();
        PrintWriter pw;
        try {
            JavaIOCommonLogic.read(arrayList, file);
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
                        pw.println(index + " " + data.getEmail() + " " + data.getAccountStatus());
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
            JavaIOCommonLogic.read(arrayList, file);
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