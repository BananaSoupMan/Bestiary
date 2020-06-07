package org.allgays.bestyary.Model;

public class Monster {
    private String name, danger, type;

    private Monster() {}

    public Monster(String name, String danger, String type) {
        this.name = name;
        this.danger = danger;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDanger() {
        return danger;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
