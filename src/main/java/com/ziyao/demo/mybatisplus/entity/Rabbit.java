package com.ziyao.demo.mybatisplus.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rabbit {

    @Id
    private String id;
    private String name;
    private String type;
}
