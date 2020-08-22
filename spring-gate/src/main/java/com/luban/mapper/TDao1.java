package com.luban.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TDao1 {

	@Select("select * from t_order")
	public List<Map> list();
}
