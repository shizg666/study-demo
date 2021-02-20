package com.shizg.study.demo.design.srategy;

import java.util.HashMap;
import java.util.Map;

public enum MenberTypes {
    ORDINARY(1, "普通会员"),
    SILVER(2,"白银会员");



    public Integer type;
    public String name;

    MenberTypes(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public Integer getType() {
        return type;
    }

    /**
     * 根据type获取枚举对象
     * @param type
     * @return
     */

    private static Map<Integer, MenberTypes> map = null; // type, enum映射
    private static boolean isInit = false;
    public static MenberTypes getInstByType(Integer type){
        if(type==null){
            return null;
        }
        if(!isInit){
            synchronized(MenberTypes.class){
                if(!isInit){
                    map = new HashMap<Integer, MenberTypes>();
                    for(MenberTypes enu : MenberTypes.values()){
                        map.put(enu.getType(), enu);
                    }
                }
                isInit = true;
            }

        }
        MenberTypes pojoEnum = map.get(type);
        return pojoEnum;
    }
}
