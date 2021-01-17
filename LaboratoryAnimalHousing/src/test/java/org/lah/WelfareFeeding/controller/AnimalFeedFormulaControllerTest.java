package org.lah.WelfareFeeding.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lah.Commons.LahConstants;
import org.lah.Commons.domain.User;
import org.lah.WelfareFeeding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

/**
 * AnimalFeedFormulaController单元测试
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml", "classpath:springmvc-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnimalFeedFormulaControllerTest {
    // 自动注入依赖项
    @Autowired
    protected WebApplicationContext webApplicationContext;
    @Autowired
    private AnimalFeedFormulaController animalFeedFormulaController;
    private MockMvc mockMvc;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        assertNotNull(webApplicationContext);
        // 初始化Mock
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        assertNotNull(mockMvc);
        assertNotNull(animalFeedFormulaController);
        // 设定用户
        sessionattr = new HashMap<>();
        User user = new User();
        user.setDepartment("WelfareFeeding");
        user.setPosition("FeedingPlanner");
        sessionattr.put(LahConstants.USER_SESSION, user);
    }

    private HashMap<String, Object> sessionattr;

    /**
     * 测试请求不在数据库中的数据
     * @throws Exception 任意异常
     */
    @Test
    public void getNull() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/welfare-feeding/animal-feed-formula")
                        .param("feed_number", "not_in_db")
                        .sessionAttrs(sessionattr)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }

    /**
     * 测试请求数据库中的数据
     * @throws Exception 任意异常
     */
    @Test
    public void get() throws Exception {
        String ingredients = "米糠8% 大豆饼15% 酒糟2% 玉米40% 鱼粉4% 贝壳粉1% 水葫芦30%";
        String feedtype = "不存在的类型";
        String preservationconditions = "水分10%~12%，用双层袋保存，里面用不透气的塑料袋，外面用纺织袋，保存地保持通风条件好且干燥";
        Double qualityguaranteeperiod = 12.0;
        String instructions = "适合香猪等品种，不适合乳猪使用";

        // 添加数据
        String feedNumber = jdbcTemplate.queryForObject(String.format("CALL 2020rg_group13_p_add_animal_feed_formula('%s','%s','%s',%f,'%s')", ingredients, feedtype, preservationconditions, qualityguaranteeperiod, instructions), String.class);
        // 查询数据
        mockMvc.perform(
                MockMvcRequestBuilders.get("/welfare-feeding/animal-feed-formula")
                        .param("feed_number", feedNumber)
                        .sessionAttrs(sessionattr)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("feednumber").value(feedNumber))
                .andExpect(MockMvcResultMatchers.jsonPath("ingredients").value(ingredients))
                .andExpect(MockMvcResultMatchers.jsonPath("feedtype").value(feedtype))
                .andExpect(MockMvcResultMatchers.jsonPath("preservationconditions").value(preservationconditions))
                .andExpect(MockMvcResultMatchers.jsonPath("qualityguaranteeperiod").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("instructions").value(instructions))
                .andReturn();
        // 删除刚插入的数据
        jdbcTemplate.execute("delete from `2020rg_group13_animal_feed_formula` where FeedType='不存在的类型'");
    }

    /**
     * 测试插入数据
     * @throws Exception
     */
    @Test
    public void post() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/welfare-feeding/animal-feed-formula")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "    \"ingredients\": \"米糠8% 大豆饼15% 酒糟2% 玉米40% 鱼粉4% 贝壳粉1% 水葫芦30%\"," +
                                "    \"feedtype\": \"不存在的类型\"," +
                                "    \"preservationconditions\": \"水分10%~12%，用双层袋保存，里面用不透气的塑料袋，外面用纺织袋，保存地保持通风条件好且干燥\"," +
                                "    \"qualityguaranteeperiod\": 12," +
                                "    \"instructions\": \"适合香猪等品种，不适合乳猪使用\"" +
                                "}")
                        .sessionAttrs(sessionattr)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        // 删除刚插入的数据
        jdbcTemplate.execute("delete from `2020rg_group13_animal_feed_formula` where FeedType='不存在的类型'");
    }
}
