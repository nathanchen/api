package info.chenqin.entity.todo;

import lombok.Data;

import java.util.Date;

/**
 * User: nathanchen
 * <p/>
 * Date: 14/09/2016
 * <p/>
 * Time: 4:48 PM
 * <p/>
 * Description:
 */
@Data
public class ListsEntity
{
    private long listId;
    private String listName;
    private char isActive;
    private Date createTime;
}
