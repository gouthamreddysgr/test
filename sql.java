import java.util.*;
class sql {

    Map<String,Map<Integer,List<String>>> d = new HashMap();
    Map<String,Integer> x = new HashMap();

    public sql(List<String> names, List<Integer> columns) {
        for(String n:names) {
            Map<Integer,List<String>> t = new HashMap();
            d.put(n,t);
        }
    }
    
    public void insertRow(String name, List<String> row) {
        int i = x.getOrDefault(name,1);
        d.get(name).put(i,row);
        x.put(name,i+1);
    }
    
    public void deleteRow(String name, int rowId) {
        d.get(name).remove(rowId);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        return d.get(name).get(rowId).get(columnId-1);
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Table1", "Table2"); // Sample table names
        List<Integer> columns = Arrays.asList(3, 4); // Sample number of columns for each table
        
        sql sc = new sql(names, columns); // Create an instance of the SQL class
        
        // Insert rows into Table1
        sc.insertRow("Table1", Arrays.asList("Data1", "Data2", "Data3"));
        sc.insertRow("Table1", Arrays.asList("Info1", "Info2", "Info3"));
        sc.insertRow("Table1", Arrays.asList("Value1", "Value2", "Value3"));
        
        // Insert rows into Table2
        sc.insertRow("Table2", Arrays.asList("A", "B", "C", "D"));
        sc.insertRow("Table2", Arrays.asList("E", "F", "G", "H"));
        
        // Select and display cells
        System.out.println("Selecting cells:");
        System.out.println("Table1, Row 2, Column 3: " + sc.selectCell("Table1", 2, 3));
        System.out.println("Table2, Row 1, Column 4: " + sc.selectCell("Table2", 1, 4));
        
        // Delete rows
        sc.deleteRow("Table1", 2); // Delete row 2 from Table1
        
        // Select and display cells after deletion
        System.out.println("\nSelecting cells after deletion:");
        System.out.println("Table1, Row 2, Column 3: " + sc.selectCell("Table1", 2, 3));
    }
}

/**
 * Your sc object will be instantiated and called as such:
 * sc obj = new sc(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */