package info.chenqin.entity.crawler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: nathanchen
 * <p>
 * Date: 14/10/16
 * <p>
 * Time: 3:10 PM
 * <p>
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrawlerTaskEntity
{
    private long id;
    private String title;
    private String url;
    private String website;
    private char isActive;
    private String createTime;

    public CrawlerTaskEntity(String title, String url, String website)
    {
        this.title = title;
        this.url = url;
        this.website = website;
    }
}
