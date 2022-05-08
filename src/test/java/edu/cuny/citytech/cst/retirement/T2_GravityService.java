package edu.cuny.citytech.cst.retirement;

import edu.cuny.citytech.cst.retirement.connect4.CellHelper;
import edu.cuny.citytech.cst.retirement.model.Cell;
import edu.cuny.citytech.cst.retirement.service.GravityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Gravity Service")public class T2_GravityService {

    @Test
    void t0_whichColumn(){
        int cellPosition = 35;
        int whichColumn = GravityService.getColumnNumber(cellPosition);

        int expected = 0;

        assertEquals(expected, whichColumn);
    }

    @Test
    void t0_getColumnsFromCell(){
        int cellPosition = 16;
        int[] whichColumn = GravityService.getColumnPosition(cellPosition);

        int expected = 37;

        System.out.println(Arrays.toString(whichColumn));

        assertEquals(expected, whichColumn[5]);
    }

    @Test

    void t1_gravity(){

        String moves = """
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                """;

        var cell = new Cell(0,"X","");
        var cells = CellHelper.getCellData.apply(moves);

//        var expected = 35;
//
//        var newcell = GravityService.getPosition(cell, cells);
    }

    @Test
    @DisplayName("Testing with Data  in position 35")
    void t2_gravity() {

        String moves = """
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        X,N,N,N,N,N,N
                """;

        var cell = new Cell(0, "X", "");
        var cells = CellHelper.getCellData.apply(moves);
    }

    @Test
    @DisplayName("No Free Position is available")
    void t3_gravity(){

        String moves = """
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                """;

        var cell = new Cell(0,"X","");
        var cells = CellHelper.getCellData.apply(moves);

        var actual = GravityService.getFreePosition(cell, cells).get().getPosition();


        assertEquals(35,actual);

    }

    @Test
    @DisplayName("Free Position is available at cell 28")
    void t4_gravity(){

        String moves = """
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        N,N,N,N,N,N,N
                        X,N,N,N,N,N,N
                """;

        var cell = new Cell(0,"X","");
        var cells = CellHelper.getCellData.apply(moves);

        var newCell = GravityService.getFreePosition(cell, cells);

        var expected = 28;
        var actual = newCell.get().getPosition();

        assertEquals(expected,actual);

    }
}
