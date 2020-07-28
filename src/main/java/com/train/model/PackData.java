package com.train.model;

import lombok.Data;

@Data
public class PackData {

    private String id;

    private PackData next;

    public static final Object sPoolSync = new Object();

    private static PackData sPool;
    //
    private static int sPoolSize = 0;
    //
    private static final int MAX_POOL_SIZE = 15;

    private static boolean gCheckRecycle = true;

    int flags;

    static final int FLAG_IN_USE = 1 << 0;


    /**
     * Flags to clear in the copyFrom method
     */
    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAG_IN_USE;


    public static PackData obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                PackData data = sPool;
                sPool = data.next;
                data.wipe();
                sPoolSize--;
                return data;
            }
        }
        return new PackData();
    }


    public void recycle() {
        if (isInUse()) {
            //如果正在使用时，停止回收
            if (gCheckRecycle) {
                throw new IllegalStateException("This PackData cannot be recycled because it "
                        + "is still in use.");
            }
            return;
        }
        recycleUnchecked();
    }


    void recycleUnchecked() {
        //标记为正在使用中
        flags = FLAG_IN_USE;
        //清除数据
        wipe();
        //将对象丢进缓存池中
        synchronized (sPoolSync) {
            if(sPoolSize<MAX_POOL_SIZE){
                next=sPool; //消息池头部的下一条消息指向为空
                sPool=this; //把当前消息作为消息池头部
                sPoolSize++;
            }
        }
    }

    boolean isInUse() {
        return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }

    void markInUse() {
        flags |= FLAG_IN_USE;
    }


    //清除数据
    private void wipe() {

    }


}
