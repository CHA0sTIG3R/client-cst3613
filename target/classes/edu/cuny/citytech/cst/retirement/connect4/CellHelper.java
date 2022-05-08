package edu.cuny.citytech.cst.retirement.connect4;

import edu.cuny.citytech.cst.retirement.model.Cell;

import java.util.function.Function;

public class CellHelper {

    public static Function<String, Cell[]> getCellData = e -> {

        var value = e.replaceAll("\\s+", "")
                            .replaceAll(",","")
                            .split("");

        Cell[] cells = new Cell[value.length];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i,value[i],"N" + i);
        }

        return  cells;
    };

}
