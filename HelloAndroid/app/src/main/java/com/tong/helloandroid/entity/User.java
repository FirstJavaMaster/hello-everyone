package com.tong.helloandroid.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tongpc32380
 * @date 2021/2/5 13:22
 */
@Entity(tableName = "user")
@Data
@NoArgsConstructor
public class User {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @Ignore
    public User(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
