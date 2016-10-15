package info.chenqin.dao.crawler;

import info.chenqin.entity.crawler.CrawlerTaskEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: nathanchen
 * <p>
 * Date: 14/10/16
 * <p>
 * Time: 5:05 PM
 * <p>
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ICrawlerTaskDaoTest
{
    @Resource
    private ICrawlerTaskDao crawlerTaskDao;

    @Test
    public void testInsertANewTask() throws Exception
    {
        CrawlerTaskEntity crawlerTaskEntity = CrawlerTaskEntity.builder()
                .title("test").url("http://baidyu.com").website("Amazon").build();
        crawlerTaskDao.insertANewTask(crawlerTaskEntity);
    }

    @Test
    public void testUpdateTaskStatus() throws Exception
    {
        crawlerTaskDao.updateTaskStatus(20000, 0);
    }

    @Test
    public void testQueryAllActiveTask() throws Exception
    {
        List<CrawlerTaskEntity> crawlerTaskEntityList = crawlerTaskDao.queryAllActiveTask();
        printOutCrawlerTaskEntityList(crawlerTaskEntityList);
    }

    @Test
    public void testQueryByWebsite() throws Exception
    {
        List<CrawlerTaskEntity> crawlerTaskEntityList = crawlerTaskDao.queryByWebsite("Amazon");
        printOutCrawlerTaskEntityList(crawlerTaskEntityList);
    }

    private void printOutCrawlerTaskEntityList(List<CrawlerTaskEntity> crawlerTaskEntityList)
    {
        for (CrawlerTaskEntity crawlerTaskEntity : crawlerTaskEntityList)
        {
            System.out.println(crawlerTaskEntity);
        }
    }
}