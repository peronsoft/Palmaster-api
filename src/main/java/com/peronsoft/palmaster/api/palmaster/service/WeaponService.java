package com.peronsoft.palmaster.api.palmaster.service;


import com.peronsoft.palmaster.api.palmaster.model.Weapon;
import com.peronsoft.palmaster.api.palmaster.parser.WeaponTableReader;
import jersey.repackaged.com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
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
        Path somePath = Paths.get(this.getClass().getClassLoader().getResource("weapons").getPath());
        String[] extensions = new String[]{"csv"};
        Iterator<File> iterator = FileUtils.iterateFiles(somePath.toFile(), extensions, false);
        while(iterator.hasNext()){
            File weaponFile = iterator.next();
            Weapon weapon = null;
            try {
                weapon = new WeaponTableReader().readFile(weaponFile.getPath());
                stringWeaponMap.put(weaponFile.getName().substring(0, weaponFile.getName().length()-4), weapon);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringWeaponMap;
    }

}
