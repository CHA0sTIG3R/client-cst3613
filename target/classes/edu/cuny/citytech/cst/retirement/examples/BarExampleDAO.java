package edu.cuny.citytech.cst.retirement.examples;

import java.util.ArrayList;
import java.util.List;

public class BarExampleDAO {

    List<Pair> findAll(){
        List list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            var number = (float) (Math.random() * 1_000);
            var pair = new Pair("A00"+ i, number);
            list.add(pair);
        }

        return list;
    }

}
