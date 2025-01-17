package com.study.benchmarkorm.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import com.study.benchmarkorm.db.utils.DateConverter;

import java.util.Date;

@Entity(foreignKeys = {@ForeignKey(entity = Library.class,
        parentColumns = "id",
        childColumns = "library_id")}, indices = {@Index("library_id")})
@TypeConverters(DateConverter.class)
public class Person {
    public @PrimaryKey(autoGenerate = true) long id;
    private String firstName;
    private String secondName;
    private Date birthdayDate;
    private String gender;
    private long phone;

    @ColumnInfo(name="library_id")
    private long libraryId;
        
    @Ignore
    private Library library;

    public Person() {
    }

    @Ignore
    public Person(String firstName, String secondName, Date birthdayDate, String gender, long phone, Library library) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthdayDate = birthdayDate;
        this.gender = gender;
        this.phone = phone;
        this.libraryId = library.id;
        this.library = library;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getLibraryId() {
        return libraryId;
    }
        
    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
    }
        
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
