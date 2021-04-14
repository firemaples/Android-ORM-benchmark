package com.study.benchmarkorm.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.study.benchmarkorm.model.Person;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PersonDao {
    @Query("select * from person")
    List<Person> loadAll();

    @Query("select * from person LIMIT :limit")
    List<Person> loadAll(int limit);

    @Query("select * from person where id = :id")
    Person loadUserById(int id);

    @Insert(onConflict = IGNORE)
    void insert(Person person);

    @Delete
    void delete(Person person);

    @Update(onConflict = REPLACE)
    void update(Person person);

    @Insert(onConflict = IGNORE)
    void insertOrReplaceUsers(Person... persons);

    @Delete
    void deleteUsers(Person person1, Person person2);

    @Query("DELETE FROM Person")
    void deleteAll();
}