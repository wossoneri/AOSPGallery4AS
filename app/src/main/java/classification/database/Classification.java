package classification.database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wow on 12/21/17.
 */

public final class Classification {

    public static String findSuperClassification(String key) {

        if (PERSON.contains(key)) {
            return PERSON.class.getSimpleName().toLowerCase();
        }
        if (VEHICLE.contains(key)) {
            return VEHICLE.class.getSimpleName().toLowerCase();
        }
        if (TRAFFIC_FACILITIES.contains(key)) {
            return TRAFFIC_FACILITIES.class.getSimpleName().toLowerCase();
        }
        if (ANIMAL.contains(key)) {
            return ANIMAL.class.getSimpleName().toLowerCase();
        }
        if (LIVINGWARE.contains(key)) {
            return LIVINGWARE.class.getSimpleName().toLowerCase();
        }
        if (SPORTS.contains(key)) {
            return SPORTS.class.getSimpleName().toLowerCase();
        }
        return "Key Doesn't exist";
    }

    public static boolean checkKeyExist(String key) {
        if (PERSON.contains(key)) {
            return true;
        } else if (VEHICLE.contains(key)) {
            return true;
        } else if (TRAFFIC_FACILITIES.contains(key)) {
            return true;
        } else if (ANIMAL.contains(key)) {
            return true;
        } else if (LIVINGWARE.contains(key)) {
            return true;
        } else if (SPORTS.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    public enum PERSON {
        person,

        man,
        woman,
        child;

        private static final Map<String, PERSON> stringToEnum = new HashMap<>();

        static {
            for (PERSON person : values()) {
                stringToEnum.put(person.toString(), person);
            }
        }

        public static PERSON fromString(String symbol) {
            return stringToEnum.get(symbol);
        }

        public static boolean contains(String key) {
            return stringToEnum.containsKey(key);
        }
    }

    public enum VEHICLE {
        vehicle,

        bicycle,
        car,
        motorbike,
        aeroplane,
        bus,
        train,
        truck,
        boat;

        private static final Map<String, VEHICLE> stringToEnum = new HashMap<>();

        static {
            for (VEHICLE item : values()) {
                stringToEnum.put(item.toString(), item);
            }
        }

        public static VEHICLE fromString(String symbol) {
            return stringToEnum.get(symbol);
        }

        public static boolean contains(String key) {
            return stringToEnum.containsKey(key);
        }
    }

    public enum TRAFFIC_FACILITIES {
        traffic_facilities("traffic facilities"),

        traffic_light("traffic light"),
        fire_hydrant("fire hydrant"),
        stop_sign("stop sign"),
        parking_meter("parking meter"),
        bench("bench");

        private static final Map<String, TRAFFIC_FACILITIES> stringToEnum = new HashMap<>();

        static {
            for (TRAFFIC_FACILITIES item : values()) {
                stringToEnum.put(item.toString(), item);
            }
        }

        private String name;

        TRAFFIC_FACILITIES(String text) {
            this.name = text;
        }

        public static TRAFFIC_FACILITIES fromString(String symbol) {
            return stringToEnum.get(symbol);
        }

        public static boolean contains(String key) {
            return stringToEnum.containsKey(key);
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum ANIMAL {
        animal,

        bird,
        cat,
        dog,
        horse,
        sheep,
        cow,
        elephant,
        bear,
        zebra,
        giraffe,
        fish,
        reptile,
        tiger,
        lion,
        monkey,
        amphibian;

        private static final Map<String, ANIMAL> stringToEnum = new HashMap<>();

        static {
            for (ANIMAL item : values()) {
                stringToEnum.put(item.toString(), item);
            }
        }

        public static ANIMAL fromString(String symbol) {
            return stringToEnum.get(symbol);
        }

        public static boolean contains(String key) {
            return stringToEnum.containsKey(key);
        }
    }

    public enum LIVINGWARE {
        livingware,

        backpack,
        umbrella,
        handbag,
        tie,
        suitcase,
        toothbrush;

        private static final Map<String, LIVINGWARE> stringToEnum = new HashMap<>();

        static {
            for (LIVINGWARE item : values()) {
                stringToEnum.put(item.toString(), item);
            }
        }

        public static LIVINGWARE fromString(String symbol) {
            return stringToEnum.get(symbol);
        }

        public static boolean contains(String key) {
            return stringToEnum.containsKey(key);
        }
    }

    public enum SPORTS {
        sports("sports"),

        frisbee("frisbee"),
        skis("skis"),
        snowboard("snowboard"),
        sports_ball("sports ball"),
        kite("kite"),
        baseball_bat("baseball bat"),
        baseball_glove("baseball glove"),
        skateboard("skateboard"),
        surfboard("surfboard"),
        tennis_racket("tennis racket");

        private static final Map<String, SPORTS> stringToEnum = new HashMap<>();

        static {
            for (SPORTS item : values()) {
                stringToEnum.put(item.toString(), item);
            }
        }

        private String name;

        SPORTS(String text) {
            this.name = text;
        }

        public static SPORTS fromString(String symbol) {
            return stringToEnum.get(symbol);
        }

        public static boolean contains(String key) {
            return stringToEnum.containsKey(key);
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
