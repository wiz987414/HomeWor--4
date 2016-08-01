import java.util.*;

public class CollectionUtilsPrototype {
    public static void main(String[] args) {

        List<HashMap<String, String>> list1 = new ArrayList<>();
        List<HashMap<String, String>> list2 = new ArrayList<>();

        list1.add(new HashMap<>());
        list1.get(0).put("Product", "Economics");
        list1.get(0).put("Price", "Economics");
        list1.add(new HashMap<>());
        list1.get(1).put("Strength", "Physics");

        list2.add(new HashMap<>());
        list2.get(0).put("Digit", "Math");

        CollectionUtils.addAll(list2, list1);
        System.out.println("\nList after adding all elements of other list:");
        CollectionUtilsPrototype.listOut(list1);

        List<HashMap<String, String>> list3 = CollectionUtils.newArrayList();
        list3.add(new HashMap<>());
        list3.get(0).put("Oxygen", "Chemistry");
        list3.get(0).put("Hydrogen", "Chemistry");
        System.out.println("\nNew added list:");
        CollectionUtilsPrototype.listOut(list3);

        System.out.println("\nIndex of list element:");
        System.out.println(list1.get(0).get("Price") + " - " + CollectionUtils.indexOf(list1, list1.get(0)));
        System.out.println(list1.get(2).get("Digit") + " - " + CollectionUtils.indexOf(list1, list1.get(2)));

        System.out.println("\nSublist of input list:");
        List<HashMap<String, String>> list4 = CollectionUtils.limit(list1, 2);
        CollectionUtilsPrototype.listOut(list4);

        System.out.println("\nAdding element to list:");
        CollectionUtils.add(list2, list1.get(0));
        CollectionUtils.add(list2, list3.get(0));
        CollectionUtilsPrototype.listOut(list2);

        System.out.println("\nRemove from list all elements another list:");
        CollectionUtils.removeAll(list2, list3);
        CollectionUtilsPrototype.listOut(list2);

        CollectionUtils.addAll(list3, list2);
        if (CollectionUtils.containsAll(list2, list3))
            System.out.println("\nAll elements of List №3 contains in List №2");
        else System.out.println("\nList №2 not contains all elements of List №3");

        if (CollectionUtils.containsAny(list1, list2))
            System.out.println("\nSome elements of List №1 contains in List №2");
        else System.out.println("\n List №1 and List №2 haven't same elements");

        List<Integer> intList1 = CollectionUtils.range(Arrays.asList(8,1,3,5,6,4), 3, 6);
        System.out.println("\n" + intList1);
        List<Integer> intList2 = CollectionUtils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("\n" + intList2);

        /*List<HashMap<String, String>> list5 = CollectionUtils.range(list2, list2.get(1), list2.get(3));
        List<HashMap<String, String>> list6 = CollectionUtils.range(list2, list2.get(1), list2.get(3), new Comparator<HashMap<String, String>>() {
            @Override
            public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
                return 0;
            }
        });  */
    }

    private static void listOut(List<HashMap<String, String>> list) {
        for (HashMap<String, String> listItem : list)
            for (Map.Entry mapItem : listItem.entrySet())
                System.out.println(mapItem.getValue() + " - " + mapItem.getKey());
    }
}
