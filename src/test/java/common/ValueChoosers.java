package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Random;

public class ValueChoosers {

    public static String getRandomSex() {
        ArrayList<String> listOfSex = new ArrayList<>();
        listOfSex.add("M");
        listOfSex.add("F");

        return listOfSex.get(RandomUtils.nextInt(0, listOfSex.size()-1));
    }

    public static String getRandomDate() {
        ArrayList<String> listOfRandomDate = new ArrayList<>();
        listOfRandomDate.add ("2000-02-03");
        listOfRandomDate.add ("1992-03-06");
        listOfRandomDate.add("1822-04-01");
        listOfRandomDate.add("1932-07-11");
        listOfRandomDate.add("1980-11-13");

        return listOfRandomDate.get(RandomUtils.nextInt(0, listOfRandomDate.size()-1));
    }

    public static int getRandomId() {
        ArrayList<Integer> listOfRandomIds = new ArrayList<>();
        listOfRandomIds.add (31);
        listOfRandomIds.add (32);
        listOfRandomIds.add (45);
        listOfRandomIds.add (48);
        listOfRandomIds.add (46);
        listOfRandomIds.add (52);
        listOfRandomIds.add (53);
        listOfRandomIds.add (56);
        listOfRandomIds.add (58);
        listOfRandomIds.add (60);
        listOfRandomIds.add (61);
        listOfRandomIds.add (63);
        listOfRandomIds.add (68);
        listOfRandomIds.add (71);
        listOfRandomIds.add (75);
        listOfRandomIds.add (80);

        return listOfRandomIds.get(RandomUtils.nextInt(0, listOfRandomIds.size()-1));
    }

    public static String getRandomBookId() {
        ArrayList<String> listOfRandomBookIds = new ArrayList<>();
        listOfRandomBookIds.add ("2");
        listOfRandomBookIds.add ("22");
        listOfRandomBookIds.add ("19");
        listOfRandomBookIds.add ("72");

        return listOfRandomBookIds.get(RandomUtils.nextInt(0, listOfRandomBookIds.size()-1));
    }

    public static String getRandomDueDate() {
        ArrayList<String> listOfRandomDueDates = new ArrayList<>();
        listOfRandomDueDates.add ("2023-08-23T13:15:42.5586");
        listOfRandomDueDates.add ("2023-11-18T14:33:21.8544");
        listOfRandomDueDates.add ("2024-01-03T15:55:18.7844");
        listOfRandomDueDates.add ("2023-05-15T09:42:13.8547");

        return listOfRandomDueDates.get(RandomUtils.nextInt(0, listOfRandomDueDates.size()-1));
    }
}
