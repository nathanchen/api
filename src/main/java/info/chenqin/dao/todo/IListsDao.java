package info.chenqin.dao.todo;

import info.chenqin.entity.todo.ListsEntity;

import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 14/09/2016
 * <p/>
 * Time: 4:55 PM
 * <p/>
 * Description:
 */
public interface IListsDao
{
    long insertANewList(String list_name);

    int updateAListState(long list_id, int stateCode);

    ListsEntity queryById(long listId);

    List<ListsEntity> queryAll();
}
