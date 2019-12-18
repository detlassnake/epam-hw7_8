package ua.epam.hw7_8.repository.io;

import ua.epam.hw7_8.model.Account;
import ua.epam.hw7_8.model.AccountStatus;
import ua.epam.hw7_8.model.Developer;
import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.view.AccountView;
import ua.epam.hw7_8.view.DeveloperView;
import ua.epam.hw7_8.view.SkillView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaIOCommonLogic {
    public static void read(ArrayList<String> arrayList, File f) throws IOException {
        Scanner in = new Scanner(f);
        while (in.hasNextLine()) {
            arrayList.add(in.nextLine());
        }
        in.close();
    }

    public static int maxIndex(ArrayList<String> arrayList) {
        int maxIndex = -10000;
        String[] str;
        int index;
        for (int i = 0; i < arrayList.size(); i++) {
            str = arrayList.get(i).split(" ");
            index = Integer.parseInt(str[0]);
            if (maxIndex <= index) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    public static Long lastIndex(ArrayList<String> arrayList) {
        String[] lastStr;
        Long lastIndex;
        lastStr = arrayList.get(arrayList.size() - 1).split(" ");
        lastIndex = Long.parseLong(lastStr[0]);
        return lastIndex;
    }

    public static Account createAccount(String id, String accountStr, String AccountStatusStr) {
        Account account = new Account();
        account.setId(Long.parseLong(id));
        account.setEmail(accountStr);
        account.setAccountStatus(accountStatusCheck(AccountStatusStr));
        return account;
    }

    public static Developer createDeveloper(String id, String name, String idAccount, String idSkill) {
        JavaIOAccountRepository accountRepository = new JavaIOAccountRepository();
        JavaIOSkillRepository skillRepository = new JavaIOSkillRepository();
        Developer developer = new Developer();
        developer.setId(Long.parseLong(id));
        developer.setName(name);
        developer.setDevSkills(skillRepository.readDataFromFileById(Long.parseLong(idSkill)));
        developer.setDevAccount(accountRepository.readDataFromFileById(Long.parseLong(idAccount)));
        return developer;
    }

    public static Skill createSkill(String id, String skillStr) {
        Skill skill = new Skill();
        skill.setId(Long.parseLong(id));
        skill.setSkill(skillStr);
        return skill;
    }

    public static void createListAccount(ArrayList<String> arrayList, ArrayList<Account> accountArrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String[] fileString = arrayList.get(i).split(" ");
            Account account = createAccount(fileString[0], fileString[1], fileString[2]);
            accountArrayList.add(account);
        }
    }

    public static void createListDeveloper(ArrayList<String> arrayList, ArrayList<Developer> developerArrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String[] fileString = arrayList.get(i).split(" ");
            Developer developer = createDeveloper(fileString[0], fileString[1], fileString[2], fileString[3]);
            developerArrayList.add(developer);
        }
    }

    public static void createListSkill(ArrayList<String> arrayList, ArrayList<Skill> skillArrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String[] fileString = arrayList.get(i).split(" ");
            Skill skill = createSkill(fileString[0], fileString[1]);
            skillArrayList.add(skill);
        }
    }

    public static void editDeveloper(String id, String idAccount, String idSkill, Developer data) {
        JavaIOAccountRepository accountRepository = new JavaIOAccountRepository();
        JavaIOSkillRepository skillRepository = new JavaIOSkillRepository();
        AccountView accountView = new AccountView();
        SkillView skillView = new SkillView();
        DeveloperView developerView = new DeveloperView();
        data.setId(Long.parseLong(id));
        data.setName(developerView.inputDeveloper());
        accountRepository.editDataFromFile(Long.parseLong(idAccount), accountView.inputAccount());
        skillRepository.editDataFromFile(Long.parseLong(idSkill), skillView.inputSkill());
    }

    public static AccountStatus accountStatusCheck(String str) {
        if (AccountStatus.ACTIVE.toString().equals(str))
            return AccountStatus.ACTIVE;
        else if (AccountStatus.BANNED.toString().equals(str))
            return AccountStatus.BANNED;
        else if (AccountStatus.DELETED.toString().equals(str))
            return AccountStatus.DELETED;
        return null;
    }
}
