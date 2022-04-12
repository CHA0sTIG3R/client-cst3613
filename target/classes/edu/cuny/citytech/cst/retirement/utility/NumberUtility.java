package edu.cuny.citytech.cst.retirement.utility;

import edu.cuny.citytech.cst.retirement.model.Client;

import java.util.List;

public class NumberUtility {

    public static int getMax(List<Client> clientList){
        float max = 0;
        int maxIndex = 0;
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getAmount() > max){
                max = clientList.get(i).getAmount();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int getMin(List<Client> clientList){
        float min = clientList.get(0).getAmount();
        int minIndex = 0;
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getAmount() < min){
                min = clientList.get(i).getAmount();
                minIndex = i;
            }
        }
        return minIndex;
    }
}
