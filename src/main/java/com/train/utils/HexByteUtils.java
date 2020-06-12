package com.train.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: yuzzha
 * Date: 2020/6/1 16:22
 * Description: ${DESCRIPTION}
 */
public class HexByteUtils {


    //补全 len 个字节的
    public static String buildComplLen(String src, int len) {
        if (src == null) {
            src = "";
        }
        if (len == 0) {
            return src;
        }
        if (src.length() == len) {
            return src;
        } else if (src.length() > len) {
            throw new RuntimeException(src + " len :" + src.length() + " ,长度已经超出限制: " + len);
        } else {
            return buildComplLen("0".concat(src), len);
        }
    }


    /**
     * 将byte 中对应的二进制位转换位对应的（index+1）转为List，
     * 用于将 控制器返回参数 转发给 前端数据格式
     *
     * @param value
     * @return
     */
    public static List<Integer> byteToIntList(byte value) {
        List<Integer> lock = new ArrayList<>(8);
        if (byteToInt(value) > 0) {
            for (int i = 0; i < 8; i++) {
                if ((value & (1 << i)) > 0) {
                    lock.add(i + 1);
                }
            }
        }
        return lock;
    }

    /**
     * 将门禁号 Int List转成byte 再转为Hex
     * <p>
     * 见门号定义规则：
     *
     * @param value List<Integer>
     * @return Hex
     */
    public static String buildIntegerListToHex(List<Integer> value) {
        int dest = 0;
        for (Integer bit : value) {
            if (bit <= 8) {
                dest = dest | (1 << (bit - 1));
            }
        }
        return Integer.toHexString(dest & 0xFF);
    }

    /**
     * @param value
     * @return
     */
    public static byte intListToByte(List<Integer> value) {
        int dest = 0;
        for (Integer bit : value) {
            if (bit <= 8) {
                dest = dest | (1 << (bit - 1));
            }
        }
        byte result = (byte) (dest & 0xFFFF);
        return result;
    }


    public static String listHex(List<Integer> value) {
        int dest = 0;
        for (Integer bit : value) {
            if (bit <= 8) {
                dest = dest | (1 << (bit - 1));
            }
        }
        return Integer.toHexString(dest & 0xFF);
    }

    /**
     * 这里统一将 0x55 转为 1 ；0xAA 转为 0
     *
     * @param value 控制器返回状态byte
     * @return 转为Vo回显int值
     */
    public static int checkState(byte value) {
        if (value == 0x55) {
            return 1;
        } else if (value == 0xAA) {
            return 0;
        }
        return 0;
    }

    /**
     * 这里统一将  1 转为 0x55 ；0 转为 0xAA
     *
     * @param value 将前端接口中int 状态值
     * @return 转为控制器识别的状态值
     */
    public static String setState(int value) {
        if (value == 1) {
            return "55";
        } else if (value == 0) {
            return "AA";
        }
        return "AA";
    }


    public static int byteToInt(byte bit) {
        return bit & 0xFF;
    }

    public static byte[] hexStringToBytes(String hexString) {
        return hexStringToBytes(hexString, 0);
    }

