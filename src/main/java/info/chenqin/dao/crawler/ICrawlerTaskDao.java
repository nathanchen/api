package info.chenqin.dao.crawler;

import info.chenqin.entity.crawler.CrawlerTaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: nathanchen
 * <p>
 * Date: 14/10/16
 * <p>
 * Time: 3:12 PM
 * <p>
 * Description:
 */
@Mapper
public interface ICrawlerTaskDao
{
    long insertANewTask(CrawlerTaskEntity crawlerTaskEntity);

    int updateTaskStatus(@Param("taskId") long taskId, @Param("statusCode") int statusCode);

    List<CrawlerTaskEntity> queryAllActiveTask();

    List<CrawlerTaskEntity> queryByWebsite(String website);
}
