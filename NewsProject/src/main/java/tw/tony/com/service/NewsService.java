package tw.tony.com.service;

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

import tw.tony.com.mapper.NewsMapper;
import tw.tony.com.po.AllNewsDetailed;
import tw.tony.com.vo.ResponseData;

@Service
public class NewsService {
	
	@Autowired
	private NewsMapper newsMapper;

	// 查整張表
	public ResponseData<IPage<AllNewsDetailed>> getAllNewsDetailed(Long pageNum) {
		System.out.println("pageNum  "+pageNum);
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 2);
        newsMapper.selectPage(page, null);
        System.out.println(JSON.toJSONString(page));

		return responseData(page);
	}
	
	
	//條件查詢(上架的)
	public ResponseData<IPage<AllNewsDetailed>> getNewsManyByPublic(Long pageNum){
		QueryWrapper<AllNewsDetailed> wrapper = new QueryWrapper<>(); 
		wrapper.eq("release_state", 0);
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 1);
        newsMapper.selectPage(page, wrapper);
        System.out.println(JSON.toJSONString(page));
        
        return responseData(page);
	}
	
	
	//條件查詢(上架的 TAG )
	@ResponseBody
	@PostMapping(value = "/search/getNewsManyByTag/{pageNum}")
	public ResponseData<IPage<AllNewsDetailed>> getNewsManyByTag(Long pageNum ,String tag){
		
		QueryWrapper<AllNewsDetailed> wrapper = new QueryWrapper<>(); 
		wrapper.eq("release_state", 0).eq("tag", tag);
        IPage<AllNewsDetailed> page = new Page<>(pageNum, 1);
        newsMapper.selectPage(page, wrapper);
        System.out.println(JSON.toJSONString(page));
        
        return responseData(page);
	}
	
	
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
	
	// 0 = 公開     1 = 下架.刪除(軟刪除)      
	@PostMapping(value = "/update/stateModify")
	@ResponseBody
	public ResponseData stateModifyNewsById(@RequestParam Integer id, @RequestParam Integer releaseState) {
		System.out.println("sdfds");
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
	
	
	
}
