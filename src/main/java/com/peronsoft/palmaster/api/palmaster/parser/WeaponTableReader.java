package com.peronsoft.palmaster.api.palmaster.parser;


import com.peronsoft.palmaster.api.palmaster.model.Weapon;
import com.peronsoft.palmaster.api.palmaster.model.WeaponRow;
import jersey.repackaged.com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WeaponTableReader {

    public Weapon readFile(String path) throws URISyntaxException, IOException {
        Path filePath = Paths.get(path);
        String fileName = filePath.getFileName().toString();
        String weaponName = fileName.substring(0, fileName.length() - 4);
        Map<String, WeaponRow> rows = Maps.newHashMap();

        List<String> fileLines = FileUtils.readLines(filePath.toFile(), Charset.defaultCharset());
        String[]headerLine=fileLines.get(0).split(",");

        for (int i = 1; i < fileLines.size(); i++){
            String[] values = fileLines.get(i).split(",");
            WeaponRow rowToSave = new WeaponRow(Arrays.asList(Arrays.copyOfRange(values, 1, values.length-1)));
            rows.put(values[0], rowToSave);
        }
        return new Weapon(rows, weaponName);
    }


}
