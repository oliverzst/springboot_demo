package cn.no7player.config.read_write_depart;

import lombok.Getter;

/**
 * @author zhangst
 * @create 2017-07-11 10:26
 */

public enum  DataSourceType {

    read("read", "从库"),
    write("write", "主库");
    @Getter
    private String type;
    @Getter
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

}
