package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.dao.BookDao;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2022-07-17 16:14:42
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Book queryById(Integer id) {
        return this.bookDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param book 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Book> queryByPage(Book book, PageRequest pageRequest) {
        long total = this.bookDao.count(book);
        return new PageImpl<>(this.bookDao.queryAllByLimit(book, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book insert(Book book) {
        this.bookDao.insert(book);
        return book;
    }

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book update(Book book) {
        this.bookDao.update(book);
        return this.queryById(book.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bookDao.deleteById(id) > 0;
    }

}
