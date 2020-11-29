import lombok.Builder;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Builder
public class Clazz {
    public int intProp;
    public Set<Integer> setProp;
    public List<String> listProp;
    String stringProp;
    Integer integerProp;
    Double doubleProp;
    Boolean booleanProp;
    Integer[] integerArrProp;
    int[] intArrProp;
    boolean boolProp;
    Map<Integer, String> mapProp;
    CustomCollection collection;

    @Override
    public String toString() {
        String s = "";
        String p = "";
        if (booleanProp != null)
            s += "\n." + "booleanProp" + "(" + booleanProp + ")";
        if (boolProp)
            s += "\n." + "boolProp" + "(" + boolProp + ")";
        if (collection != null) {
            p += "\nCustomCollection _list = new CustomCollection ();";
            for (Object o : collection)
                p += o instanceof String ? "\n_list.add(\"" + o + "\");" : "\n_list.add(" + o + ");";
            s += "\n." + "collection" + "(_list)";
        }
        if (doubleProp != null)
            s += "\n." + "doubleProp" + "(" + doubleProp + ")";
        if (intArrProp != null && intArrProp.length > 0) {
            String s1 = "\n." + "intArrProp" + "(new " + "int" + "[]{";
            for (Object object : intArrProp)
                s1 += object.toString() + ",";
            s += s1.substring(0, s1.length() - 1) + "})";
        }
        if (integerArrProp != null)
            if (integerArrProp != null && integerArrProp.length > 0) {
                String s1 = "\n." + "integerArrProp" + "(Arrays.array(";
                for (Object object : integerArrProp)
                    s1 += object.toString() + ",";
                s += s1.substring(0, s1.length() - 1) + "))";
            }

        if (integerProp != null)
            s += "\n." + "integerProp" + "(" + integerProp + ")";
        if (intProp != 0)
            s += "\n." + "intProp" + "(" + intProp + ")";
        if (listProp != null) {
            p += "\nList _list = List.of();";
            for (Object o : listProp)
                p += o instanceof String ? "\n_list.add(\"" + o + "\");" : "\n_list.add(" + o + ");";
            s += "\n." + "listProp" + "(_list)";
        }
        if (mapProp != null) {
            p += "\nMap _map = Map.of();";
            for (Map.Entry e : mapProp.entrySet()) {
                String key = e.getKey() instanceof String ? "\"" + e.getKey() + "\"" : e.getKey().toString();
                String value = e.getValue() instanceof String ? "\"" + e.getValue() + "\"" : e.getValue().toString();
                p += "\n_map.put(" + key + "," + value + ");";
            }
            s += "\n." + "mapProp" + "(_map)";
        }
        if (setProp != null) {
            p += "\nSet _set = Set.of();";
            for (Object o : setProp)
                p += "\n_set.add(" + o + ");";
            s += "\n." + "setProp" + "(_set)";
        }
        if (stringProp != null)
            s += "\n." + "stringProp" + "(\"" + stringProp + "\")";
        return p + "\nClazz clazz = Clazz" + ".builder()" + s + ".build()";
    }
}
