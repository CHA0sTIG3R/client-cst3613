package edu.cuny.citytech.cst.retirement;

import edu.cuny.citytech.cst.retirement.model.Cell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class T1_CellPopulate {

    @Test
    @DisplayName("Populate the Cell Class")
    void t1(){
        var values = IntStream.rangeClosed(0,41)
                .mapToObj(Cell::new)
                .toArray(Cell[]::new);

        for (var e: values){
            System.out.println(e);
        }
    }

}
