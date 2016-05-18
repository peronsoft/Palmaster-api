package com.peronsoft.palmaster.api.palmaster.model;

import java.util.Map;

public class Critical {

    private Map<String, CriticalRow> criticalRows;
    private String criticalType;


    public Critical(Map<String, CriticalRow> weaponRows, String weaponName) {
        this.criticalRows = weaponRows;
        this.criticalType = weaponName;
    }


    public Map<String, CriticalRow> getCriticalRows() {
        return criticalRows;
    }

    public String getAttack(String roll, String armor){
        return criticalRows.get(roll).getValues().get(Integer.valueOf(new Integer(Integer.parseInt(armor)-1).toString()));
    }

    public String getCriticalType() {
        return criticalType;
    }

}
