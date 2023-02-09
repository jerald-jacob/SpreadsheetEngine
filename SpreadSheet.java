import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SpreadSheet {

    private Map<String, Object> cellValues;

    public SpreadSheet() {
        this.cellValues = new HashMap<>();
    }

    public int getCellValue(String cellId) {
        Set<String> visitedCells = new HashSet<>();
        return getCellValue(cellId, visitedCells);
    }

    private int getCellValue(String cellId, Set<String> visitedCells) {
        Object cellValue = cellValues.get(cellId);

        if (cellValue instanceof Integer) {
            return (int) cellValue;
        } else if (cellValue instanceof String) {
            String formula = (String) cellValue;
            int result = 0;

            String[] terms = formula.split("\\+");

            for (String term : terms) {
                String termCellId = term.trim();
                if (termCellId.startsWith("=")) {
                    termCellId = termCellId.substring(1);
                }
                // Check if the cellId does not exist in the map
                if (!cellValues.containsKey(termCellId)) {
                    throw new IllegalArgumentException("Invalid cell reference " + termCellId);
                }
                // Check for circular reference
                if (visitedCells.contains(termCellId)) {
                    throw new IllegalArgumentException("Circular reference detected for cell " + termCellId);
                }
                visitedCells.add(termCellId);
                result += getCellValue(termCellId, visitedCells);
                visitedCells.remove(termCellId);
            }
            return result;
        } else {
            throw new IllegalArgumentException("Invalid cell value type ");
        }
    }

    public void setCellValue(String cellId, Object value) {
        this.cellValues.put(cellId, value);
    }
}