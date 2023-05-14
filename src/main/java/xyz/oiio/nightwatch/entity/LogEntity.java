package xyz.oiio.nightwatch.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@Slf4j
@Document(indexName = "logs")
public class LogEntity {

    @Id
    private String id;

    @Field(name = "@timestamp", type = FieldType.Date)
    private Date createAt;

    private String instance;

    private String message;

    private String thread_name;

    private String level;

    private String logger_name;

    private String caller_class_name;

    private String caller_file_name;

    private String caller_line_number;

    private String caller_method_name;
}
