package info.chenqin.dao.crawler;

import info.chenqin.entity.crawler.CrawlerJobHistoryEntity;

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

public interface ICrawlerJobHistoryDao
{
    long insertANewCrawlerHistory(CrawlerJobHistoryEntity crawlerJobHistoryEntity);

    List<CrawlerJobHistoryEntity> queryByCrawlerTaskId(long crawlerTaskId);
}
