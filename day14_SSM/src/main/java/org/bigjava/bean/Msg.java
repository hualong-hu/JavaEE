package org.bigjava.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: JavaEE
 * @ClassName: Msg
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-11 18:30
 * @Version v1.0
 */
public class Msg {
    //200：处理成功   404：处理失败
    private int code;
    //提示信息
    private String msg;
    //用户返回给浏览器的数据
    private Map<String,Object> info = new HashMap<>();

    public Msg add(String key,Object value){
        this.getInfo().put(key, value);
        return this;
    }

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("处理成功！");
        return msg;
    }
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(404);
        msg.setMsg("处理失败！");
        return msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
