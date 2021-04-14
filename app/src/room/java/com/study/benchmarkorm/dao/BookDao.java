package com.study.benchmarkorm.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.study.benchmarkorm.model.Book;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface BookDao {

    @Query("select * from Book where id = :id")
    Book loadBookrById(int id);

    @Query("SELECT * FROM Book")
    List<Book> findAll();

    @Query("SELECT * FROM Book LIMIT :limit")
    List<Book> findAll(int limit);

    @Insert(onConflict = IGNORE)
    void insert(Book book);

    @Update(onConflict = REPLACE)
    void update(Book book);

    @Query("DELETE FROM Book")
    void deleteAll();

    @Delete
    void delete(Book book);
}
