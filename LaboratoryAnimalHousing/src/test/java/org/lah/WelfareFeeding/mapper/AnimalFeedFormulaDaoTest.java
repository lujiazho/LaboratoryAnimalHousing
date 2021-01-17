package org.lah.WelfareFeeding.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lah.WelfareFeeding.domain.AnimalFeedFormula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * AnimalFeedFormulaDao单元测试
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml", "classpath:springmvc-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnimalFeedFormulaDaoTest {
    @Autowired
    protected WebApplicationContext webApplicationContext;
    @Autowired
    private AnimalFeedFormulaDao animalFeedFormulaDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AnimalFeedFormulaDaoTest() {
    }

    /**
     * 创建一个动物饲料配方对象
     * @return 动物饲料配方
     */
    public static AnimalFeedFormula createAnimalFeedFormula() {
        AnimalFeedFormula animalFeedFormula = new AnimalFeedFormula();
        animalFeedFormula.setFeedtype("混合型");
        animalFeedFormula.setIngredients("米糠8% 大豆饼15% 酒糟2% 玉米40% 鱼粉4% 贝壳粉1% 水葫芦30%");
        animalFeedFormula.setPreservationconditions("水分10%~12%，用双层袋保存，里面用不透气的塑料袋，外面用纺织袋，保存地保持通风条件好且干燥");
        animalFeedFormula.setQualityguaranteeperiod(12.0);
        animalFeedFormula.setInstructions("适合香猪等品种，不适合乳猪使用");
        return animalFeedFormula;
    }

    @Before
    public void setup() {
        assertNotNull(webApplicationContext);
        assertNotNull(animalFeedFormulaDao);
    }

    /**
     * 测试DAO能够正常插入、按主键查询、按主键删除
     */
    @Test
    public void save() {
        // 创建数据
        AnimalFeedFormula animalFeedFormula = createAnimalFeedFormula();
        // 插入数据
        String feedNumber = animalFeedFormulaDao.insert(animalFeedFormula);
        assertNotNull(feedNumber);
        // 取出数据
        AnimalFeedFormula queryResult = animalFeedFormulaDao.selectByPrimaryKey(feedNumber);
        assertNotNull(queryResult);
        assertEquals(feedNumber, queryResult.getFeednumber());
        assertEquals(animalFeedFormula.getFeedtype(), queryResult.getFeedtype());
        assertEquals(animalFeedFormula.getIngredients(), queryResult.getIngredients());
        assertEquals(animalFeedFormula.getPreservationconditions(), queryResult.getPreservationconditions());
        assertEquals(animalFeedFormula.getQualityguaranteeperiod(), queryResult.getQualityguaranteeperiod(), 0.001);
        assertEquals(animalFeedFormula.getInstructions(), queryResult.getInstructions());
        // 及时删除数据
        animalFeedFormulaDao.deleteByPrimaryKey(feedNumber);
    }
}
