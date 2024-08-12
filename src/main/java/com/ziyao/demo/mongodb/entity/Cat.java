package com.ziyao.demo.mongodb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cat {

    @Id
    private String id;
    private String name;
    private String type;
}
