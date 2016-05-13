package com.peronsoft.palmaster.api.palmaster.service;


import com.peronsoft.palmaster.api.palmaster.model.Weapon;
import com.peronsoft.palmaster.api.palmaster.parser.WeaponTableReader;
import jersey.repackaged.com.google.common.collect.Maps;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class WeaponService {

    private Map<String, Weapon> weapons;

    private static WeaponService instance = null;

    private WeaponService (){
        weapons = initWeaponMap();
    }

    public static WeaponService getInstance(){
        if(instance==null){
           instance = new WeaponService();
        }
        return instance;
    }

    public String getValue (String weaponName, String attackRoll, String defense){
        return getWeapon(weaponName).getAttack(attackRoll, defense);
    }

    public Weapon getWeapon (String weaponName){
        return weapons.get(weaponName);
    }

    private Map<String, Weapon> initWeaponMap(){
        Map <String, Weapon> stringWeaponMap = Maps.newHashMap();
        try {
            Files.walk(Paths.get(this.getClass().getClassLoader().getResource("weapons").getPath())).forEach(filePath -> {
                if (Files.isRegularFile(filePath)){
                    String filename=filePath.getFileName().toString();
                    try {
                        Weapon weapon = new WeaponTableReader().readFile(filePath.toString());
                        stringWeaponMap.put(filename.substring(0, filename.length()-4), weapon);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWeaponMap;
    }

}
