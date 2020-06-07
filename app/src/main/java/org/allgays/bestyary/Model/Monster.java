package org.allgays.bestyary.Model;

public class Monster {
    private String monster_name, monster_danger, monster_type;

    private Monster() {}

    public Monster(String monster_name, String monster_danger, String monster_type) {
        this.monster_name = monster_name;
        this.monster_danger = monster_danger;
        this.monster_type = monster_type;
    }

    public String getMonster_name() {
        return monster_name;
    }

    public void setMonster_name(String monster_name) {
        this.monster_name = monster_name;
    }

    public String getMonster_danger() {
        return monster_danger;
    }

    public void setMonster_danger(String monster_danger) {
        this.monster_danger = monster_danger;
    }

    public String getMonster_type() {
        return monster_type;
    }

    public void setMonster_type(String monster_type) {
        this.monster_type = monster_type;
    }
}
