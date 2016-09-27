package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * 生成数据库
 */
public class DBGenarationMainClass {
    private static final int VERSION = 1;

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(VERSION, "cn.tofly.mis.gasusermanager");

        addTestDb(schema);
        new DaoGenerator().generateAll(schema, "app/src/main/java-gen");
    }

    private static void addTestDb(Schema schema) {
        Utils.log("addTestDb");
        Entity tb = schema.addEntity("TbTest");
        tb.addLongProperty("testId").primaryKey().autoincrement();
        tb.addStringProperty("content");

    }

    /**
     * 消息推送表
     *
     * @param schema
     */
    private static void addPushMessaeTable(Schema schema) {
        Utils.log("create table push message table");
        Entity tbPushMessage = schema.addEntity("TbPushMessage");
        tbPushMessage.addLongProperty("pushMessageId").primaryKey();
        tbPushMessage.addStringProperty("userId");
        tbPushMessage.addStringProperty("messageType");
        tbPushMessage.addLongProperty("sendTime");
        tbPushMessage.addStringProperty("hadReceive");
        tbPushMessage.addStringProperty("itemShowTitle");
        tbPushMessage.addLongProperty("itemShowDate");
        tbPushMessage.addStringProperty("itemShowImgUrl");
        tbPushMessage.addStringProperty("itemShowSummary");
        tbPushMessage.addStringProperty("contentShowType");
        tbPushMessage.addStringProperty("contentShowPlain");
        tbPushMessage.addStringProperty("contentShowUrl");
        tbPushMessage.addStringProperty("shouldShowNotification");
        tbPushMessage.addStringProperty("shouldShowVibrate");
        tbPushMessage.addLongProperty("receiveTime");
        tbPushMessage.addStringProperty("hadDelete");
        tbPushMessage.addStringProperty("hadReadOrNotify");
    }


    /**
     * 书签数据表
     *
     * @param schema
     */
    private static void addBookmarkTable(Schema schema) {
        Utils.log("create table TbBookmark");
        Entity tbBookmark = schema.addEntity("TbBookmark");
        tbBookmark.addLongProperty("bookmarkId").primaryKey().autoincrement();
        tbBookmark.addStringProperty("rootCategoryPath");   // *.szhrpack => *
        tbBookmark.addStringProperty("relativePath");
        tbBookmark.addIntProperty("charAtPosition");        // 当前进度
        tbBookmark.addStringProperty("bookmarkLabel");       //书签label，描述提示
        tbBookmark.addLongProperty("addInTime");            //加入的时间
    }


}
