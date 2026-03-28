import java.util.*;

public class CargoBot {

    public static Map<String, Object> PROCESS_MANIFEST(String[] CARGO_LIST) {

        int TOTAL_ITEMS_PROCESSED = 0;
        int DISCARDED_COUNT = 0;

        List<String> VALID_ITEMS = new ArrayList<>();
        List<Integer> PRIORITY_LIST = new ArrayList<>();

        int INDEX = 0;

        while (true) {
            try {
                String ITEM = CARGO_LIST[INDEX];

                TOTAL_ITEMS_PROCESSED++;

                char FIRST = Character.toLowerCase(ITEM.charAt(0));
                char LAST = Character.toLowerCase(ITEM.charAt(ITEM.length() - 1));

                if (FIRST == LAST) {
                    DISCARDED_COUNT++;
                } else {
                    int PRIORITY = ITEM.charAt(0) + ITEM.charAt(ITEM.length() - 1);

                    VALID_ITEMS.add(ITEM);
                    PRIORITY_LIST.add(PRIORITY);
                }

                INDEX++;

            } catch (Exception e) {
                break;
            }
        }

        int I = 0;

        while (I < VALID_ITEMS.size()) {
            int J = 0;

            while (J < VALID_ITEMS.size() - 1) {

                if (PRIORITY_LIST.get(J) < PRIORITY_LIST.get(J + 1)) {

                    int TEMP_PRIORITY = PRIORITY_LIST.get(J);
                    PRIORITY_LIST.set(J, PRIORITY_LIST.get(J + 1));
                    PRIORITY_LIST.set(J + 1, TEMP_PRIORITY);

                    String TEMP_ITEM = VALID_ITEMS.get(J);
                    VALID_ITEMS.set(J, VALID_ITEMS.get(J + 1));
                    VALID_ITEMS.set(J + 1, TEMP_ITEM);
                }

                J++;
            }

            I++;
        }

        Map<String, Object> RESULT = new HashMap<>();

        RESULT.put("total_items_processed", TOTAL_ITEMS_PROCESSED);
        RESULT.put("discarded_count", DISCARDED_COUNT);
        RESULT.put("final_order", VALID_ITEMS);
        RESULT.put("sanity_check",
                "I prefer iteration because it is simple and avoids recursion issues.");

        return RESULT;
    }

    public static void main(String[] args) {
        String[] INPUT = {"Apple", "Banana", "Cat", "Level"};

        Map<String, Object> OUTPUT = PROCESS_MANIFEST(INPUT);

        System.out.println(OUTPUT);
    }
}