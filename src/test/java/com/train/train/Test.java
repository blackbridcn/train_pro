package com.train.train;

import com.train.utils.HexByteUtils;

/**
 * Author: yuzzha
 * Date: 2020/6/12 18:20
 * Description: ${DESCRIPTION}
 */
public class Test {

    public static void main(String[] args) {
        String src   ="45373d000000020dd3e41f030101c0000100080600030153140000fffefc0ef006f002e002e002c002c002c002800280028002800280068006800ec01e000000000000000000000000000000002f93c93e492981fe3e2b1d5e1f36075e583d573e3e3f025e2ac107fe3a0b4a172c21c7df52b6409f1b3b087f34bf453c4e9d411d489e045d3430451a36339d3a2e32851b620c937362152739600fe3f0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000030158160000fffef01ee01ec006c0068002800280068006800680068006800e000e001e801ec07e00000000000000000000000000000000281008be1832879e1238089e503a97be251e879f4b3340df419bc49c37279d5c31c05c9c481a413d3ea6c25d2dbc04fa223dc75a23c21e3a272fc49b343c42bb34a046982dad05782eafdd58369f5e99293f45795b92281700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";//d4fe  54,526‬
        String target="45373d000000020dd3e41f030101c0000100080600030153140000fffefc0ef006f002e002e002c002c002c002800280028002800280068006800ec01e000000000000000000000000000000002f93c93e492981fe3e2b1d5e1f36075e583d573e3e3f025e2ac107fe3a0b4a172c21c7df52b6409f1b3b087f34bf453c4e9d411d489e045d3430451a36339d3a2e32851b620c937362152739600fe3f0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000030158160000fffef01ee01ec006c0068002800280068006800680068006800e000e001e801ec07e00000000000000000000000000000000281008be1832879e1238089e503a97be251e879f4b3340df419bc49c37279d5c31c05c9c481a413d3ea6c25d2dbc04fa223dc75a23c21e3a272fc49b343c42bb34a046982dad05782eafdd58369f5e99293f45795b92281700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";//bf89   49,033‬
        System.out.println("---->"+src.equals(target));
        byte[] srcByte = HexByteUtils.hexStringToBytes(src);
        int i = HexByteUtils.crc16_ccitt_xmodem(srcByte,0,srcByte.length);

        byte[] targetByte = HexByteUtils.hexStringToBytes(target);
        char[] array = target.toCharArray();
        int targetI=  HexByteUtils.calcCrc(target.toCharArray(),array.length);
        System.out.println("-------------------->  targetH :"+Integer.toHexString(targetI));
        int targetByteI = HexByteUtils.crc16_ccitt_xmodem(targetByte,0,targetByte.length);


        System.out.println("-------------------->  SRC:"+Integer.toHexString(i));
        System.out.println("-------------------->  target:"+Integer.toHexString(targetByteI));
    }
}
