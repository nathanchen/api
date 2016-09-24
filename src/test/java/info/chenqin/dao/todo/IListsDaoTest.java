package info.chenqin.dao.todo;

import info.chenqin.entity.todo.ListsEntity;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 15/09/2016
 * <p/>
 * Time: 9:03 AM
 * <p/>
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class IListsDaoTest
{
    @Resource
    private IListsDao listsDao;

    @org.junit.Test
    public void testInsertANewList() throws Exception
    {
        long id = listsDao.insertANewList("temp22");
        System.out.println(id);
    }

    @org.junit.Test
    public void testUpdateAListState() throws Exception
    {

    }

    @org.junit.Test
    public void testQueryById() throws Exception
    {
        long id = 1;
        ListsEntity aList = listsDao.queryById(id);
        System.out.println(aList);
    }

    @org.junit.Test
    public void testQueryAll() throws Exception
    {
        List<ListsEntity> listsEntities = listsDao.queryAll();
        for (ListsEntity listsEntity : listsEntities)
        {
            System.out.println(listsEntity);
        }
    }
}