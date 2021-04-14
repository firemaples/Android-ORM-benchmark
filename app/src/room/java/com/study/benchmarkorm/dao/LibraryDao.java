package com.study.benchmarkorm.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;


import com.study.benchmarkorm.db.utils.DateConverter;
import com.study.benchmarkorm.model.Library;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface LibraryDao {

    @Query("SELECT * From Library")
    List<Library> findAll();

    @Query("SELECT * From Library LIMIT :limit")
    List<Library> findAll(int limit);

    @Query("SELECT * From Library where id = :id")
    Library findById(int id);

    @Insert(onConflict = IGNORE)
    void insert(Library library);

    @Delete
    void delete(Library library);

    @Update(onConflict = REPLACE)
    void update(Library library);

    @Query("DELETE FROM Library")
    void deleteAll();
}
