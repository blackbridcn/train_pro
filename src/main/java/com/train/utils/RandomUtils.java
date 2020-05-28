package com.train.utils;

import java.util.Random;

/**
 * Author: yuzzha
 * Date: 2020/5/27 10:32
 * Description: ${DESCRIPTION}
 */
public class RandomUtils {

    private static Random random;

    public static long creatRandom() {
        if (random == null) {
            random = new Random(2000);
        }
        int ran = random.nextInt();
        return ran > 0 ? ran : ran * -1;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        //1617183257
        //1590562014280
    }
}