    public static byte[] hexStringToBytes(String hexString, int extre) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length + extre];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }


    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static int crc16_ccitt_xmodem(byte[] bytes, int offset, int count) {
        int crc = 0x0000; // initial value
        int polynomial = 0x1021; // poly value
        for (int index = offset; index < count; index++) {
            byte b = bytes[index];
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit)
                    crc ^= polynomial;
            }
        }
        crc &= 0xffff;
        return crc;
    }


    public static int revert(int src) {
        int lowByte = (src & 0xFF00) >> 8;
        int highByte = (src & 0x00FF) << 8;
        return lowByte | highByte;
    }

    public static String revertToHex(int src) {
        int lowByte = (src & 0xFF00) >> 8;
        int highByte = (src & 0x00FF) << 8;
        return Integer.toHexString(lowByte | highByte);
    }

    /*unsigned int cal_crc(unsigned char *ptr,  unsigned char len)
    {
        unsigned int crc;
        unsigned char da;
        crc=0;
        while(len--!=0) {
            da=(unsigned char) (crc>>8);    	*//* 以8位二进制数的形式暂存CRC的高8位 *//*
            crc<<=8;              					*//* 左移8位，相当于CRC的低8位乘以  *//*
            crc^=crc_ta[da^*ptr];     			*//* 高8位和当前字节相加后再查表求CRC ，再加上以前的CRC *//*
            ptr++;
        }
        return(crc);
    }*/

    public static int calcCrc(char[] ptr, int len) {
        int crc;
        char da;
        crc = 0;
        int i = 0;
        int tmp;
        while (len-- != 0) {
            da = (char) (crc >> 8);
            crc <<= 8;
            System.out.println("----------> da:"+da +"  ptr[i]:"+ptr[i]);
            tmp = da ^ ptr[i];
            System.out.println("---------->  "+tmp);
            crc ^= crc_ta[tmp];
            i++;
        }
        return crc;
    }


    public static final int crc_ta[] = {               /* CRC余式表 */
            0x0000, 0x1021, 0x2042, 0x3063, 0x4084, 0x50a5, 0x60c6, 0x70e7,
            0x8108, 0x9129, 0xa14a, 0xb16b, 0xc18c, 0xd1ad, 0xe1ce, 0xf1ef,
            0x1231, 0x0210, 0x3273, 0x2252, 0x52b5, 0x4294, 0x72f7, 0x62d6,
            0x9339, 0x8318, 0xb37b, 0xa35a, 0xd3bd, 0xc39c, 0xf3ff, 0xe3de,
            0x2462, 0x3443, 0x0420, 0x1401, 0x64e6, 0x74c7, 0x44a4, 0x5485,
            0xa56a, 0xb54b, 0x8528, 0x9509, 0xe5ee, 0xf5cf, 0xc5ac, 0xd58d,
            0x3653, 0x2672, 0x1611, 0x0630, 0x76d7, 0x66f6, 0x5695, 0x46b4,
            0xb75b, 0xa77a, 0x9719, 0x8738, 0xf7df, 0xe7fe, 0xd79d, 0xc7bc,
            0x48c4, 0x58e5, 0x6886, 0x78a7, 0x0840, 0x1861, 0x2802, 0x3823,
            0xc9cc, 0xd9ed, 0xe98e, 0xf9af, 0x8948, 0x9969, 0xa90a, 0xb92b,
            0x5af5, 0x4ad4, 0x7ab7, 0x6a96, 0x1a71, 0x0a50, 0x3a33, 0x2a12,
            0xdbfd, 0xcbdc, 0xfbbf, 0xeb9e, 0x9b79, 0x8b58, 0xbb3b, 0xab1a,
            0x6ca6, 0x7c87, 0x4ce4, 0x5cc5, 0x2c22, 0x3c03, 0x0c60, 0x1c41,
            0xedae, 0xfd8f, 0xcdec, 0xddcd, 0xad2a, 0xbd0b, 0x8d68, 0x9d49,
            0x7e97, 0x6eb6, 0x5ed5, 0x4ef4, 0x3e13, 0x2e32, 0x1e51, 0x0e70,
            0xff9f, 0xefbe, 0xdfdd, 0xcffc, 0xbf1b, 0xaf3a, 0x9f59, 0x8f78,
            0x9188, 0x81a9, 0xb1ca, 0xa1eb, 0xd10c, 0xc12d, 0xf14e, 0xe16f,
            0x1080, 0x00a1, 0x30c2, 0x20e3, 0x5004, 0x4025, 0x7046, 0x6067,
            0x83b9, 0x9398, 0xa3fb, 0xb3da, 0xc33d, 0xd31c, 0xe37f, 0xf35e,
            0x02b1, 0x1290, 0x22f3, 0x32d2, 0x4235, 0x5214, 0x6277, 0x7256,
            0xb5ea, 0xa5cb, 0x95a8, 0x8589, 0xf56e, 0xe54f, 0xd52c, 0xc50d,
            0x34e2, 0x24c3, 0x14a0, 0x0481, 0x7466, 0x6447, 0x5424, 0x4405,
            0xa7db, 0xb7fa, 0x8799, 0x97b8, 0xe75f, 0xf77e, 0xc71d, 0xd73c,
            0x26d3, 0x36f2, 0x0691, 0x16b0, 0x6657, 0x7676, 0x4615, 0x5634,
            0xd94c, 0xc96d, 0xf90e, 0xe92f, 0x99c8, 0x89e9, 0xb98a, 0xa9ab,
            0x5844, 0x4865, 0x7806, 0x6827, 0x18c0, 0x08e1, 0x3882, 0x28a3,
            0xcb7d, 0xdb5c, 0xeb3f, 0xfb1e, 0x8bf9, 0x9bd8, 0xabbb, 0xbb9a,
            0x4a75, 0x5a54, 0x6a37, 0x7a16, 0x0af1, 0x1ad0, 0x2ab3, 0x3a92,
            0xfd2e, 0xed0f, 0xdd6c, 0xcd4d, 0xbdaa, 0xad8b, 0x9de8, 0x8dc9,
            0x7c26, 0x6c07, 0x5c64, 0x4c45, 0x3ca2, 0x2c83, 0x1ce0, 0x0cc1,
            0xef1f, 0xff3e, 0xcf5d, 0xdf7c, 0xaf9b, 0xbfba, 0x8fd9, 0x9ff8,
            0x6e17, 0x7e36, 0x4e55, 0x5e74, 0x2e93, 0x3eb2, 0x0ed1, 0x1ef0
    };


}
