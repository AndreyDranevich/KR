package dranevich;

/**
 * Created by Andrey on 26.11.2016.
 */

class Arrays {
    private String type;
    private String name;
    private String size;

    void initName(String name) {
        this.name = name;
    }

    void initType(String type) {
        this.type = type;
    }

    void initSize(String size) {
        this.size = size;
    }

    void print() {
        System.out.println(type + " " + name + " " + size);
    }

    String returnArray() {
        return type + " " + name + "" + size;
    }

    String getSize() {
        return size;
    }

    String getType() {
        return type;
    }

    String getName() {
        return name;
    }
}
