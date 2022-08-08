package tw.tony.com.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.tony.com.mapper.NewsMapper;

import tw.tony.com.po.AllNewsDetailed;
import tw.tony.com.service.NewsService;
import tw.tony.com.vo.ResponseData;

@RequestMapping("/api/News")
@Controller
public class NewsSearchController {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private NewsMapper newsMapper;

	@Autowired
	private NewsService newsService;

	// 查整張表
	@ResponseBody
	@GetMapping(value = "/search/getAllNews/{pageNum}")
	public ResponseData<IPage<AllNewsDetailed>> getAllNewsDetailed(@PathVariable("pageNum") Long pageNum) {
		System.out.println("pageNum  "+pageNum);
		return newsService.getAllNewsDetailed(pageNum);
	}

	// 單筆查詢 ID
	@ResponseBody
	@PostMapping(value = "/search/getNewsById")
	public String getNewsById(@RequestParam String id) {

		AllNewsDetailed allNewsDetailed = newsMapper.selectById(id);

		try {
			String resultString = objectMapper.writeValueAsString(allNewsDetailed);
			System.out.println(resultString);
			return resultString;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}

	}

	// 查詢多個BY ID
	@ResponseBody
	@PostMapping(value = "/search/getNewsManyById")
	public String getNewsManyById(@RequestParam List<Integer> list) {

		List<AllNewsDetailed> allNewsDetailed = newsMapper.selectBatchIds(list);

		try {
			String resultString = objectMapper.writeValueAsString(allNewsDetailed);
			System.out.println(resultString);
			return resultString;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}

	}

	// 條件查詢(上架的)
	@ResponseBody
	@GetMapping(value = "/search/getNewsManyByPublic/{pageNum}")
	public ResponseData<IPage<AllNewsDetailed>> getNewsManyByPublic(@PathVariable("pageNum") Long pageNum) {
//		Map<String, Object> map =new HashMap<String, Object>();
//		map.put("release_state",0);

		return newsService.getNewsManyByPublic(pageNum);

	}

//---------------------新增**
	// 新增單筆(for表單)-
    @PostMapping(value = "/creatOneNews")
    public String creatOneNews( AllNewsDetailed allNewsDetailed) {
		int count = newsMapper.insert(allNewsDetailed);
		if (count >= 1) {
			return "redirect:/indexAdmin";
		} else {
			return "redirect:/indexAdmin";
		}      
    }

	// 新增單筆
	@PostMapping(value = "/create/setNews")
	@ResponseBody
	public String createNews(@RequestParam String author, @RequestParam String title, @RequestParam String content) {

		AllNewsDetailed allNewsDetailed = new AllNewsDetailed();
		allNewsDetailed.setAuthor(author);
		allNewsDetailed.setContent(content);
		allNewsDetailed.setTitle(title);

		int count = newsMapper.insert(allNewsDetailed);
		if (count >= 1) {
			return "創建成功";
		} else {

			return "創建失敗";
		}

	}

//--------------修改
	// 修改單筆(for表單)
    @PostMapping(value = "/modifyOneNews")
    public String modifyOneNews( AllNewsDetailed allNewsDetailed) {
    	int count = newsMapper.updateById(allNewsDetailed);
		if (count >= 1) {
			return "redirect:/indexAdmin";
		} else {
			return "redirect:/indexAdmin";
		}      
    }
	
	
	// 修改單筆
	@PostMapping(value = "/update/updateNews")
	@ResponseBody
	public String updateNewsById(@RequestParam Integer id, @RequestParam String author, @RequestParam String title,
			@RequestParam String content) {

		AllNewsDetailed allNewsDetailed = new AllNewsDetailed();
		allNewsDetailed.setId(id);
		allNewsDetailed.setAuthor(author);
		allNewsDetailed.setContent(content);
		allNewsDetailed.setTitle(title);

		int count = newsMapper.updateById(allNewsDetailed);
		if (count >= 1) {
			return "修改成功";
		} else {

			return "查無此ID";
		}

	}

	// 0 = 公開     1 = 下架.刪除(軟刪除)      
	@PostMapping(value = "/update/stateModify")
	@ResponseBody
	public ResponseData stateModifyNewsById(@RequestParam Integer id, @RequestParam Integer releaseState) {
		return newsService.stateModifyNewsById(id, releaseState);


	}

//--------------刪除
	// 刪除單筆(真實移除)
	@PostMapping(value = "/delete/deleteNews")
	@ResponseBody
	public String deleteNewsById(@RequestParam Integer id) {
		AllNewsDetailed allNewsDetailed = new AllNewsDetailed();
		allNewsDetailed.setId(id);
		int count = newsMapper.deleteById(id);
		if (count >= 1) {
			return "刪除成功";
		} else {

			return "查無此ID";
		}
	}

	// 刪除多筆(真實移除)
	@PostMapping(value = "/delete/deleteManyNews")
	@ResponseBody
	public String deleteManyNewsById(@RequestParam List<Integer> list) {

		int count = newsMapper.deleteBatchIds(list);
		if (count >= 1) {
			return "刪除成功 共" + count + "筆";
		} else {

			return "查無此ID";
		}
	}

	// 條件刪除(真實移除)
	@PostMapping(value = "/delete/deleteNewsByMap")
	@ResponseBody
	public String deleteManyNewsById(@RequestParam Map<String, Object> list) {

		int count = newsMapper.deleteByMap(list);
		if (count >= 1) {
			return "刪除成功 共" + count + "筆";
		} else {

			return "查無此條件";
		}
	}

//	@ResponseBody
//	@PostMapping(value = "/getNewsByTime")
//	public String getNewsByTime(@RequestParam String startTime,@RequestParam String endTime) {
//		
//		try {
//			String resultString = objectMapper.writeValueAsString(newsSearchService.getNewsByTime(startTime, endTime));
//			System.out.println(resultString);
//			return resultString;
//
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			return "";
//		}
//		
//	}

}
