package info.chenqin.dao.todo;

import info.chenqin.entity.todo.TodosEntity;

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
public interface ITodoDao
{
    long insertANewTodo(String subject, long listId);

    int updateATodoState(long todoId, int stateCode);

    TodosEntity queryById(long todoId);

    List<TodosEntity> queryAll();
}
