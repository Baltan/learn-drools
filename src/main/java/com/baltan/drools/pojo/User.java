package com.baltan.drools.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Baltan
 * @date 2020-06-27 10:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private List<String> hobbies;
    private Map<String, Object> tags;
}
