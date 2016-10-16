package com.guyuga.guyrobot.Model;

import com.google.common.base.Strings;
import com.orm.SugarRecord;

/**
 * Created by guyug on 13/10/2016.
 */

public class Robot extends SugarRecord {

    public Robot() {
    }

    public Robot(String name, String description, String image_url,
                 int strength, int durability, int maneuverability,
                 int weapon_slots, int customisation) {
        this.name = name;
        this.description = description;
        this.image_url = image_url;
        this.strength = strength;
        this.durability = durability;
        this.maneuverability = maneuverability;
        this.weapon_slots = weapon_slots;
        this.customisation = customisation;
    }

    private String name;
    private String description;
    private String image_url;
    private int strength;
    private int durability;
    private int maneuverability;
    private int weapon_slots;
    private int customisation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getManeuverability() {
        return maneuverability;
    }

    public void setManeuverability(int maneuverability) {
        this.maneuverability = maneuverability;
    }

    public int getWeapon_slots() {
        return weapon_slots;
    }

    public void setWeapon_slots(int weapon_slots) {
        this.weapon_slots = weapon_slots;
    }

    public int getCustomisation() {
        return customisation;
    }

    public void setCustomisation(int customisation) {
        this.customisation = customisation;
    }
}
