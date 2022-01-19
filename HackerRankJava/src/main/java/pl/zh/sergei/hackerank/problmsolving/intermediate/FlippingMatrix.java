package pl.zh.sergei.hackerank.problmsolving.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlippingMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> matrixCalculationScheme = createMatrixCalculationScheme(matrix);
        List<Integer> maxNumberForEachScheme = calculateMaxNumberForEachScheme(matrix, matrixCalculationScheme);
        return maxNumberForEachScheme.stream().mapToInt(Integer::intValue).sum();
    }

    static List<List<Integer>> createMatrixCalculationScheme(List<List<Integer>> matrix) {
        List<List<Integer>> finalScheme = new ArrayList<>();
        return updateScheme(finalScheme, matrix.size(), matrix.size());
    }

    static List<Integer> calculateMaxNumberForEachScheme(List<List<Integer>> matrix, List<List<Integer>> matrixCalculationScheme) {
        int matrixSideSize = matrix.size();
        List<Integer> maxMatrixValues = new ArrayList<>();
        for(int i=0; i<matrixCalculationScheme.size(); i++) {
            List<Integer> calculationPair = matrixCalculationScheme.get(i);
            int rowAdjustemntValue = matrixSideSize - calculationPair.get(0)/2;
            int columnAdjustemntValue = matrixSideSize - calculationPair.get(1)/2;
            int leftTopNumber = matrix.get(0 + rowAdjustemntValue).get(0+columnAdjustemntValue);
            int rightTopNumber = matrix.get(0 + rowAdjustemntValue).get(matrixSideSize - 1 - columnAdjustemntValue);
            int leftBottomNumber = matrix.get(matrixSideSize - 1 - rowAdjustemntValue).get(0+columnAdjustemntValue);
            int rightBottomNumber = matrix.get(matrixSideSize - 1 - rowAdjustemntValue).get(matrixSideSize - 1 - columnAdjustemntValue);
            maxMatrixValues.add(IntStream.of(leftBottomNumber, rightBottomNumber, leftTopNumber, rightTopNumber).max().getAsInt());
        }

        return maxMatrixValues;
    }

    private static List<List<Integer>> updateScheme(List<List<Integer>> finalScheme, int rowSize, int columnSize) {
        if(rowSize > 0) {
            addRowScheme(finalScheme, rowSize, columnSize);
            updateScheme(finalScheme, rowSize-2, columnSize);
        }
        return finalScheme;
    }

    private static void addRowScheme(List<List<Integer>> finalScheme, int rowSize, int columnSize) {
        for(int i=columnSize; i>0; i-=2) {
            finalScheme.add(List.of(rowSize, i));
        }
    }
}
