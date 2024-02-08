package com.example.s17d3.validation;

import com.example.s17d3.entity.Koala;
import com.example.s17d3.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKoalaValidation {

    private static final String ID_IS_NOT_VALID = "Id can not less than 0";

    private static final String KOALA_NOT_EXIST = "Koala with given id is not exist: ";

    private static final String ANIMAL_CREDENTIALS_NOT_VALID = "Koala Credentials are not valid";


    public static void isIdNotValid(int id) {
        if (id<0){
            throw new ZooException(ID_IS_NOT_VALID, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKoalaNotExist(Map<Integer, Koala> koalaMap, int id){
        if (!koalaMap.containsKey(id)){
            throw new ZooException(KOALA_NOT_EXIST + id,HttpStatus.NOT_FOUND);
        }
    }

    public static void isKoalaCredentialValid(Koala koala){
        if (koala== null ||
                koala.getName() == null ||
                koala.getName().isEmpty() || koala.getGender() == null ||
                koala.getGender().isEmpty()){
            throw new ZooException(ANIMAL_CREDENTIALS_NOT_VALID,HttpStatus.BAD_REQUEST);
        }
    }
}
