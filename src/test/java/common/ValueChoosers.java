package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChoosers {

    public static String getRandomSex() {
        ArrayList<String> listOfSex = new ArrayList<>();
        listOfSex.add("M");
        listOfSex.add("F");

        return listOfSex.get(RandomUtils.nextInt(0, listOfSex.size()));
    }

    public static String getRandomDate() {
        ArrayList<String> listOfRandomDate = new ArrayList<>();
        listOfRandomDate.add ("2000-02-03");
        listOfRandomDate.add ("1992-03-06");
        listOfRandomDate.add("1822-04-01");
        listOfRandomDate.add("1932-07-11");
        listOfRandomDate.add("1980-11-13");

        return listOfRandomDate.get(RandomUtils.nextInt(0, listOfRandomDate.size()));
    }
}
