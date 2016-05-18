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

/**
 * Created by rodrigo on 16/05/16.
 */
public class CriticalService {
    private static CriticalService instance = null;

    private CriticalService (){

    }


    public static CriticalService getInstance() {
        if (instance==null){
            instance = new CriticalService();
        }
        return instance;
    }

    public String getValue(String criticalType, String criticalRoll, String criticalLvl) {


        return null;
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
