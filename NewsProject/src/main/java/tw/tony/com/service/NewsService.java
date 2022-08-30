package tw.tony.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;

import tw.tony.com.mapper.NewsMapper;
import tw.tony.com.po.AllNewsDetailed;
import tw.tony.com.vo.ResponseData;

@Service
public class NewsService {
	
	@Autowired
	private NewsMapper newsMapper;
	
	
	//回傳Data
	private ResponseData<IPage<AllNewsDetailed>> responseData(IPage<AllNewsDetailed> page) {
        ResponseData<IPage<AllNewsDetailed>> responseData = new ResponseData();
        
        if(page != null) {
        	responseData.setData(page);
        	responseData.setCode("success");
        	responseData.setMagmessage("成功");
        	return responseData;
        } else {
        	responseData.setCode("error");
        	responseData.setMagmessage("失敗");
        	
        	return responseData;
		}
	}

	// 查整張表
	public ResponseData<IPage<AllNewsDetailed>> getAllNewsDetailed(Long pageNum) {
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 5);
        newsMapper.selectPage(page, null);

		return responseData(page);
	}
	
	
	// 查詢多個BY ID
	public ResponseData<IPage<AllNewsDetailed>> getNewsManyById(Long pageNum,List<Integer> idList) {
		QueryWrapper<AllNewsDetailed> wrapper = new QueryWrapper<>();
		IPage<AllNewsDetailed> page = new Page<>(pageNum,5);
		for(int i = 0; i<idList.size() ;i++ ) {	
		}
		wrapper.eq("id", idList);
		newsMapper.selectPage(page, wrapper);
		return responseData(page);
	}
	
	
	
	//條件查詢(上架的)
	public ResponseData<IPage<AllNewsDetailed>> getNewsManyByPublic(Long pageNum){
		QueryWrapper<AllNewsDetailed> wrapper = new QueryWrapper<>(); 
		wrapper.eq("release_state", 0);
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 5);
        newsMapper.selectPage(page, wrapper);
        
        return responseData(page);
	}
	
	
	//條件查詢(上架的 TAG )
	public ResponseData<IPage<AllNewsDetailed>> getNewsManyByTag(Long pageNum ,String tag){
		
		QueryWrapper<AllNewsDetailed> wrapper = new QueryWrapper<>(); 
		wrapper.eq("release_state", 0).eq("tag", tag);
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 5);
        newsMapper.selectPage(page, wrapper);
        
        return responseData(page);
	}
	
	
	//條件查詢(所有的 TAG )
	public ResponseData<IPage<AllNewsDetailed>> getNewsAllManyByTag(Long pageNum ,String tag){	
		QueryWrapper<AllNewsDetailed> wrapper = new QueryWrapper<>(); 
		wrapper.eq("tag", tag);
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 5);
        newsMapper.selectPage(page, wrapper);
        return responseData(page);
	}
	
	
	
	// 0 = 公開     1 = 下架  2 =刪除(軟刪除)      
	public ResponseData stateModifyNewsById(@RequestParam Integer id, @RequestParam Integer releaseState) {
		AllNewsDetailed allNewsDetailed = new AllNewsDetailed();
		allNewsDetailed.setId(id);
		allNewsDetailed.setReleaseState(releaseState);
		ResponseData responseData = new ResponseData();
		
		int count = newsMapper.updateById(allNewsDetailed);
		if (count >= 1) {
			responseData.setMagmessage("成功");
			responseData.setCode("success");
			return responseData;
		} else {
			responseData.setMagmessage("查無此ID");
			responseData.setCode("error");
			return responseData;
		}

	}
	
	
	
	// 刪除單筆(真實移除)
	public ResponseData deleteNewsById(Integer id) {
		ResponseData responseData = new ResponseData();
		AllNewsDetailed allNewsDetailed = new AllNewsDetailed();
		allNewsDetailed.setId(id);
		int count = newsMapper.deleteById(id);
		if (count >= 1) {
			responseData.setMagmessage("刪除成功");
			return responseData;
		} else {
			responseData.setMagmessage("查無此ID");
			return responseData;
		}
	}
	
	
}
