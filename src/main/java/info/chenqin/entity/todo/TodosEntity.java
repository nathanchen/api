package info.chenqin.entity.todo;

import lombok.Data;

import java.util.Date;

/**
 * User: nathanchen
 * <p/>
 * Date: 14/09/2016
 * <p/>
 * Time: 4:52 PM
 * <p/>
 * Description:
 */
@Data
public class TodosEntity
{
    private long todoId;
    private String subject;
    private char isActive;
    private Date createTime;
}
