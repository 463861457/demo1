package com.example.demo.controller;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2022-07-17 16:14:41
 */


@RestController
@RequestMapping("book")
public class BookController {

    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 分页查询
     *
     * @param book        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */

    @GetMapping("/ok")
    public ResponseEntity<Page<Book>> queryByPage(Book book, PageRequest pageRequest) {
        return ResponseEntity.ok(this.bookService.queryByPage(book, pageRequest));
    }
//    public ResponseEntity<Page<Book>> queryByPage(@PathVariable Integer page, @PathVariable Integer size) {
//        System.out.println("..................");
//        int page;
//        int size;
//        return ResponseEntity.ok(this.bookService.queryByPage(new Book(), PageRequest.of(page, size)));
//    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @Autowired  //从spring容器中拿到这个接口。
            BookDao bookDao;  //两步直接调用到数据库

    @GetMapping("{id}")   //$，daole符号；里面加上id，也就是具体链接地址。
    public ResponseEntity<Book> queryById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(this.bookService.queryById(id));   //这是MVC模式的结果
        return ResponseEntity.ok(bookDao.queryById(id));   //两步直接调用到数据库的响应结果
    }

    /**
     * 新增数据
     *
     * @param book 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Book> add(Book book) {
        return ResponseEntity.ok(this.bookService.insert(book));
    }

    /**
     * 编辑数据
     *
     * @param book 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Book> edit(Book book) {
        return ResponseEntity.ok(this.bookService.update(book));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.bookService.deleteById(id));
    }

}

