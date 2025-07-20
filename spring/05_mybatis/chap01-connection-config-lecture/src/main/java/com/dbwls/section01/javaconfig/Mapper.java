package com.dbwls.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

// XML 없이 어노테이션을 이용해 SQL을 정의함
public interface Mapper {
    @Select("SELECT NOW()")
    java.util.Date selectDate();
}
