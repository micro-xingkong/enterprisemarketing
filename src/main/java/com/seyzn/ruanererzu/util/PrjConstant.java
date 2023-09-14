package com.seyzn.ruanererzu.util;

public interface PrjConstant {
    //加密盐值
    String PWD_SALT = "tlas";
    //加密迭代
    int PWD_ITERATIONS = 10;

    //上传场景的图片地址
    String SCE_PATH = "images/scense";
    //上传玩家的头像地址
    String PLAYER_PATH = "images/player";

    //每个市场最少商品个数
    int MIN_MARKET_PRO_COUNT = 3;
    //每个市场最多商品个数
    int MAX_MARKET_PRO_COUNT = 8;

    //游戏天数
    int MAX_GAME_DAY = 40;

    //每天的利息
    float DAY_RATE = 0.1f;
}
