package info.chenqin.entity.crawler;

import lombok.Data;

/**
 * User: nathanchen
 * <p>
 * Date: 14/10/16
 * <p>
 * Time: 3:09 PM
 * <p>
 * Description:
 */
@Data
public class CrawlerJobHistoryEntity
{
    private long id;
    private long crawlerTaskId;
    private String data;
    private String createTime;
    private String extra;
}
