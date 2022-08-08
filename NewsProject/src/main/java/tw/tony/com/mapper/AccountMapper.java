package tw.tony.com.mapper;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import tw.tony.com.po.Account;

@Repository
public interface  AccountMapper extends BaseMapper<Account> {
	//根據ID查詢用戶訊息為MAP集合
	Map<String, Object> selectMapById(Integer id);
	
	

}
