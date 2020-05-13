package com.hk.springapp.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class LuhnAlgo {
    public static String checkLuhn(String cardNo) {
        cardNo = cardNo.toUpperCase();
        List value = new ArrayList();
        List dValue = new ArrayList();
        int nDigits = cardNo.length();
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {
            int ascii = (int) cardNo.charAt(i);
            int d = 0;
            if (ascii >= 65 && ascii <= 90)
                d = ascii;
            else
                d =  cardNo.charAt(i) - '0';
            value.add(d);
            if (isSecond == true)
                d = d * 2;
            dValue.add(d);
            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }
        log.info(value);
        log.info(dValue);
        log.info("Total sum:"+nSum);
        int checkDigit = (nSum % 10);
        log.info("checkDigit :"+checkDigit);
        return "C"+checkDigit+cardNo;
    }
}
