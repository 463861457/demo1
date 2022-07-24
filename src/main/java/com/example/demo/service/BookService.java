package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Book)表服务接口
 *
 * @author makejava
 * @since 2022-07-17 16:14:42
 */
public interface BookService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Book queryById(Integer id);

    /**
     * 分页查询
     *
     * @param book 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Book> queryByPage(Book book, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book insert(Book book);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
