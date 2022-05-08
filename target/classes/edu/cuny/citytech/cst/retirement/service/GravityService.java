package edu.cuny.citytech.cst.retirement.service;

import edu.cuny.citytech.cst.retirement.model.Cell;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class GravityService {
    public static int getColumnNumber(int cellPosition) {
        int columnNumber = cellPosition % 7;
        return columnNumber;
    }

    public static int[] getColumnPosition(int cellPosition) {

        var columnNumber = getColumnNumber(cellPosition);

        var columnPosition = IntStream.rangeClosed(0,5).map(m -> m * 7 + columnNumber).toArray();

        return columnPosition;
    }

    public static Optional<Cell> getFreePosition(Cell cell, Cell[] cells) {
        var cellPosition = cell.getPosition();
        var columnPosition = getColumnPosition(cellPosition);

        Optional<Cell> finalAnswer = Optional.empty();

        var result = Arrays.stream(columnPosition)
                                  .mapToObj(e -> cells[e])
                                  .filter(e -> !e.getValue().equals("N"))
                                  .findFirst();

        if (result.isEmpty()){
            var freePosition = columnPosition[5];
            finalAnswer = finalAnswer.of(cells[freePosition]);
        } else if (result.isPresent()){
            var freePosition = result.get().getPosition() - 7;
            finalAnswer = finalAnswer.of(cells[freePosition]);
        }

        return finalAnswer;
    }
}
