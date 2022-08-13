//package tw.tony.com;
//
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//
//import tw.tony.com.mapper.AccountMapper;
//import tw.tony.com.po.Account;
//
//
//
//@SpringBootTest
//class NewsProjectApplicationTests {
//
//	@Autowired
//	AccountMapper accountMapper;
//
//	@Test
//	void testSelectList() {
//
////	  //通過條件構造器查詢一個List集合,沒條件可設置null
////	  List<Account> list = accountMapper.selectList(null);
////	  list.forEach(System.out::println);
//	}
//	@Test
//	void testinsert() {
////		//實現新增用戶
////		//INSERT INTO account (username, password) VALUES (? .?)
////		Account account = new Account();
////		account.setUsername("To77ry");
////		account.setPassword("123465");
////		int result =  accountMapper.insert(account);
////
////		System.out.println("result : "+result);
////		System.out.println("id : "+account.getId());
//	}
//
//	@Test
//	void testDelete() {
//
////		//通過ID刪除用戶
////		//DELETE FROM account WHWEW id=?
////		//雪花編排 過長 +L  int result = accountMapper.deleteById(1492767055210991617L);
////		int result = accountMapper.deleteById(93);
////		System.out.println("result : "+result);
//
////		//根據MAP集合中所設置的條件刪除用戶
////      //DELETE FROM account WHERE password = ? AND id = ? AND username = ?
////		Map<String, Object> map = new HashMap<>();
////		map.put("username", "tttt788thsr");
////		map.put("password", "123465");
////		int result = accountMapper.deleteByMap(map);
////		System.out.println("result : "+result);
//
////		//通過多個ID實現多個刪除
////		//DELETE FROM account WHERE id IN ( ? , ? , ? )
////		//List<Long> list=  Arrays.asList(1L,2L,3L);
////		List<Integer> list=  Arrays.asList(86,87,88);
////		accountMapper.deleteBatchIds(list);
//
//	}
//	@Test
//	void testUpdate() {
//
////		//修改用戶訊息BY ID
////		//UPDATE account SET username=? WHERE id=?
////		Account account = new Account();
////		account.setId(85);
////		account.setUsername("fff");
////		int result = accountMapper.updateById(account);
////		System.out.println("result : "+result);
//	}
//
//	@Test
//	void testSelect() {
////		//通過ID查詢用戶訊息
////		//SELECT id,username,password FROM account WHERE id=?
////		Account account = accountMapper.selectById(85);
////		System.out.println("account : "+account);
//
////		//根據多個ID 查詢多個用戶訊息
////		//SELECT id,username,password FROM account
////		List<Integer> list = Arrays.asList(85,95);
////		List<Account> account = accountMapper.selectBatchIds(list);
////		account.forEach(System.out::println);
//
////		//根據MAP集合中的條件查詢用戶訊息
////		//Preparing: SELECT id,username,password FROM account WHERE password = ? AND username = ?
////		Map<String, Object> map = new HashMap<>();
////		map.put("username", "fff");
////		map.put("password", "123465");
////		List<Account> result =  accountMapper.selectByMap(map);
////		result.forEach(System.out::println);
//
//		//查詢全部(不設條件 **一般只有在收尋時會不設條件 刪或改會一次全部)
//		//SELECT id,username,password FROM account
////		List<Account> account =  accountMapper.selectList(null);
////		account.forEach(System.out::println);
//
////		//自定義收尋 需再 src/main/java/xxx/com/mapper 裡添加自訂方法
//		//  resources/mapper 裡新增 .xml
////		Map<String, Object> map =  accountMapper.selectMapById(2);
////		System.out.println(map);
//
//
//	}
//
//}
