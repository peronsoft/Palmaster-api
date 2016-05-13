package com.peronsoft.palmaster.api.palmaster.model;

import java.util.Map;

public class Weapon {

    private Map<String, WeaponRow> weaponRows;
    private String weaponName;


    public Weapon(Map<String, WeaponRow> weaponRows, String weaponName) {
        this.weaponRows = weaponRows;
        this.weaponName = weaponName;
    }


    public Map<String, WeaponRow> getWeaponRows() {
        return weaponRows;
    }

    public String getAttack(String roll, String armor){
        return weaponRows.get(roll).getValues().get(Integer.valueOf(armor));
    }

    public String getWeaponName() {
        return weaponName;
    }

}
